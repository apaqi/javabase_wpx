package enumAndAnnotation;

//ǩȨ�ӿ�ʵ���࣬����ö�ٶ���Ȩ�޼���
 enum CommonIdentifier implements Identifier{
	//Ȩ�޼���
	 Reader,Author,Admin;
	
	//ʵ��ǩȨ
	@Override
	public boolean identify() {
		// TODO Auto-generated method stub
		//�����ǩȨ
		return true;
	}

}
