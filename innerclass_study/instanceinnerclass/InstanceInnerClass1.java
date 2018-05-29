package instanceinnerclass;
//实例内部类

/*如果内部类出现在外部类成员变量声明的位置（即不出现在代块中），并且没有用static修饰，
那么这个类就是实例内部类*/
public class InstanceInnerClass1 {
	class Information{
		private int year;
		private String inf;
		Information(int year,String inf){
			this.year = year;
			this.inf = inf;
		}
		public void showinfo(){
			System.out.println(year+"年,欢迎来到"+inf);
		}
	}
	public void userInner(String infomation){
		Information info = new Information(2012, infomation);
		info.showinfo();
	}
	public static void main(String[] args) {
		InstanceInnerClass1 u = new InstanceInnerClass1();
		u.userInner("京东商城");
	}

}
