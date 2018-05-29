package com.my.base.concurrent.delayQueue.mydelayqueueTest;//: concurrency/DelayQueueDemo.java

import java.util.concurrent.*;
public class DelayQueueDemo {
  public static void main(String[] args) {
    ExecutorService exec = Executors.newCachedThreadPool();
    DelayQueue<DelayedTask> queue = new DelayQueue<DelayedTask>();
    //ÃÌº”»ŒŒÒ
    queue.put(new DelayedTask(10000));
    queue.put(new DelayedTask(20000));
    queue.put(new DelayedTask(5000));
    queue.put(new DelayedTask(5000));


    // Set the stopping point£¨stop all the task  after 5000 MILLISECONDS
    //queue.add(new DelayedTask.EndSentinel(5000, exec));
    exec.execute(new DelayedTaskConsumer(queue));
  }
}