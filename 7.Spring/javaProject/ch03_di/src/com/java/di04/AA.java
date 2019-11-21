package com.java.di04;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class AA {
	private String name;
	private List<String> list;
	private Map<String, String> map;
	private Set<String> set;
	private Properties properties;

	public void setName(String name) {
		this.name = name;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "AA [name=" + name + ", list=" + list + ", map=" + map + ", set="
				+ set + ", properties=" + properties + "]";
	}

}
