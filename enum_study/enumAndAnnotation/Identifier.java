package enumAndAnnotation;

//ACL:access contrl list [访问控制列表]
/*ACL三要素：
1,资源，有哪些信息是要被控制起来的
2，权限级别，不同的访问者规划在不同的级别中
3，控制器【即签权人】。控制不同的级别访问不同的资源
*/
public interface Identifier {//签权接口
	//无权访问时的礼貌用语
	String REFUSE_WORD ="您无权访问";
	//签权
	public boolean identify();
}
