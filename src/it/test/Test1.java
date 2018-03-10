package it.test;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Test1 {

	public static void main(String[] args) {
		test3();
	}
	
	public static void test1() {
		String str = "null/3&2/3&2";
		
		String[] arr = str.split("/");
		
		for(int i = 1; i < arr.length; i++){
			System.out.println(arr[i]);
			int goodId = Integer.parseInt(arr[i].split("&")[0]);
			int num = Integer.parseInt(arr[i].split("&")[1]);
			System.out.println(goodId);
			System.out.println(num);
		}
	}
	
	public static void test2() {
		String str = "null/3&2/4&1";
		
		str = str.replace("/3&2", "");
		
		String[] arr = str.split("/");
		
		for(int i = 1; i < arr.length; i++){
			System.out.println(arr[i]);
			int goodId = Integer.parseInt(arr[i].split("&")[0]);
			int num = Integer.parseInt(arr[i].split("&")[1]);
			System.out.println(goodId);
			System.out.println(num);
		}
	}
	
	public static void test3() {
		Date date = new Date();
		long time = date.getTime();
		System.out.println(time);
		System.out.println("------");
		
		
		Date now = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(now));
		
	}

}
