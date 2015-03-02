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
IVehicle v1 = new Vehicle();
IVehicle v2 = new Vehicle();
v1.setLength(10);
v1.setWidth(10);
v1.setLocation_x(0);
v1.setLocation_y(10);

v2.setLength(20);
v2.setWidth(20);
v2.setLocation_x(0);
v2.setLocation_y(30);


vm.addVehicle(v1);
vm.addVehicle(v2);

vm.setInterval(100);
vm.start();


	}
}
