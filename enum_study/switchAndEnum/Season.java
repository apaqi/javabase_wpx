package switchAndEnum;

public enum Season {
	Spring("��"),Summer("��"),Autumn("��"),Winter("��");
	
	private String desc;
	
	Season(String desc){
		this.desc = desc;
	}
	//��ȡö������

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
