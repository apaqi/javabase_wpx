package multiThread.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by wpx on 2017/9/7.
 */
public class RecursiveActionTest {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // ��������Runtime.getRuntime().availableProcessors()����ֵ��Ϊ�����Ĳ����̵߳�ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // �ύ�ɷֽ��PrintTask����
        forkJoinPool.submit(new PrintTask(0, 1000));
        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);//������ǰ�߳�ֱ�� ForkJoinPool �����е�����ִ�н���
        // �ر��̳߳�
        forkJoinPool.shutdown();
    }
}
