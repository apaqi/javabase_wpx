import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GenericWildCard{
	
	/**
	 * 泛型结构只参与“读”操作则限定下界（使用extends）
	 * @param <E>
	 * @param list
	 */
	public static <E> void read(List<? extends E>list){
		for(E e:list){
			//业务逻辑处理
		}
	}
	
	/**
	 * 泛型结构只参与“写”操作则限定下界（使用super）
	 */
	public static <E> void write(List<? super Number> list){
		list.add(123);//int
		list.add(3.5);//float
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> la = new ArrayList<String>();
		la.add("222");
		
		List<String> lb = new ArrayList<String>();
		lb.add("eeee");
		lb.add("fdsf");
		Collections.copy(lb,la);//TODO 看下此方法的源码
		
		for(String e:lb){
			System.out.println(e);
		}
	}

}
