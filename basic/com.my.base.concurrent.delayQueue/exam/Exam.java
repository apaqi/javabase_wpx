package com.my.base.concurrent.delayQueue.exam;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.DelayQueue;

/**
 ҵ�񳡾�һ���࿼������

 �ó���������http://ideasforjava.iteye.com/blog/657384��ģ��һ�����Ե����ӣ�
 ����ʱ��Ϊ120���ӣ�30���Ӻ�ſɽ�����ʱ�䵽�ˣ���ѧ����������˿��Խ�����

 ��������м�������Ҫע�⣺
 1.����ʱ��Ϊ120���ӣ�30���Ӻ�ſɽ�����ʼ����������Ծ�ʱ����СӦΪ30����
 2.�����ܹ���120�����ڽ���Ŀ��������ʵ����Щ��������
 3.����120������û����ɿ��ԵĿ�������120���ӿ���ʱ�䵽����Ҫ������ǿ�ƽ���
 4.�����еĿ�������������Ҫ�������̹߳ر�

 ʵ��˼�룺��DelayQueue�洢������Student�ࣩ��ÿһ�����������Լ������ֺ�����Ծ��ʱ�䣬
 Teacher�̶߳�DelayQueue���м�أ���ȡ����Ծ�С��120���ӵ�ѧ�����Ծ�
 ������ʱ��120���ӵ�ʱ���ȹر�Teacher�̣߳�Ȼ��ǿ��DelayQueue�л����ڵĿ�������
 ÿһ���������������һ��countDownLatch.countDown()����countDownLatch.await()��������˵�����п�����������ˣ�����������ԡ�

 */

public class Exam {

    /**
     *
     *2014-1-10 ����9:43:48 by ����
     *
     *@param args
     *void
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        int studentNumber = 20;
        CountDownLatch countDownLatch = new CountDownLatch(studentNumber+1);
        DelayQueue< Student> students = new DelayQueue<Student>();
        Random random = new Random();
        for (int i = 0; i < studentNumber; i++) {
            students.put(new Student("student"+(i+1), 30+random.nextInt(120),countDownLatch));
        }
        Thread teacherThread =new Thread(new Teacher(students));
        students.put(new EndExam(students, 120,countDownLatch,teacherThread));
        teacherThread.start();
        countDownLatch.await();
        System.out.println(" ����ʱ�䵽��ȫ������");
    }

}
