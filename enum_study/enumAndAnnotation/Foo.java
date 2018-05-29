package enumAndAnnotation;
/*定义资源类*/
//@Access(level = CommonIdentifier.Author)
@Access(level = CommonIdentifier.Author)
public class Foo {
	
	
	public String getResource(){
		
		return "你有权访问资源！";
	}
}
