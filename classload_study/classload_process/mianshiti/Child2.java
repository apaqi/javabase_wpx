package classload_process.mianshiti;

/**
 * Created by wpx on 2017/9/3.
 *@see  http://blog.csdn.net/wanggg2760/article/details/51790687
 *
 * 在这段代码中，子类和父类中都有static变量和static代码块，父类中有无参的构造方法，从上面执行的结果可以得出下面结论：
 * 1、当代码进入到子类的main方法时，此时不执行main()方法中的任何语句，这时候会先开始按顺序先加载父类的static变量、static代码块，
 *    再加载子类的static变量、static代码块；
 * 2、当父类和子类的static变量和代码块加载完之后，开始按顺序执行main方法中的语句System.out.println("*************in main***************");；
 * 3、执行完println语句之后，此时new一个子类对象，由于子类继承父类，此时会先按顺序初试化父类中的变量、代码块、构造方法，
 *    然后再初始化子类变量、代码块、构造方法。其中变量最先初始化创建，其次是代码块，构造方法最后创建；
 * 4、当new完一个子类对象之后，再new第二个子类对象时，由于static变量与方法还有代码块在内存中只加载一遍，
 *    此时父类和子类已经加载了一遍，所以不会再次加载
 * 5、当把子类main方法中的代码都删掉
 *
 */
public class Child2 extends Parent2 {
    // 静态变量
    public static String s_StaticField = "子类--静态变量";
    // 变量
    public String s_Field = "子类--变量";
    // 静态初始化块
    static {
        System.out.println(s_StaticField);
        System.out.println("子类--静态初始化块");
    }
    // 初始化块
    {
        System.out.println(s_Field);
        System.out.println("子类--初始化块");
    }
    // 构造器
    public Child2() {
        //super();
        System.out.println("子类--构造器");
    }
    // 程序入口
    public static void main(String[] args) {
        System.out.println("*************in main***************");
        new Child2();
        System.out.println("*************second subClass***************");
        new Child2();
    }
}
