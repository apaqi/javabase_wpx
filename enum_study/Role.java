
public enum Role {
	ADNIN("����Ա",new Lifetime(4),new Scope("admin")),
	USER("��ͨ�û�",new Lifetime(10),new Scope("nomal"));
	//��������
	private String name;
	//��ɫ��������
	private Lifetime lifeTime;
	//Ȩ�޷�Χ
	private Scope scope;
	
	Role (String name,Lifetime lifeTime,Scope scope){
		this.name = name;
		this.lifeTime = lifeTime;
		this.scope =scope;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLifeTime() {
		return lifeTime.getLifeTime();// TODO
	}

	public void setLifeTime(Lifetime lifeTime) {
		this.lifeTime = lifeTime;
	}

	public String getScope() {
		return scope.getScope();
	}

	public void setScope(Scope scope) {
		this.scope = scope;
	}

}
