package instanceinnerclass;
/*1.�ڲ����У����Զ������ⲿ��ͬ���ĳ�Ա����ʱ������this�ؼ��������֣�
�ⲿ���this������ʽΪ���ⲿ����.this��
*/

	class Basin{
		String land="���";
	}
	class Sichuan{
		private static int a=20;
		int b=50;
		Chengdu chengdu;
		Sichuan(){
			chengdu=new Chengdu();
		}
		void display(){
			System.out.println("�����Ĵ�");
			chengdu.speak();
		}
		protected class Chengdu extends Basin{//�ڲ���
			int a;
			void speak(){
				System.out.println("�����Ĵ�,a="+this.a+":" +land);
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
		sichuan.chengdu.show();//���ⲿ���main�������������������ڲ��࣬����ʹ���ڲ���������ı�ʶ��
	}

}
