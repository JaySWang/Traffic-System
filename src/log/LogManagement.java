package log;

import java.util.ArrayList;
import java.util.List;


public class LogManagement {

	
	List<TrafficMgtPolicyLog> tLogs = new ArrayList<TrafficMgtPolicyLog>();
	
	List<VehicleLog> vLogs = new ArrayList<VehicleLog>();

	
	static LogManagement  lm;
	
	
	
	
	
	
	private LogManagement() {
		super();
	}
	
	public static LogManagement getInstance(){
		if(lm==null){
			lm = new LogManagement();
		}
		
		return lm;
		
		
	};
	
	

	public void addLog(TrafficMgtPolicyLog tLog){
		tLogs.add(tLog);
	}
	
	public void addLog(VehicleLog vLog){
		vLogs.add(vLog);
	}

	public List<TrafficMgtPolicyLog> getTLogs() {
		return tLogs;
	}
	public TrafficMgtPolicyLog getTLogById(int tId) {
		for(TrafficMgtPolicyLog tl : tLogs){
			if(tl.getId()==tId){
				return tl;
			}
		}
		
		return null;
	}

	public List<VehicleLog> getVLogs() {
		return vLogs;
	}
	
	
	
	public List<VehicleLog> getVLogByVehicleId(int vId){
		List<VehicleLog> logs = new ArrayList();
		for(VehicleLog vl:vLogs){
			if(vl.getVehicle_id()==vId){
				logs.add(vl);
			}
		}
		return logs;
	}
	
	
	
	
	public List<VehicleLog> getVLogByTrafficMgtPolicyId(int tId){
		TrafficMgtPolicyLog tl = getTLogById(tId); 
		List<VehicleLog> logs = getVLogByTime(tl.getStartTime(),tl.getEndTime());

		return logs;
	}
	
	
	
	private List<VehicleLog> getVLogByTime(int from,int to){
		List<VehicleLog> logs = new ArrayList();
		for(VehicleLog vl:vLogs){
			if(from<=vl.getTime()&&vl.getTime()<=to){
				logs.add(vl);
			}
		}
		return logs;
	}
	
	
	
	
	
}
