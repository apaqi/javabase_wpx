package localclass;
//�����Ҫ�þֲ��ڲ��ඨ�����������ʵ�������������࣬��ֻ���ھֲ��ڲ������ڵķ����ڽ��С�
public class LocalInnerClass {
	public static void main(String[] args) {
		//����ֲ��ڲ���
		class InnerBase{
			int a;
		}
		//����ֲ��ڲ��������
		class InnerSub extends InnerBase{
			int b;
		}
		//�����ֲ��ڲ���Ķ���
		InnerSub is = new InnerSub();
		is.a = 5;
		is.b = 8;
		System.out.println("a:"+is.a +"\t"+"b:"+is.b);
	}

}
