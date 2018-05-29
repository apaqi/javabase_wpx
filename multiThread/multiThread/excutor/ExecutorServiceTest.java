package multiThread.excutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by wpx on 2017/9/3.
 */
public class ExecutorServiceTest {
    private volatile Integer taskExecTimes = 0;
    ExecutorService pool = Executors.newFixedThreadPool(5);
    public void  submitTaks() throws Exception{
        /*pool.submit(new Runnable() {
            @Override
            public void run() {
                taskExecTimes ++;
               // System.out.println("Task Exec Times 1="+ taskExecTimes);
            }
        });*/
        Future<Integer> f = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                taskExecTimes ++;
                return taskExecTimes;
            }
        });
        taskExecTimes = f.get();
    }

    public int getTaskExecTimes(){
        return taskExecTimes;
    }
    public static void main(String[] args)throws Exception{
        ExecutorServiceTest multipleThread = new ExecutorServiceTest();
        for(int i=0;i<5;i++) {
            multipleThread.submitTaks();
        }
        System.out.println("Task Exec Times="+multipleThread.getTaskExecTimes());
    }
}
