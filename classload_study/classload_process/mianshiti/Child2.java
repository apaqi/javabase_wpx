package classload_process.mianshiti;

/**
 * Created by wpx on 2017/9/3.
 *@see  http://blog.csdn.net/wanggg2760/article/details/51790687
 *
 * ����δ����У�����͸����ж���static������static����飬���������޲εĹ��췽����������ִ�еĽ�����Եó�������ۣ�
 * 1����������뵽�����main����ʱ����ʱ��ִ��main()�����е��κ���䣬��ʱ����ȿ�ʼ��˳���ȼ��ظ����static������static����飬
 *    �ټ��������static������static����飻
 * 2��������������static�����ʹ���������֮�󣬿�ʼ��˳��ִ��main�����е����System.out.println("*************in main***************");��
 * 3��ִ����println���֮�󣬴�ʱnewһ�����������������̳и��࣬��ʱ���Ȱ�˳����Ի������еı���������顢���췽����
 *    Ȼ���ٳ�ʼ���������������顢���췽�������б������ȳ�ʼ������������Ǵ���飬���췽����󴴽���
 * 4����new��һ���������֮����new�ڶ����������ʱ������static�����뷽�����д�������ڴ���ֻ����һ�飬
 *    ��ʱ����������Ѿ�������һ�飬���Բ����ٴμ���
 * 5����������main�����еĴ��붼ɾ��
 *
 */
public class Child2 extends Parent2 {
    // ��̬����
    public static String s_StaticField = "����--��̬����";
    // ����
    public String s_Field = "����--����";
    // ��̬��ʼ����
    static {
        System.out.println(s_StaticField);
        System.out.println("����--��̬��ʼ����");
    }
    // ��ʼ����
    {
        System.out.println(s_Field);
        System.out.println("����--��ʼ����");
    }
    // ������
    public Child2() {
        //super();
        System.out.println("����--������");
    }
    // �������
    public static void main(String[] args) {
        System.out.println("*************in main***************");
        new Child2();
        System.out.println("*************second subClass***************");
        new Child2();
    }
}