

import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
	/*Hashtable �� Vector����ͨ��ͬ���ķ� װ����
	��Collections.synchronizedMap()��synchronizedList()�� synchronizedSet()����
	����ļ��Ͼ��ɱ���Ϊ�̰߳�ȫ�ġ�
	java.util.concurrent ������˶���µ��̰߳�ȫ�����ࣨConcurrentHashMap��CopyOnWriteArrayList�� CopyOnWriteArraySet����
	��Щ���Ŀ�����ṩ�����ܡ��߶ȿ������ԡ��̰߳�ȫ�Ļ����������Ͱ汾�� 
	*/
	///http://blog.csdn.net/kun81/article/details/5848996
	//http://www.csdnjava.com/forum.php?mod=viewthread&tid=35281
	//http://blog.csdn.net/itm_hadf/article/details/7506529
	public static void main(String[] args) {
		//1.Hashtable �̰߳�ȫ
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();//��ϣ��ľ�������<key,value>;
		ht.put("love", 3);
		ht.put("hate", 4);
		System.out.println(ht.get("love"));
		//2.����Vector���ʵ�֣��̰߳�ȫ
		Vector<String> v = new Vector<String>();
		v.add("wpx");
		v.add("bj");
		System.out.println(v.get(1));
		//3.
		ConcurrentHashMap currentHaseMap = new ConcurrentHashMap();
	}

}
