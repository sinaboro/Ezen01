package com.springbook.ioc.injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	private List<String> addressList;
	private Set<String> addressSet;
	private Map<String, String> addressMap;
	private Properties addressProperties;
	
	public Map<String, String> getAddressMap() {
		return addressMap;
	}
	public Properties getAddressProperties() {
		return addressProperties;
	}
	public void setAddressProperties(Properties addressProperties) {
		this.addressProperties = addressProperties;
	}
	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}
	public CollectionBean() {
		System.out.println("CollectionBean");
	}
	public List<String> getAddressList() {
		return addressList;
	}

	public Set<String> getAddressSet() {
		return addressSet;
	}
	public void setAddressSet(Set<String> addressSet) {
		this.addressSet = addressSet;
	}
	public void setAddressList(List<String> addressList) {
		System.out.println("setAddressList");
		this.addressList = addressList;
	}
	
}
