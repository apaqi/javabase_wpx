package switchAndEnum;

public class SwitchTest {
	//��switch�������ö��ʱ��Ҫ��null�ж�,�������쳣
	public static void doSports(Season season){
		//��null �ж� 
		if(null == season){
			System.out.println("�������");
			return;
		}
			switch(season){// ʵ�ʣ�season.ordinal
			case Spring: //Seeson.Spring.ordinal
				System.out.println("����ŷ��ݣ�");
				break;
			case Summer:
				System.out.println("������Ӿ��");
				break;
			case Autumn:
				System.out.println("�����ͺ�Ҷ��");
				break;
			case Winter:
				System.out.println("���컬ѩ��");
				break;
			default :
				System.out.println("�������");
				break;
			}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doSports(null);
		doSports(Season.Spring);
	}

}
