package classload_process;
//���ʼ��ʱ��
/**
 * 1.�������ʵ����new��ͨ�����䴴��ʵ����ͨ�������л�����ʵ��
 * 2.����ĳ����ľ�̬������
 * 3.����ĳ������߽ӿڵľ�̬���ԣ���Ϊ�þ�̬���Ը�ֵ��final������ʱ�����ܻ�ȡ��������ֵ�����Ǳ���ʱ����
 * 4.ʹ�÷��䷽ʽ��ǿ�ƴ���ĳ������߽ӿڶ�Ӧ��java.lang.class�����磺class.forName()��
 * 5.��ʼ��ĳ��������࣬����ʼ��ĳ���������ʱ������������и��඼����ʼ����
 * 6.ֱ��ʹ��java.exe����������ĳ�����࣬������ĳ������ʱ��������ȳ�ʼ�������ࡣ
 */
class MyTest{
	static {
		System.out.println("��̬��ʼ��ģ�顣��");
	}
	//�ڱ���ʱ���ͱ���ʼ�����൱�ڳ���������(1)�д��벻�ܳ�ʼ��
	static final String str = "����ˮ�̡̳���";
	//������ʱ������ȷ����ֵ������(1)�д��뱻��ʼ��
	static final String str2 = "����ˮ�̳�2����"+System.currentTimeMillis();
}
//�������ַ�ʽ���ֽ����ļ�
public class TimeOfClassInit1815 {

	public static void main(String[] args) {
		//System.out.println(MyTest.str);//(1)
		System.out.println(MyTest.str2);//(2)
	}
}
