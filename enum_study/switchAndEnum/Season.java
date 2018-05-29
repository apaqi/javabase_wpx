package switchAndEnum;

public enum Season {
	Spring("´º"),Summer("ÏÄ"),Autumn("Çï"),Winter("¶¬");
	
	private String desc;
	
	Season(String desc){
		this.desc = desc;
	}
	//»ñÈ¡Ã¶¾ÙÃèÊö

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
