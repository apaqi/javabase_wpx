package basicTest;

public class Arrayparms {

	/**
	 * @param args
	 */
	static void g(int... args){
		System.out.println(args.getClass());
		System.out.println("length:"+args.length);
		StringBuilder sb = new StringBuilder(100);
		for(int i=0;i<args.length;i++){
			sb.append(args[i]);//args是个变量数组
		}
		System.out.println(sb.toString());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		g(1,2,4,5,6);

	}

}
