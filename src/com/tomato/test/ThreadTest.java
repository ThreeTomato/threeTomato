package com.tomato.test;

public class ThreadTest extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.err.println(getName()+" begin");
		for(int i=0; i<10; i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.err.println(getName()+" ing ing...");
		}
		System.err.println(getName()+" end");
	}
	
	public static void main(String[] args) {
		Thread tt = new ThreadTest();
		tt.setName("tom");
		tt.start();
		Thread t2 = new Thread(new Thread2(), "jack");
		t2.start();
	}
	
}

class Thread2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+" begin");
		for(int i=0; i<10; i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" ing ing...");
		}
		System.out.println(Thread.currentThread().getName()+" end");
	}
	
}
