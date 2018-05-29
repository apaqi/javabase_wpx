package classload_process.mianshiti;

/**
 * Created by wpx on 2017/9/3.
 */
public class Parent {
    public Parent(){
        System.out.println("Parent");
    }
    {
        System.out.println("Parent class");
    }
    static {
        System.out.println("static Parent");
    }
}
