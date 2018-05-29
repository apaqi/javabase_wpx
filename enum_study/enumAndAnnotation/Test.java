package enumAndAnnotation;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//初始化商业逻辑
		Foo b = new Foo();		
		//获取注解
		Access access = b.getClass().getAnnotation(Access.class);
		System.out.println(access.level());
		//没有Access 注解或者签权失败
		if(access == null || !access.level().identify()){
			System.out.println(access.level().REFUSE_WORD);
		}
		System.out.println(b.getResource());
	}

}
