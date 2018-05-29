package classload_process;
/**
 * 一个类被加载到JVM中后，使用其全限定名【包名和类名】
 * 作为唯一标识，使得同一个类不会被多次加载
 */

/**
 *JVM启动时，会形成由三个加载器组成的初始化类加载器层次结构
 *1.Bootstrap ClassLoader:根类加载器【引导类加载器、原始类加载器】
 *	1>在JVM中使用java.exe 时，使用 -Xbootclasspath选项或者使用 -D选项，指定sun.boot.class.path系统属性值就可以指定加载附加的类
 *  2>根类加载器是JVM自身实现的，不是java.lang.ClassLoader的子类 ！！
 *
 *2.Extension ClassLoader:扩展类加载器
 *	1>加载jre的扩展目录（JAVA_HOME/jre/lib/ext 或者由java.ext.dire系统属性指定的目录）中jar的类包。可以把自己的jar包放在其中，进行扩展。
 *	2>是java.lang.ClassLoader的子类 
 *3.System ClassLoader:系统类加载器
 *	1>JVM启动时，加载来自java中的 -classpath选项或java.class.path系统属性，或者CLASSPATH环境变量【根目录下的lib目录下】所指定的JAR包和类路径
 *	2>可以通过ClassLoader.getSyetemClassLoader()获取该加载器
 *	3>是java.lang.ClassLoader的子类 
 */

public class ClassLoader1821_0 {

	//1:
	private static  int a = 10;
	//2:
	static int b=10;
	static int c;//不初始化，会默认值
	
	static{
		b=6;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("a:"+a+":b:"+b+"c:"+c);
		
	}

}
