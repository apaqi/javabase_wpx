package instanceinnerclass;

public class Outer {
	private int outProp = 9;
	class Inner{
		private int inProp = 5;
		public void acessOuterProp(){
			System.out.println("外部类的outProp属性值："+outProp);
		}
	}
	public void acessInnerProp(){
		//外部类不能直接访问非静态内部类的实例属性，下面的代码是错误的。
		//System.out.println("内部类的inProp的实例属性："+inProp);
		//如果访问内部类的实例属性，必须显性的创建内部类对象
		System.out.println("内部类的inProp的实例属性："+new Inner().inProp);
	}
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.acessInnerProp();
	}

}
