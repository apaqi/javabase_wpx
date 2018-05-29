package instanceinnerclass;
/*1.内部类中，可以定义与外部类同名的成员，这时可以用this关键字来区分，
外部类的this引用形式为“外部类名.this”
*/

	class Basin{
		String land="盆地";
	}
	class Sichuan{
		private static int a=20;
		int b=50;
		Chengdu chengdu;
		Sichuan(){
			chengdu=new Chengdu();
		}
		void display(){
			System.out.println("我是四川");
			chengdu.speak();
		}
		protected class Chengdu extends Basin{//内部类
			int a;
			void speak(){
				System.out.println("我是四川,a="+this.a+":" +land);
			}
			void show(){
				this.a = Sichuan.this.a+b;
				display();
			}
		}
	}
public class InstanceInnerClass2 {
	public static void main(String[] args) {
		Sichuan sichuan = new Sichuan();
		sichuan.display();
		sichuan.chengdu.show();//在外部类的main方法或其他类中引用内部类，必须使用内部类的完整的标识。
	}

}
