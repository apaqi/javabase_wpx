package anonymousinnerclass;
	/*�����ڲ�����Ҫ���򷽷��Ĳ�����ֵ*/

//test()��Ҫһ��Product������Ϊ����������Productֻ��һ���ӿڣ��޷�ֱ�Ӵ����������
//�˴����Ǵ���һ��Product�ӿ�ʵ����Ķ�����÷���
interface Product{
	public double getPrice();
	public String getName();
}
public class TestAnonymous {
	public void test(Product p){
		System.out.println("������һ����"+p.getName()+"��������"+p.getPrice());
	}
	public static void main(String[] args) {
		TestAnonymous ta = new TestAnonymous();
		ta.test(new Product() {
			
			@Override  //�൱��ʵ�ֽӿ�
			public double getPrice() {
				// TODO Auto-generated method stub
				return 342.8;
			}
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "AGP�Կ�";
			}
		});
	}
}
