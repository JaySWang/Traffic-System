package model;

import java.text.DecimalFormat;
import java.util.List;

import constValue.ConstValues;

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
		
		if(vls.size()!=0){
			return totalSpeed/vls.size();
		}
		
	
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
		List<VehicleLog> vls = lm.getVLogByTrafficMgtPolicyId(TrafficMgtPolicyId);	

		
	double count = 0;
		
		for(VehicleLog vl:vls){
            if(vl.getSpeed()<ConstValues.ConjuctionSpeed){
            	count++;
            }
            
		}
		
		
	if(vls.size()==0)
		return 0;
	
	
	double  rate = count/vls.size();
	
	
	
	return rate;
		
	}
	
}
