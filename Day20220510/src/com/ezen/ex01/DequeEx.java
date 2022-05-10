package com.ezen.ex01;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *  addFrist() 넣기
 *  removeFirst 꺼내기
 *  getFirst() 확인하기
 *  
 *  addLast() 넣기
 *  removeLast() 꺼내기
 *  getLast
 */
public class DequeEx {

	public static void main(String[] args) {
		
		Deque<String> deq = new ArrayDeque<String>();
		
		deq.offerFirst("1.box");
		deq.offerFirst("2.toy");
		deq.offerFirst("3.robot");
		
//		System.out.println(deq.pollFirst());
//		System.out.println(deq.pollFirst());
//		System.out.println(deq.pollFirst());
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
	}

}
