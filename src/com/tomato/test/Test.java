package com.tomato.test;

public class Test {

	public static void main(String[] agrs){
		int i;int j;
		System.out.println("============华丽丽的分割线==================");
		for (i=1;i<=9;i++){
			for (j=1;j<=i;j++){
				System.out.print(i+"*"+j+"="+i*j+"\t");
			}
			System.out.println();
		}
	}
}
