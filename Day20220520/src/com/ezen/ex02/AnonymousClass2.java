package com.ezen.ex02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class StrCmp implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o1.length() - o2.length();
	}
	
}
public class AnonymousClass2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("robot");
		list.add("apple");
		list.add("toy");
		
		StrCmp sc = new StrCmp();
		Collections.sort(list,sc);
		System.out.println(list);
	}
}
