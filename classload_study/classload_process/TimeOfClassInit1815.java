package classload_process;
//类初始化时机
/**
 * 1.创建类的实例。new；通过反射创建实例；通过反序列化创建实例
 * 2.调用某个类的静态方法。
 * 3.访问某个类或者接口的静态属性，或为该静态属性赋值【final在运行时才能能获取到的属性值，而非编译时】。
 * 4.使用反射方式来强制创建某个类或者接口对应的java.lang.class对象。如：class.forName()等
 * 5.初始化某个类的子类，当初始化某个类的子类时，该子类的所有父类都被初始化。
 * 6.直接使用java.exe命令来运行某个主类，当运行某个主类时，程序会先初始化该主类。
 */
class MyTest{
	static {
		System.out.println("静态初始化模块。。");
	}
	//在编译时，就被初始化，相当于常量，所以(1)行代码不能初始化
	static final String str = "互灌水教程。。";
	//在运行时，才能确定其值，所以(1)行代码被初始化
	static final String str2 = "互灌水教程2。。"+System.currentTimeMillis();
}
//看下两种方式的字节码文件
public class TimeOfClassInit1815 {

	public static void main(String[] args) {
		//System.out.println(MyTest.str);//(1)
		System.out.println(MyTest.str2);//(2)
	}
}
