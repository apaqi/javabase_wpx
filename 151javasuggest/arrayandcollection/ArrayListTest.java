package arrayandcollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> a = new ArrayList<String>();
		a.add("a");
		a.add("b");
		
		List<String> alist = a.subList(0, a.size()-1);
		for(String str:alist){
			System.out.println(str);
		}
		//设置列表为只读状态//对a 进行只读操作
		
		a = Collections.unmodifiableList(a);
		
		
	}

}
