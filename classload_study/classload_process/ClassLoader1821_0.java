package classload_process;
/**
 * һ���౻���ص�JVM�к�ʹ����ȫ�޶�����������������
 * ��ΪΨһ��ʶ��ʹ��ͬһ���಻�ᱻ��μ���
 */

/**
 *JVM����ʱ�����γ���������������ɵĳ�ʼ�����������νṹ
 *1.Bootstrap ClassLoader:������������������������ԭʼ���������
 *	1>��JVM��ʹ��java.exe ʱ��ʹ�� -Xbootclasspathѡ�����ʹ�� -Dѡ�ָ��sun.boot.class.pathϵͳ����ֵ�Ϳ���ָ�����ظ��ӵ���
 *  2>�����������JVM����ʵ�ֵģ�����java.lang.ClassLoader������ ����
 *
 *2.Extension ClassLoader:��չ�������
 *	1>����jre����չĿ¼��JAVA_HOME/jre/lib/ext ������java.ext.direϵͳ����ָ����Ŀ¼����jar����������԰��Լ���jar���������У�������չ��
 *	2>��java.lang.ClassLoader������ 
 *3.System ClassLoader:ϵͳ�������
 *	1>JVM����ʱ����������java�е� -classpathѡ���java.class.pathϵͳ���ԣ�����CLASSPATH������������Ŀ¼�µ�libĿ¼�¡���ָ����JAR������·��
 *	2>����ͨ��ClassLoader.getSyetemClassLoader()��ȡ�ü�����
 *	3>��java.lang.ClassLoader������ 
 */

public class ClassLoader1821_0 {

	//1:
	private static  int a = 10;
	//2:
	static int b=10;
	static int c;//����ʼ������Ĭ��ֵ
	
	static{
		b=6;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("a:"+a+":b:"+b+"c:"+c);
		
	}

}
