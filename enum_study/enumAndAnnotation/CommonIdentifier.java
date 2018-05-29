package enumAndAnnotation;

//签权接口实现类，并用枚举定义权限级别
 enum CommonIdentifier implements Identifier{
	//权限级别
	 Reader,Author,Admin;
	
	//实现签权
	@Override
	public boolean identify() {
		// TODO Auto-generated method stub
		//具体的签权
		return true;
	}

}
