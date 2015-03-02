package Test;

import model.IVehicle;
import model.Vehicle;
import model.VehicleManagement;
import view.MainView;

public class MainViewTest {
	
	
	public static void main(String args[]){
MainView mv = new MainView();
VehicleManagement vm = new VehicleManagement();

vm.registerObserver(mv);
IVehicle v1 = new Vehicle(0,10,10,10);
IVehicle v2 = new Vehicle(0,30,10,10);
IVehicle v3 = new Vehicle(20,60,20,20);
IVehicle v4 = new Vehicle(20,100,20,20);


vm.addVehicle(v1);
vm.addVehicle(v2);
vm.addVehicle(v3);
vm.addVehicle(v4);
vm.setInterval(100);
vm.start();


	}
}
