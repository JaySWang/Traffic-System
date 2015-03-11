package Test;

import java.util.ArrayList;
import java.util.List;

import Controller.TrafficLightController;
import ControllerInterface.ITrafficLightController;
import model.IVehicle;
import model.TrafficLight;
import model.Vehicle;
import model.VehicleManagement;
import modelInterface.ITrafficLight;
import view.MainView;
import view.MapView;

public class MainViewTest {

	public static void main(String args[]) {

		VehicleManagement vm = new VehicleManagement();
		TrafficLight t0 = new TrafficLight(3, 0);
		// TrafficLight t1 = new TrafficLight(4,0);

		List<ITrafficLight> TrafficLights = new ArrayList();
		TrafficLights.add(t0);
		// TrafficLights.add(t1);

		ITrafficLightController c = new TrafficLightController(TrafficLights);
		MapView mapPanel = new MapView(TrafficLights, c);

		t0.registerObserver(mapPanel);
		// t1.registerObserver(mapPanel);

		MainView mv = new MainView(mapPanel);

		vm.registerObserver(mv);
		IVehicle v1 = new Vehicle();
		IVehicle v2 = new Vehicle();
		v1.setLength(10);
		v1.setWidth(10);
		v1.setLocation_x(0);
		v1.setLocation_y(100);

		v2.setLength(20);
		v2.setWidth(20);
		v2.setLocation_x(0);
		v2.setLocation_y(30);

		vm.addVehicle(v1);
		// vm.addVehicle(v2);

		vm.setIntervalTime(1);
		vm.start();
		t0.on();
		// t1.on();

	}
}
