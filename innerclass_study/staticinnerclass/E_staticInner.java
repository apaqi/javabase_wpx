package staticinnerclass;
/*����ڲ���������ⲿ���Ա����������λ�ã����������ڴ����У���������static���Σ�
��ô�������Ǿ�̬�ڲ��ࡣ���һ���ڲ����Ǿ�̬�ģ���ô�������Ƕ����࣬���޸��ࡣ
��̬�ڲ����п���������̬��Ա�����Ǿ�̬�ڲ����в����ԡ�
ʹ�þ�̬�ڲ���������
1>����ϣ�������ڲ��࣬�ڲ��಻��Ҫ�����ⲿ��Ա��
2>��Ҫ���ڲ����ж��徲̬��Ա��
3>���������ظ������Խ��������ඨ��Ϊpublic�ľ�̬�ڲ��࣬������ʹ�á��ⲿ����.�ڲ���������ʽ��
�����ڲ����ʶ�����á�
##�����԰��ڲ��ඨ��Ϊ�������ӿڣ���ʱ������������ӿڱ�������һ���ڲ������̳л�ʵ�֡�
*/


public class E_staticInner {
	public static class Student{
		int no;
		String name;
		int age;
		static int count = 0;
		Student(int no,String name,int age){
			this.no = no;
			this.name = name;
			this.age = age;
			count++;
		}
		public void show(){
			System.out.println("��ţ�"+count+"\t"+no+"\t"+name+"\t"+age);
		}
		
	}
	public static void main(String[] args) {
		E_staticInner.Student s1 = new E_staticInner.Student(1234,"����",23);
		s1.show();
		E_staticInner.Student s2 = new E_staticInner.Student(2234,"����",24);
		s2.show();
	}

}
