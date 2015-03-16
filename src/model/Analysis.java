package model;

import java.util.List;

import log.LogManagement;
import log.VehicleLog;
import modelInterface.IAnalysis;

public class Analysis implements IAnalysis {

	LogManagement lm = LogManagement.getInstance();
	
	
	@Override
	public double getAverageSpeedByVId(int VehicleId) {

		List<VehicleLog> vls = lm.getVLogByVehicleId(VehicleId);
		double averageSpeed = calculateAverageSpeed(vls);
		
	
		
		return averageSpeed;
	}

	
	private double calculateAverageSpeed(List<VehicleLog> vls) {

		int totalSpeed = 0;
		
		for(VehicleLog vl:vls){
			totalSpeed+=vl.getSpeed();

		}
		
		//test 
		
	//return totalSpeed/vls.size();
		return 0;
	}

	@Override
	public double getAverageSpeedByTMPId(int TrafficMgtPolicyId) {
		
		
		List<VehicleLog> vls = lm.getVLogByTrafficMgtPolicyId(TrafficMgtPolicyId);	
		
		
        double averageSpeed = calculateAverageSpeed(vls);
        
		return averageSpeed;
		
	}

	@Override
	public double getCongestionRateByTMPId(int TrafficMgtPolicyId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
