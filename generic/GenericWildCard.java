import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GenericWildCard{
	
	/**
	 * ���ͽṹֻ���롰�����������޶��½磨ʹ��extends��
	 * @param <E>
	 * @param list
	 */
	public static <E> void read(List<? extends E>list){
		for(E e:list){
			//ҵ���߼�����
		}
	}
	
	/**
	 * ���ͽṹֻ���롰д���������޶��½磨ʹ��super��
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
		Collections.copy(lb,la);//TODO ���´˷�����Դ��
		
		for(String e:lb){
			System.out.println(e);
		}
	}

}
