package org.springframework.beans.entity;

import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

public class Father {

	private String name;

	private Children children;

//	public Father(Children children) {
//		this.children = children;
//	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Children getChildren() {
		return children;
	}

	public void setChildren(Children children) {
		this.children = children;
	}
}
