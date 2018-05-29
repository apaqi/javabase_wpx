package multiThread.forkjoin;

import java.util.concurrent.RecursiveAction;

/**
 * Created by wpx on 2017/9/7.
 */
public class PrintTask extends RecursiveAction {
    // ÿ��"С����"���ֻ��ӡ20����
    private static final int MAX = 20;

    private int start;
    private int end;

    PrintTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        // ��end-start��ֵС��MAXʱ�򣬿�ʼ��ӡ
        if ((end - start) < MAX) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "��iֵ:"
                        + i);
            }
        } else {
            // ��������ֽ������С����
            int middle = (start + end) / 2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);
            // ����ִ������С����
            left.fork();
            right.fork();
        }
    }
}
