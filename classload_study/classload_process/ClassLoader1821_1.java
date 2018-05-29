package classload_process;

import java.net.URL;


//看根类加载器加载了哪些核心类库
public class ClassLoader1821_1 {
	public static void main(String[] args) {
		URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for(int i=0;i<urls.length;i++){
			System.out.println(urls[i].toExternalForm());
		}
		
	}

}
