package classload_process;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 	JVM中除了根加载之外的所有类加载器都是ClassLoader的子类的实例。
 * ClassLoader类有三个主要方法：
 * 1.loadClass(String name,boolean resolve)
 * 	该方法是ClassLoader的入口点，根据指定的二进制名称来加载类，系统就是调用
 * 	ClassLoader的该方法来获取指定类对应的Class对象
 * 2.findClass(String name)
 * 	根据二进制名称来查找类
 * 3.Class  defineClass(String name,byte[] b,int off,int len),该方法负责将
 * 	指定类的字节码文件读入字节数组:byte[] b内，并把它转化为Class对象，该字节码文件可以
 * 	来源于文件、网络等。
 *除此之外，classLoader里还包含一些普通方法：
 *	4.findSystemClass(String name):
 *	从本地文件系统载入文件，如果找到，就用defineClass将原始的字节码换成Class对象，已将该文件
 *	转换成类。
 *	5.getParent()获取其父类加载器
 *	6.getSystemClassLoader()此静态方法用于返回系统类加载器。
 *	7.resolveClass(Class<?> c):链接指定的类。类加载器可以使用此方法来链接类c.
 *	8.findLoaderClass(String name):如果此java虚拟机已经装载了名name的类，则直接返回该类对应
 *		的Class实例，否则，返回null.该方法是java加载类缓存机制的体现。
 */ 

 /** ！！自定义ClassLoader，可以通过重写以上两个方法来实现，但是推荐重写findClass()
 * 方法，而不是重写loadClass()方法，因为loadClass()的执行步骤如下：
 * 	1>用findLoaderClass(String)来检查是否已经加载类，如果已经加载，则直接返回。
 * 	2>在父类加载器上调用loadClass方法。如果父类加载器为null，则使用根类加载器来加载
 * 	3>调用findClass()方法查找类。
 * 	从上面可以看出，重写findClass()方法可以避免覆盖默认类加载器的父类委托，缓存机制两种策略
 * 	如果重写loadClass()方法，则实现逻辑更为复杂
 */

public class CreateClassLoader1821_0 extends ClassLoader{

	//读取一个文件的内容
	private byte[] getBytes(String filename) throws IOException{
		File file = new File(filename);
		long len = file.length();
		byte[] raw = new byte[(int)len];
		FileInputStream fin = new FileInputStream(file);
		//一次读取class文件的全部二进制数据
		int r = fin.read(raw);
		if(r != len)
			throw new IOException("无法读取全部文件："+r+"!="+len);
		fin.close();
		return raw;
	}
	//定义编译指定java文件的方法
	private boolean compile(String javaFile) throws IOException{
		System.out.println("CompileClassLoader:正在编译"+javaFile+".....");
		//调用系统的javac命令
		Process p = Runtime.getRuntime().exec("javac"+javaFile);
		try{
			//其他线程都等待这个线程完成
			p.waitFor();
		}catch(InterruptedException ie){
			System.out.println(ie.getMessage());
		}
		//获取javac线程的退出值
		int ret = p.exitValue();
		//返回编译是否成功
		return ret == 0;
		
	}
	//重写ClassLoader 的findClass方法
	protected Class<?> finClass(String name) throws ClassNotFoundException{
		Class clazz = null;
		//将包路径汇总的点(.)替换成斜线(/).
		String fileStub = name.replace(".", "/");
		String javaFilename = fileStub+".java";
		String classFilename = fileStub+".class";
		File javaFile = new File(javaFilename);
		File classFile = new File(classFilename);
		//当指定java源文件存在，且class文件不存在，或者java源文件
		//的修改时间比class文件修改时间晚时，重新编译
		if(javaFile.exists() && (!classFile.exists()||javaFile.lastModified()>classFile.lastModified())){
			try{
				//如果编译失败，或者该class文件不存在
				if(!compile(javaFilename)||!classFile.exists()){
					throw new ClassNotFoundException("ClassNotFoundException:"+javaFilename);
				}
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		//如果class文件存在，系统负责将该文件转换成Class对象
		if(classFile.exists()){
			try{
				//将class文件的二进制数据读入数组
				byte[] raw = getBytes(classFilename);
				//调用ClassLoader的defineClass()方法将二进制转换为Class对象
				clazz = defineClass(name,raw,0,raw.length);
			
			}catch(IOException ie ){
				ie.printStackTrace();
			}
		}
		//如果clazz为null，表明加载失败，则抛出异常
		if(clazz == null){
			throw new ClassNotFoundException(name);
		}
		return clazz;
	}
	public static void main(String[] args) throws Exception{
		//如果运行该程序时没有参数，即没有目标类
		if(args.length<1){
			System.out.println("缺少运行的目标类，请按如下格式运行java源文件");
			System.out.println("java compileclassloader classname");
		}
		//第一个参数是需要运行的类
		String progClass = args[0];
		//剩下的参数将作为运行目标类时的参数，所以将这些参数复制到一个新数组中
		String progArgs[] = new String[args.length-1];
		System.arraycopy(args, 1, progArgs, 0, progArgs.length);
		CreateClassLoader1821_0 cc1 = new CreateClassLoader1821_0();
		//加载需要运行的类
		Class<?> clazz = cc1.loadClass(progClass);
		//获取需要运行的类的主方法
		Method main = clazz.getMethod("main", (new String[0]).getClass());
		Object argsArray[] = {progArgs};
		
		

	}

}
