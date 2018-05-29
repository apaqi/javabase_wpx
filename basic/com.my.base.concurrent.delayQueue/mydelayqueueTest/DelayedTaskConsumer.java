package com.my.base.concurrent.delayQueue.mydelayqueueTest;

import java.util.concurrent.DelayQueue;

/**
 * Created with IntelliJ IDEA.
 * User: wpx
 * Date: 15-3-15
 * Time: ÉÏÎç11:31
 * To change this template use File | Settings | File Templates.
 */
class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> q;
    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }
    public void run() {
        try {
            while(!Thread.interrupted())
                q.take().run(); // Run task with the current thread
        } catch(InterruptedException e) {
            // Acceptable way to exit
        }
        System.out.print("Finished DelayedTaskConsumer");
    }
}
