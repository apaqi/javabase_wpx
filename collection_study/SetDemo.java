

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
/** @description ����set�ıȽ�  
 * HashSet����ϣ����ͨ��ʹ�ó�Ϊɢ�з��Ļ������洢��Ϣ�ģ�Ԫ�ز�û����ĳ���ض�˳������ţ�   
 *LinkedHashSet����Ԫ�ز����˳����ά�����ϵ����ӱ������Բ����˳���ڼ����е�����   
 *TreeSet���ṩһ��ʹ�����ṹ�洢Set�ӿڵ�ʵ�֣�����������˳��洢�����ʺͱ�����ʱ��ܿ졣   
 *@author Zhou-Jingxian   *   */  
public class SetDemo {
	public static void main(String[] args) { 
	HashSet<String> hs = new HashSet<String>();         
	hs.add("B");          
	hs.add("A");          
	hs.add("D");          
	hs.add("E");          
	hs.add("C");          
	hs.add("F");          
	System.out.println("HashSet ˳��:\n"+hs);                    
	LinkedHashSet<String> lhs = new LinkedHashSet<String>();          
	lhs.add("B");          
	lhs.add("A");          
	lhs.add("D");          
	lhs.add("E");          
	lhs.add("C");          
	lhs.add("F");          
	System.out.println("LinkedHashSet ˳��:\n"+lhs);                    
	TreeSet<String> ts = new TreeSet<String>();          
	ts.add("B");          
	ts.add("A");          
	ts.add("D");          
	ts.add("E");          
	ts.add("C");          
	ts.add("F");          
	System.out.println("TreeSet ˳��:\n"+ts);     
	} 
}
