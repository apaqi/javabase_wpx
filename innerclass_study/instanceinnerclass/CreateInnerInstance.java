package instanceinnerclass;

class Out{
	class In{
		public In(){
			//���췽��
		}
		public void say(String str){
			System.out.println("��˵��"+str);
		}
	}
}
public class CreateInnerInstance {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Out.In in = new Out().new In();
		in.say("ȥ���ү�ģ�");
	}

}
