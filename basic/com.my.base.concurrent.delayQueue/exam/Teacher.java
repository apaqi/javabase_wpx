package com.my.base.concurrent.delayQueue.exam;

import java.util.concurrent.DelayQueue;

/**
 * Created with IntelliJ IDEA.
 * User: wpx
 * Date: 15-3-10
 * Time: ÏÂÎç10:32
 * To change this template use File | Settings | File Templates.
 */
class Teacher implements Runnable{

    private DelayQueue<Student> students;
    public Teacher(DelayQueue<Student> students){
        this.students = students;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            System.out.println(" test start");
            while(!Thread.interrupted()){
                students.take().run();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
