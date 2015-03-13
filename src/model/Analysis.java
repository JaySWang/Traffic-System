package model;

import java.util.ArrayList;

import log.LogManagement;
import modelInterface.IAnalysis;

public class Analysis implements IAnalysis {

	LogManagement lm = LogManagement.getInstance();
	
	
	@Override
	public int getAverageSpeedByVId(int VehicleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAverageSpeedByTMPId(int TrafficMgtPolicyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCongestionRateByTMPId(int TrafficMgtPolicyId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList getAnalysisLog() {
		// TODO Auto-generated method stub
		return lm.getALogs();
	}

	
	
}
