package com.patel.ds.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListDemo {
	public static void main(String[] args) {
//		for(int i = 0; i < 10; i++) {
//			findWhoWillBeFired();
//		}
		
		List<String> orderItemIds = new ArrayList<String>();  orderItemIds.add("04680943000");orderItemIds.add("02641122000");
		List<String> list2 = new ArrayList<String>(); list2.add("04680943000"); list2.add("02641122000");
		
		boolean innerLoopFlag = Boolean.FALSE;
		for(String s: orderItemIds) {
			for(String s2: list2) {
				if(orderItemIds.contains(s)) {
					System.out.println(true);
					System.out.println(s2);
					innerLoopFlag = Boolean.TRUE;
					//break;
				}
			}
			if (innerLoopFlag) {
                break;
            }
		}
	}
	
	private static void findWhoWillBeFired() {
		Random random = new Random();
		System.out.println(random.nextInt(20));
	}
}
