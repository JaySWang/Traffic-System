package Test;

import view.TrafficLightView;
import model.TrafficLight;
import modelInterface.ITrafficLight;

public class TrafficLightTest {

	
	
	public static void main(String args[]){
		
		TrafficLight t = new TrafficLight(4);
		TrafficLightView tv = new TrafficLightView();
		tv.on();
		
		t.registerObserver(tv);
		t.on();
		

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		t.off();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.on();
	}
}
