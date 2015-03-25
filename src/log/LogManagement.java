package log;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import model.Analysis;
import model.TrafficPolicyManagement;
import modelInterface.IAnalysis;

import constValue.ConstValues;


public class LogManagement {

	
	List<TrafficMgtPolicyLog> tLogs = new ArrayList<TrafficMgtPolicyLog>();
	
	List<VehicleLog> vLogs = new ArrayList<VehicleLog>();
	List<AnalysisLog> aLogs = new ArrayList<AnalysisLog>();


	
	static LogManagement  lm;

	TrafficPolicyManagement tpm;
	
	

	
	private LogManagement() {
		super();
	}
	
	//
	public void clean(){
		tLogs.clear();
		vLogs.clear();
		aLogs.clear();
	}
	
	
	public static LogManagement getInstance(){
		if(lm==null){
			lm = new LogManagement();
		}
		
		return lm;
		
		
	};
	
	public void setTrafficPolicyMgt(TrafficPolicyManagement tpm){
		this.tpm = tpm;
	}

	
	public void addLog(TrafficMgtPolicyLog tLog, int densityLevel){
		tLogs.add(tLog);
		addALog(tLog,densityLevel);
	}
	
	
	public void addLog(AnalysisLog aLog){
		aLogs.add(aLog);
		
	}
	
	
	public void addCurrentTMP(){
		
		
		addLog(tpm.getCurrentMgtPolicy(),tpm.getDensityLevel());
	
	}
	
	
	public void removeCurrentTMP(){
		
		aLogs.remove(aLogs.size()-1);
		tLogs.remove(tLogs.size()-1);
	}
	
	
	private void addALog(TrafficMgtPolicyLog tLog, int densityLevel) {
		int speedLimit = tLog.getSpeedLimit();
		int lightIntervalTime = tLog.getLightIntervalTime();

				
		String trafficLights;
		if(tLog.getLightState() == ConstValues.ON){
			trafficLights = "On";
			
		}else{
			trafficLights = "Off";
		}
		
		IAnalysis a= new Analysis();
		double averageSpeed = a.getAverageSpeedByTMPId(tLog.getId()) ;
		double congestionRate = a.getCongestionRateByTMPId(tLog.getId());
		
		
		String dLevel = "Low";
		switch(densityLevel){
		case ConstValues.Low: dLevel = "Low";
		break;
		case ConstValues.Medium: dLevel = "Medium";
		break;
		case ConstValues.High: dLevel = "High";
		break;
		}
		
		
		DecimalFormat    df   = new DecimalFormat("######0.00");   
		String rate = df.format(congestionRate*100); 
		
		String speed = df.format(averageSpeed/10); 
		
		AnalysisLog al = new AnalysisLog(speedLimit, trafficLights,lightIntervalTime, speed,dLevel,rate);	
		aLogs.add(al);
	
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

	public List getALogs() {
		return aLogs;
	}
	
	
	
	
	
}
