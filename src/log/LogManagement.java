package log;

import java.util.ArrayList;
import java.util.List;


public class LogManagement {

	
	List<TrafficMgtPolicyLog> tLogs = new ArrayList();
	
	List<VehicleLog> vLogs = new ArrayList();

	
	
	public void addLog(TrafficMgtPolicyLog tLog){
		tLogs.add(tLog);
	}
	
	public void addLog(VehicleLog vLog){
		vLogs.add(vLog);
	}

	public List<TrafficMgtPolicyLog> gettLogs() {
		return tLogs;
	}

	public List<VehicleLog> getvLogs() {
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
	
	public List<VehicleLog> getVLogByTime(int from,int to){
		List<VehicleLog> logs = new ArrayList();
		for(VehicleLog vl:vLogs){
			if(from<=vl.getTime()&&vl.getTime()<=to){
				logs.add(vl);
			}
		}
		return logs;
	}
	
	
	
	
	
}
