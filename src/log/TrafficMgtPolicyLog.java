package log;

import java.util.ArrayList;
import java.util.List;

public class TrafficMgtPolicyLog {

	List<TrafficMgtPolicyLog> tmpLogs = new ArrayList();
	List<VehicleLog> vLogs = new ArrayList();

	
	
	public void addLog(TrafficMgtPolicyLog tmpLog){
		tmpLogs.add(tmpLog);
	}
	
	public void addLog(VehicleLog vLog){
		vLogs.add(vLog);
	}
	
	
	
	
	
	
}
