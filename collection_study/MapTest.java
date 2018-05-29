

import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
	/*Hashtable 和 Vector），通过同步的封 装工厂
	（Collections.synchronizedMap()、synchronizedList()和 synchronizedSet()），
	其余的集合均可表现为线程安全的。
	java.util.concurrent 包添加了多个新的线程安全集合类（ConcurrentHashMap、CopyOnWriteArrayList和 CopyOnWriteArraySet）。
	这些类的目的是提供高性能、高度可伸缩性、线程安全的基本集合类型版本。 
	*/
	///http://blog.csdn.net/kun81/article/details/5848996
	//http://www.csdnjava.com/forum.php?mod=viewthread&tid=35281
	//http://blog.csdn.net/itm_hadf/article/details/7506529
	public static void main(String[] args) {
		//1.Hashtable 线程安全
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();//哈希表的就像这样<key,value>;
		ht.put("love", 3);
		ht.put("hate", 4);
		System.out.println(ht.get("love"));
		//2.看下Vector类的实现，线程安全
		Vector<String> v = new Vector<String>();
		v.add("wpx");
		v.add("bj");
		System.out.println(v.get(1));
		//3.
		ConcurrentHashMap currentHaseMap = new ConcurrentHashMap();
	}

}
