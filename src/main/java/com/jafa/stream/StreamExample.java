package com.jafa.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("길동");
		list.add("고");
		list.add("길동");
		list.add("스트림생성");
//		한번 보내면 다시 사용을 못한다?
//		스트림 생성
		Stream<String> stream = list.stream();
		
//		파라미터로 익명 구현 객체 전달
		stream.forEach(new Consumer<String>() {
//		e는 element
			@Override
			public void accept(String e) {
				System.out.println(e);
				System.out.println("길이: "+e.length());
				System.out.println("=========================");
			}
		});
		
//		스트림은 재작업이 되지 않는다.
		/*
		 * stream.forEach(new Consumer<String>() { // e는 element
		 * 
		 * @Override public void accept(String e) { System.out.println(e); } });
		 */
	}
}
