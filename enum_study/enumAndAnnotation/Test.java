package enumAndAnnotation;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//��ʼ����ҵ�߼�
		Foo b = new Foo();		
		//��ȡע��
		Access access = b.getClass().getAnnotation(Access.class);
		System.out.println(access.level());
		//û��Access ע�����ǩȨʧ��
		if(access == null || !access.level().identify()){
			System.out.println(access.level().REFUSE_WORD);
		}
		System.out.println(b.getResource());
	}

}
