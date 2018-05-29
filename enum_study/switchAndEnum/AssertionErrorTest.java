package switchAndEnum;

public class AssertionErrorTest {
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
				//当枚举类添加新的季节时，会在编译时抛出异常，
				//以免酿成严重的后果，例如：如果不是季节，而是日志级别时。
				throw new AssertionError();
			}	
	}
	public static void main(String[] args) {
		doSports(Season.Spring);
		
	}

}
