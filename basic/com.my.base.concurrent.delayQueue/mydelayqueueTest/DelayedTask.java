package com.my.base.concurrent.delayQueue.mydelayqueueTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * Created with IntelliJ IDEA.
 * User: wpx
 * Date: 15-3-15
 * Time: 上午11:30
 * To change this template use File | Settings | File Templates.
 */
class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence = new ArrayList<DelayedTask>();
    public DelayedTask(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        trigger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS);
        sequence.add(this);
    }
    public long getDelay(TimeUnit unit) {
        return unit.convert(
                trigger - System.nanoTime(), NANOSECONDS);
    }
    public int compareTo(Delayed arg) {
        DelayedTask that = (DelayedTask)arg;
        if(trigger < that.trigger) return -1;
        if(trigger > that.trigger) return 1;
        return 0;
    }
    public void run() { System.out.println(this + " "); }
    public String toString() {
        return String.format("[%1$-4d]", delta) +" Task " + id+"当前时间："+new Date();
    }
    public String summary() {
        return "(" + id + ":" + delta + ")";
    }

    /**
     *此功能不错 TODO
     */
    public static class EndSentinel extends DelayedTask {
        private ExecutorService exec;
        public EndSentinel(int delay, ExecutorService e) {
            super(delay);
            exec = e;
        }
        public void run() {
            for(DelayedTask pt : sequence) {
                System.out.println(pt.summary() + " ");
            }
            System.out.println(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}
