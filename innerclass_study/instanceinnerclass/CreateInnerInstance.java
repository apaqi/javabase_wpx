package instanceinnerclass;

class Out{
	class In{
		public In(){
			//构造方法
		}
		public void say(String str){
			System.out.println("我说："+str);
		}
	}
}
public class CreateInnerInstance {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Out.In in = new Out().new In();
		in.say("去你大爷的！");
	}

}
