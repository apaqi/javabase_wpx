package instanceinnerclass;
//ʵ���ڲ�����Լ̳������࣬��ȻҲ���Ա��̳У���ʱҪ�󱻼̳еĶ��������Ȼ��ԭ�����ⲿ��
//���������������
class Outer2{
	class Inner{
		
	}
}
class ExtendedOuter extends Outer2{
	class ExtendedInner extends Inner{}
	Inner ref = new ExtendedInner();
}
public class InnerClassExtends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*����ڲ����������ⲿ�಻���ⲿ������࣬��ʱӦ��ʹ�����·�����
class Unrelated extends Outer.Inner{
	Unrelated(Outer ref){
		ref.super();
	}
}
*/