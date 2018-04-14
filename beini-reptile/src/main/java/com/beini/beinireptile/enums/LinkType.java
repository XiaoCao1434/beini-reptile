package com.beini.beinireptile.enums;

public enum LinkType {
	LINKS(100,"links"),
	MEDIA(101,"media"),
	IMPORTS(102,"imports")
	;
	
	private Integer code;
	private String name;
	LinkType(Integer code,String name){
		this.code = code;
		this.name = name;
	}
	public Integer getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
}
