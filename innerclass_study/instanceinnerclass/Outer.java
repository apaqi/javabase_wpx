package instanceinnerclass;

public class Outer {
	private int outProp = 9;
	class Inner{
		private int inProp = 5;
		public void acessOuterProp(){
			System.out.println("�ⲿ���outProp����ֵ��"+outProp);
		}
	}
	public void acessInnerProp(){
		//�ⲿ�಻��ֱ�ӷ��ʷǾ�̬�ڲ����ʵ�����ԣ�����Ĵ����Ǵ���ġ�
		//System.out.println("�ڲ����inProp��ʵ�����ԣ�"+inProp);
		//��������ڲ����ʵ�����ԣ��������ԵĴ����ڲ������
		System.out.println("�ڲ����inProp��ʵ�����ԣ�"+new Inner().inProp);
	}
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.acessInnerProp();
	}

}
