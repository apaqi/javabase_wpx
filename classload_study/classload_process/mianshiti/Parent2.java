package classload_process.mianshiti;

/**
 * Created by wpx on 2017/9/3.
 */
public class Parent2 {
    // ��̬����
    public static String p_StaticField = "����--��̬����";
    // ����(��ʵ���ö����������ͬ��һ�㣬��ר��дһ�����ʵ��)
    //�������������ڳ�ʼ����ĺ��棬�ǻᱨ��ģ���Ϊ�����û�б���ʼ��
    public String p_Field = "����--����";
    // ��̬��ʼ����
    static {
        System.out.println(p_StaticField);
        System.out.println("����--��̬��ʼ����");
    }
    // ��ʼ����
    {
        System.out.println(p_Field);
        System.out.println("����--��ʼ����");
    }
    // ������
    public Parent2() {
        System.out.println("����--������");
    }
}
