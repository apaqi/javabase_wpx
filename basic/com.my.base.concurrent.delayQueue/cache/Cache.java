package com.my.base.concurrent.delayQueue.cache;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;

/**
 业务场景二：具有过期时间的缓存

 该场景来自于http://www.cnblogs.com/jobs/archive/2007/04/27/730255.html，
 向缓存添加内容时，给每一个key设定过期时间，系统自动将超过过期时间的key清除。

 这个场景中几个点需要注意：

 当向缓存中添加key-value对时，如果这个key在缓存中存在并且还没有过期，
 需要用这个key对应的新过期时间

 为了能够让DelayQueue将其已保存的key删除，需要重写实现Delayed接口添加到DelayQueue的
 DelayedItem的hashCode函数和equals函数
 当缓存关闭，监控程序也应关闭，因而监控线程应当用守护线程
 */
public class Cache<K, V> {

    public ConcurrentHashMap<K, V> map = new ConcurrentHashMap<K, V>();
    public DelayQueue<DelayedItem<K>> queue = new DelayQueue<DelayedItem<K>>();


    public void put(K k,V v,long liveTime){
        V v2 = map.put(k, v);
        DelayedItem<K> tmpItem = new DelayedItem<K>(k, liveTime);
        if (v2 != null) {
            queue.remove(tmpItem);
        }
        queue.put(tmpItem);
    }

    public Cache(){
        Thread t = new Thread(){
            @Override
            public void run(){
                dameonCheckOverdueKey();
            }
        };
        t.setDaemon(true);
        t.start();
    }

    /**
     * 将到期的数据poll出来
     */
    public void dameonCheckOverdueKey(){
        while (true) {
            DelayedItem<K> delayedItem = queue.poll();
            if (delayedItem != null) {
                map.remove(delayedItem.getT());
                System.out.println(System.nanoTime()+" remove "+delayedItem.getT() +" from cache liveTime="+delayedItem.getLiveTime());
            }
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
    /**
     * TODO
     * @param args
     * 2014-1-11 上午11:30:36
     * @author: 孙振超
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        //设置缓存
        Random random = new Random();
        int cacheNumber = 10;
        int liveTime = 0;
        Cache<String, Integer> cache = new Cache<String, Integer>();

        for (int i = 0; i < cacheNumber; i++) {
            liveTime = random.nextInt(300000);
           //System.out.println(i+"  "+liveTime);
            cache.put(i+"", i, random.nextInt(liveTime));
        }
        Thread.sleep(3000);
        System.out.println();
    }

}