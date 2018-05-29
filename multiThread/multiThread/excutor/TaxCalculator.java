package multiThread.excutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
//税款计算器
public class TaxCalculator implements Callable<Integer> {

	//本金
	private int seedMoney;
	//接收主线程提供的参数
	public TaxCalculator(int _seedMoney){
		seedMoney = _seedMoney;
	}
	@Override
	public Integer call() throws Exception {
		// 模拟复杂运算，运行一次需要10秒
		TimeUnit.MILLISECONDS.sleep(1000);
		return seedMoney/10;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//生产一个单线程的异步执行器
		ExecutorService es = Executors.newSingleThreadExecutor();
		//线程执行后的期望值
		Future<Integer> future = es.submit(new TaxCalculator(100));
		while(!future.isDone()){
			//还没有运算完成，等待20毫秒
			TimeUnit.MILLISECONDS.sleep(200);
			//输出进度号
			System.out.print("#");
		}
		System.out.println("\n计算完成，税金是："+future.get()+"元");
		es.shutdown();

	}

}
