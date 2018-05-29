package multiThread.excutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
//˰�������
public class TaxCalculator implements Callable<Integer> {

	//����
	private int seedMoney;
	//�������߳��ṩ�Ĳ���
	public TaxCalculator(int _seedMoney){
		seedMoney = _seedMoney;
	}
	@Override
	public Integer call() throws Exception {
		// ģ�⸴�����㣬����һ����Ҫ10��
		TimeUnit.MILLISECONDS.sleep(1000);
		return seedMoney/10;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//����һ�����̵߳��첽ִ����
		ExecutorService es = Executors.newSingleThreadExecutor();
		//�߳�ִ�к������ֵ
		Future<Integer> future = es.submit(new TaxCalculator(100));
		while(!future.isDone()){
			//��û��������ɣ��ȴ�20����
			TimeUnit.MILLISECONDS.sleep(200);
			//������Ⱥ�
			System.out.print("#");
		}
		System.out.println("\n������ɣ�˰���ǣ�"+future.get()+"Ԫ");
		es.shutdown();

	}

}
