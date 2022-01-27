package com.CourseManagementSystem;

import java.util.HashMap;

public class Test {
	
	static boolean solve() {
		
		String str="map";
		String str2="pem";
		
		HashMap<Character, Integer> mp=new HashMap<>();
		
		for(int i=0; i<str.length(); i++) {
			char ch=str.charAt(i);
			mp.put(ch, mp.getOrDefault(ch, 0)+1);
		}
		
		for(int i=0; i<str2.length(); i++) {
			char ch=str2.charAt(i);
			if(mp.containsKey(ch)) {
				mp.put(ch, mp.get(ch)-1);
				if(mp.get(ch)==0) {
					mp.remove(ch);
				}
			}else {
				return false;
			}
		}
		return mp.size()==0;
	}
	
	public static void main(String Args[]) {
		boolean res=solve();
		System.out.println(res);
	}

}

//“hello”, “elolh”
//”test”, “estt”
//”map”, “pem”
