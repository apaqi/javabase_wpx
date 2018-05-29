package classload_process;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
/**
 * ����ػ��ƣ�page[pdf:871,ԭ��857]
 * 1>ȫ�̸���
 * 2>����ί��
 * 3>�������
 */
/**
 * �����������class���¾�������8�����裺
 * 1.����class�Ƿ�����������ڻ������Ƿ��д�class�����������ֱ�ӽ����8�����������ִ�е�2����
 * 2.�����������������ڣ����û�и�����������Ҫôparentһ���Ǹ���������Ҫô������Ǹ�����������
 * 		��������4��ִ�У���������������ڣ������ִ�е�3����
 * 3.���������������Ŀ���࣬����ɹ�������������8�������ɹ�����ִ�е�5����
 * 4.����ʹ�ø�������������Ŀ���࣬����ɹ���8��������ɹ�����������7����
 * 5.Ѱ��class�ļ��������classloader��ص���·����Ѱ�ң�������ҵ���ִ��6������Ҳ�����������7����
 * 6.���ļ�������class���ɹ������������8����
 * 7.�׳�ClassNoFoundException
 * 8.����class
 * ����5.6��������дClassLoader��findClass������ʵ���Լ���������ԡ�������дloadClass������ʵ���Լ���������̡�
 * 
 */
public class ClassLoader1822_1 {
	public static void main(String[] args) throws IOException {
		//��ȡϵͳ�������
		ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
		System.out.println("ϵͳ���������"+systemLoader);
		/*��ȡϵͳ��������ļ���·����ͨ����CLASSPATH��������ָ��
		�������ϵͳûָ��CLASSPATH����������Ĭ���ѵ�ǰ·����Ϊϵͳ��������ļ���·��
		*/
		Enumeration<URL> eml = systemLoader.getResources("");
		while(eml.hasMoreElements()){
			System.out.println(eml.nextElement());
		}
		
		//��ȡϵͳ��������ĸ��������--Ӧ�õõ���չ�������
		ClassLoader extensionLoader = systemLoader.getParent();
		System.out.println("��չ���������"+extensionLoader);
		System.out.println("��չ����صļ���·����"+System.getProperty("java.ext.dirs"));
		System.out.println("��չ��������ĸ��ࣺ"+extensionLoader.getParent());
	}

}
