package classload_process;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
/**
 * 类加载机制：page[pdf:871,原书857]
 * 1>全盘负责
 * 2>父类委托
 * 3>缓存机制
 */
/**
 * 类加载器加载class大致经过以下8个步骤：
 * 1.检测此class是否载入过（即在缓存中是否有此class），如果有则直接进入第8步，否则接着执行第2步。
 * 2.如果父类加载器不存在（如果没有父加载器，则要么parent一定是根加载器，要么本身就是根加载器），
 * 		则跳到第4步执行，如果父加载器存在，则接着执行第3步。
 * 3.请求父类加载器载入目标类，如果成功载入则跳到第8步，不成功接着执行第5步。
 * 4.请求使用根加载器来载入目标类，如果成功则到8，如果不成功，则跳到第7步。
 * 5.寻找class文件（从与此classloader相关的类路径中寻找）。如果找到则执行6，如果找不到则跳到第7步。
 * 6.从文件中载入class，成功载入后跳到第8步。
 * 7.抛出ClassNoFoundException
 * 8.返回class
 * 其中5.6步允许重写ClassLoader的findClass方法来实现自己的载入策略。甚至重写loadClass方法来实现自己的载入过程。
 * 
 */
public class ClassLoader1822_1 {
	public static void main(String[] args) throws IOException {
		//获取系统类加载器
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器："+systemLoader);
		/*获取系统类加载器的加载路径：通常有CLASSPATH环境变量指定
		如果操作系统没指定CLASSPATH环境变量，默认已当前路径作为系统类加载器的加载路径
		*/
		Enumeration<URL> eml = systemLoader.getResources("");
		while(eml.hasMoreElements()){
			System.out.println(eml.nextElement());
		}
		
		//获取系统类加载器的父类加载器--应该得到扩展类加载器
		ClassLoader extensionLoader = systemLoader.getParent();
		System.out.println("扩展类加载器："+extensionLoader);
		System.out.println("扩展类加载的加载路径："+System.getProperty("java.ext.dirs"));
		System.out.println("扩展类加载器的父类："+extensionLoader.getParent());
	}

}
