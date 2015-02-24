package model;

import modelInterface.ITrafficLight;

public class TestMain {

	
	
	public static void main(String args[]){
		
		ITrafficLight t = new TrafficLight(4);
		t.on();
		

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1");
		t.off();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("2");
		t.on();
	}
}
