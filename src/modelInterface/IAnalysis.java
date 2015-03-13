package modelInterface;

import java.util.ArrayList;

public interface IAnalysis {
	
	
	public int getAverageSpeedByVId(int VehicleId);
	public int getAverageSpeedByTMPId(int TrafficMgtPolicyId);
	public int getCongestionRateByTMPId(int TrafficMgtPolicyId);
	public ArrayList getAnalysisLog();


 
	
	

}
