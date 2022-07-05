package com.springbook.ioc.injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean	 = (CollectionBean) factory.getBean("CollectionBean");
		List<String> list = bean.getAddressList();
		
		for(String st : list)
			System.out.println(st);
		
		System.out.println("------Set-------");
		Set<String> set = bean.getAddressSet();
		for(String str : set)
			System.out.println(str);
		factory.close();

		System.out.println("--------ㅡMap----------");
		Map<String, String> map= bean.getAddressMap();
		
		for(String key : map.keySet()) {
			System.out.println(key + ",  " +map.get(key));
		}
		System.out.println("-------Properties-----------");
	
		Properties pro = bean.getAddressProperties();
		for(String key : pro.stringPropertyNames()) {
			System.out.println(  key + " : " + pro.get(key));
		}
	}

}
