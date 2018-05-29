package switchAndEnum;

public class SwitchTest {
	//当switch的入参是枚举时，要加null判断,否则抛异常
	public static void doSports(Season season){
		//加null 判断 
		if(null == season){
			System.out.println("输入错误");
			return;
		}
			switch(season){// 实质：season.ordinal
			case Spring: //Seeson.Spring.ordinal
				System.out.println("春天放风筝！");
				break;
			case Summer:
				System.out.println("夏天游泳！");
				break;
			case Autumn:
				System.out.println("秋天赏红叶！");
				break;
			case Winter:
				System.out.println("冬天滑雪！");
				break;
			default :
				System.out.println("输入错误");
				break;
			}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doSports(null);
		doSports(Season.Spring);
	}

}
