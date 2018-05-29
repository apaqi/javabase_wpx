package com.my.base.concurrent.delayQueue.cache;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: wpx
 * Date: 15-3-10
 * Time: ÏÂÎç11:16
 * To change this template use File | Settings | File Templates.
 */
class DelayedItem<T> implements Delayed {

    private T t;
    private long liveTime ;
    private long removeTime;

    public DelayedItem(T t,long liveTime){
        this.setT(t);
        this.liveTime = liveTime;
        this.removeTime = TimeUnit.NANOSECONDS.convert(liveTime, TimeUnit.NANOSECONDS) + System.nanoTime();
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == null) return 1;
        if (o == this) return  0;
        if (o instanceof DelayedItem){
            DelayedItem<T> tmpDelayedItem = (DelayedItem<T>)o;
            if (liveTime > tmpDelayedItem.liveTime ) {
                return 1;
            }else if (liveTime == tmpDelayedItem.liveTime) {
                return 0;
            }else {
                return -1;
            }
        }
        long diff = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return diff > 0 ? 1:diff == 0? 0:-1;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(removeTime - System.nanoTime(), unit);
    }

    public T getT() {
        return t;
    }
     //addded by wpx begin
    public void setT(T t) {
        this.t = t;
    }

    public long getLiveTime() {
        return liveTime;
    }
    //addded by wpx ended
    public void setLiveTime(long liveTime) {
        this.liveTime = liveTime;
    }

    @Override
    public int hashCode(){
        return t.hashCode();
    }

    @Override
    public boolean equals(Object object){
        if (object instanceof DelayedItem) {
            return object.hashCode() == hashCode() ?true:false;
        }
        return false;
    }

}
