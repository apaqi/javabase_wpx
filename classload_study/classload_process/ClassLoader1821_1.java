package classload_process;

import java.net.URL;


//�������������������Щ�������
public class ClassLoader1821_1 {
	public static void main(String[] args) {
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for(int i=0;i<urls.length;i++){
			System.out.println(urls[i].toExternalForm());
		}
		
	}

}
