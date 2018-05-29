package instanceinnerclass;
//实例内部类可以继承其他类，当然也可以被继承，这时要求被继承的对象必须仍然和原来的外部类
//或者子类相关联。
class Outer2{
	class Inner{
		
	}
}
class ExtendedOuter extends Outer2{
	class ExtendedInner extends Inner{}
	Inner ref = new ExtendedInner();
}
public class InnerClassExtends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*如果内部类的子类的外部类不是外部类的子类，这时应该使用以下方法：
class Unrelated extends Outer.Inner{
	Unrelated(Outer ref){
		ref.super();
	}
}
*/