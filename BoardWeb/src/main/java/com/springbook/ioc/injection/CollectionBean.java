package com.springbook.ioc.injection;

import java.util.Properties;

public class CollectionBean {
	private Properties mappings;

	public void setAddressList(Properties mappings) {
		this.mappings = mappings;
	}

	public Properties getAddressList() {
		return mappings;
	}
}
