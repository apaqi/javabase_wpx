package classload_process;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 	JVM�г��˸�����֮������������������ClassLoader�������ʵ����
 * ClassLoader����������Ҫ������
 * 1.loadClass(String name,boolean resolve)
 * 	�÷�����ClassLoader����ڵ㣬����ָ���Ķ����������������࣬ϵͳ���ǵ���
 * 	ClassLoader�ĸ÷�������ȡָ�����Ӧ��Class����
 * 2.findClass(String name)
 * 	���ݶ�����������������
 * 3.Class  defineClass(String name,byte[] b,int off,int len),�÷�������
 * 	ָ������ֽ����ļ������ֽ�����:byte[] b�ڣ�������ת��ΪClass���󣬸��ֽ����ļ�����
 * 	��Դ���ļ�������ȡ�
 *����֮�⣬classLoader�ﻹ����һЩ��ͨ������
 *	4.findSystemClass(String name):
 *	�ӱ����ļ�ϵͳ�����ļ�������ҵ�������defineClass��ԭʼ���ֽ��뻻��Class�����ѽ����ļ�
 *	ת�����ࡣ
 *	5.getParent()��ȡ�丸�������
 *	6.getSystemClassLoader()�˾�̬�������ڷ���ϵͳ���������
 *	7.resolveClass(Class<?> c):����ָ�����ࡣ�����������ʹ�ô˷�����������c.
 *	8.findLoaderClass(String name):�����java������Ѿ�װ������name���࣬��ֱ�ӷ��ظ����Ӧ
 *		��Classʵ�������򣬷���null.�÷�����java�����໺����Ƶ����֡�
 */ 

 /** �����Զ���ClassLoader������ͨ����д��������������ʵ�֣������Ƽ���дfindClass()
 * ��������������дloadClass()��������ΪloadClass()��ִ�в������£�
 * 	1>��findLoaderClass(String)������Ƿ��Ѿ������࣬����Ѿ����أ���ֱ�ӷ��ء�
 * 	2>�ڸ���������ϵ���loadClass������������������Ϊnull����ʹ�ø��������������
 * 	3>����findClass()���������ࡣ
 * 	��������Կ�������дfindClass()�������Ա��⸲��Ĭ����������ĸ���ί�У�����������ֲ���
 * 	�����дloadClass()��������ʵ���߼���Ϊ����
 */

public class CreateClassLoader1821_0 extends ClassLoader{

	//��ȡһ���ļ�������
	private byte[] getBytes(String filename) throws IOException{
		File file = new File(filename);
		long len = file.length();
		byte[] raw = new byte[(int)len];
		FileInputStream fin = new FileInputStream(file);
		//һ�ζ�ȡclass�ļ���ȫ������������
		int r = fin.read(raw);
		if(r != len)
			throw new IOException("�޷���ȡȫ���ļ���"+r+"!="+len);
		fin.close();
		return raw;
	}
	//�������ָ��java�ļ��ķ���
	private boolean compile(String javaFile) throws IOException{
		System.out.println("CompileClassLoader:���ڱ���"+javaFile+".....");
		//����ϵͳ��javac����
		Process p = Runtime.getRuntime().exec("javac"+javaFile);
		try{
			//�����̶߳��ȴ�����߳����
			p.waitFor();
		}catch(InterruptedException ie){
			System.out.println(ie.getMessage());
		}
		//��ȡjavac�̵߳��˳�ֵ
		int ret = p.exitValue();
		//���ر����Ƿ�ɹ�
		return ret == 0;
		
	}
	//��дClassLoader ��findClass����
	protected Class<?> finClass(String name) throws ClassNotFoundException{
		Class clazz = null;
		//����·�����ܵĵ�(.)�滻��б��(/).
		String fileStub = name.replace(".", "/");
		String javaFilename = fileStub+".java";
		String classFilename = fileStub+".class";
		File javaFile = new File(javaFilename);
		File classFile = new File(classFilename);
		//��ָ��javaԴ�ļ����ڣ���class�ļ������ڣ�����javaԴ�ļ�
		//���޸�ʱ���class�ļ��޸�ʱ����ʱ�����±���
		if(javaFile.exists() && (!classFile.exists()||javaFile.lastModified()>classFile.lastModified())){
			try{
				//�������ʧ�ܣ����߸�class�ļ�������
				if(!compile(javaFilename)||!classFile.exists()){
					throw new ClassNotFoundException("ClassNotFoundException:"+javaFilename);
				}
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
		//���class�ļ����ڣ�ϵͳ���𽫸��ļ�ת����Class����
		if(classFile.exists()){
			try{
				//��class�ļ��Ķ��������ݶ�������
				byte[] raw = getBytes(classFilename);
				//����ClassLoader��defineClass()������������ת��ΪClass����
				clazz = defineClass(name,raw,0,raw.length);
			
			}catch(IOException ie ){
				ie.printStackTrace();
			}
		}
		//���clazzΪnull����������ʧ�ܣ����׳��쳣
		if(clazz == null){
			throw new ClassNotFoundException(name);
		}
		return clazz;
	}
	public static void main(String[] args) throws Exception{
		//������иó���ʱû�в�������û��Ŀ����
		if(args.length<1){
			System.out.println("ȱ�����е�Ŀ���࣬�밴���¸�ʽ����javaԴ�ļ�");
			System.out.println("java compileclassloader classname");
		}
		//��һ����������Ҫ���е���
		String progClass = args[0];
		//ʣ�µĲ�������Ϊ����Ŀ����ʱ�Ĳ��������Խ���Щ�������Ƶ�һ����������
		String progArgs[] = new String[args.length-1];
		System.arraycopy(args, 1, progArgs, 0, progArgs.length);
		CreateClassLoader1821_0 cc1 = new CreateClassLoader1821_0();
		//������Ҫ���е���
		Class<?> clazz = cc1.loadClass(progClass);
		//��ȡ��Ҫ���е����������
		Method main = clazz.getMethod("main", (new String[0]).getClass());
		Object argsArray[] = {progArgs};
		
		

	}

}
