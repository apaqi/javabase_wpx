package basicTest;

import java.util.Arrays;

public class ArrayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] array2 = new int[1][];
		System.out.println("Result:"+Arrays.deepToString(array2));
		
		
		//方式一：申明数组
		int[] a = new int[3];
		//方式二：聚集初始化,只能在声明的地方赋值
		int b[] = {1,2,3,4};
		//方式二：动态聚集初始化，可以在任何地方赋值
		int[] c;
		c = new int[]{1,2,3};
	}

}
