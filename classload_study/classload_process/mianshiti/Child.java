package classload_process.mianshiti;

/**
 * Created by wpx on 2017/9/3.
 *@see  http://blog.csdn.net/wanggg2760/article/details/51790687
 */
public class Child extends Parent {
    public Child(){
        System.out.println("Child");
    }
    {
        System.out.println("Child class");
    }
    static {
        System.out.println("static Child");
    }
    public static void main(String[] args){
        // System.out.println("###################");
        Child child = new Child();
    }
}
