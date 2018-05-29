package staticinnerclass;
/*如果内部类出现在外部类成员变量声明的位置（即不出现在代块中），并且有static修饰，
那么这个类就是静态内部类。如果一个内部类是静态的，那么这个类就是顶级类，即无父类。
静态内部类中可以声明静态成员，而非静态内部类中不可以。
使用静态内部类的情况：
1>仅仅希望隐藏内部类，内部类不需要访问外部成员。
2>需要在内部类中定义静态成员。
3>避免类名重复。可以将重名的类定义为public的静态内部类，其他类使用“外部类名.内部类名”形式的
完整内部类标识来引用。
##还可以把内部类定义为抽象类或接口，此时，这个抽象类或接口必须有另一个内部类来继承或实现。
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
			System.out.println("序号："+count+"\t"+no+"\t"+name+"\t"+age);
		}
		
	}
	public static void main(String[] args) {
		E_staticInner.Student s1 = new E_staticInner.Student(1234,"张三",23);
		s1.show();
		E_staticInner.Student s2 = new E_staticInner.Student(2234,"张四",24);
		s2.show();
	}

}
