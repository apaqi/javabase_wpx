package enumAndAnnotation;

//ACL:access contrl list [���ʿ����б�]
/*ACL��Ҫ�أ�
1,��Դ������Щ��Ϣ��Ҫ������������
2��Ȩ�޼��𣬲�ͬ�ķ����߹滮�ڲ�ͬ�ļ�����
3������������ǩȨ�ˡ������Ʋ�ͬ�ļ�����ʲ�ͬ����Դ
*/
public interface Identifier {//ǩȨ�ӿ�
	//��Ȩ����ʱ����ò����
	String REFUSE_WORD ="����Ȩ����";
	//ǩȨ
	public boolean identify();
}
