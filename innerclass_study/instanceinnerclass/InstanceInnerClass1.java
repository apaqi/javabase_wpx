package instanceinnerclass;
//ʵ���ڲ���

/*����ڲ���������ⲿ���Ա����������λ�ã����������ڴ����У�������û����static���Σ�
��ô��������ʵ���ڲ���*/
public class InstanceInnerClass1 {
	class Information{
		private int year;
		private String inf;
		Information(int year,String inf){
			this.year = year;
			this.inf = inf;
		}
		public void showinfo(){
			System.out.println(year+"��,��ӭ����"+inf);
		}
	}
	public void userInner(String infomation){
		Information info = new Information(2012, infomation);
		info.showinfo();
	}
	public static void main(String[] args) {
		InstanceInnerClass1 u = new InstanceInnerClass1();
		u.userInner("�����̳�");
	}

}
