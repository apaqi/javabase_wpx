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
		//�����б�Ϊֻ��״̬//��a ����ֻ������
		
		a = Collections.unmodifiableList(a);
		
		
	}

}
