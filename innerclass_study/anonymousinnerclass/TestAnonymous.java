package anonymousinnerclass;
	/*匿名内部类主要是向方法的参数传值*/

//test()需要一个Product对象作为参数，但是Product只是一个接口，无法直接创建对象，因此
//此处考虑创建一个Product接口实现类的对象传入该方法
interface Product{
	public double getPrice();
	public String getName();
}
public class TestAnonymous {
	public void test(Product p){
		System.out.println("购买了一个："+p.getName()+"，花掉了"+p.getPrice());
	}
	public static void main(String[] args) {
		TestAnonymous ta = new TestAnonymous();
		ta.test(new Product() {
			
			@Override  //相当与实现接口
			public double getPrice() {
				// TODO Auto-generated method stub
				return 342.8;
			}
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "AGP显卡";
			}
		});
	}
}
