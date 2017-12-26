package com.mrl.spring.beans.collection;

import java.util.Properties;

/**
 * @author lwqMR
 *	properties属性
 */
public class DataSource {
	private Properties properties;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "DataSource [properties=" + properties + "]";
	}

}
