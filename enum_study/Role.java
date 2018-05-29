
public enum Role {
	ADNIN("管理员",new Lifetime(4),new Scope("admin")),
	USER("普通用户",new Lifetime(10),new Scope("nomal"));
	//中文描述
	private String name;
	//角色的生命期
	private Lifetime lifeTime;
	//权限范围
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
