package classload_process;

public class ClassInit1814 {

	//1:
	private static  int a = 10;
	//2:
	static int b;
	static int c;//����ʼ������Ĭ��ֵ
	
	static{
		b=6;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("a:"+a+":b:"+b+"c:"+c);
		
	}

}
