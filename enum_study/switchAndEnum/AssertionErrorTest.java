package switchAndEnum;

public class AssertionErrorTest {
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
				//��ö��������µļ���ʱ�����ڱ���ʱ�׳��쳣��
				//����������صĺ�������磺������Ǽ��ڣ�������־����ʱ��
				throw new AssertionError();
			}	
	}
	public static void main(String[] args) {
		doSports(Season.Spring);
		
	}

}
