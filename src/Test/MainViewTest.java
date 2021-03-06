package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import constValue.ConstValues;


import Controller.MainController;
import Controller.TrafficConditionController;
import Controller.TrafficLightController;
import ControllerInterface.IMainController;
import ControllerInterface.ITrafficConditionController;
import ControllerInterface.ITrafficLightController;
import log.LogManagement;
import model.Map;
import model.TrafficCondition;
import model.TrafficLight;
import model.TrafficLightManagement;
import model.TrafficPolicyManagement;
import model.VehicleGenerator;
import model.VehicleManagement;
import modelInterface.IMap;
import modelInterface.ITrafficCondition;
import modelInterface.ITrafficLight;
import view.MainView;
import view.TLCrossMapView;

public class MainViewTest {

	public static void main(String args[]) {

		
		try {
			ConstValues constvalues = new ConstValues();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IMap map = new Map();
		IMainController mainController = new MainController(map);
		
		mainController.setMaps("TRoad");
		mainController.start();
	}
}
