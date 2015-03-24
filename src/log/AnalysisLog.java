package log;

import constValue.ConstValues;

public class AnalysisLog {
	static int  count = 0;
	int no;
	String speedLimit;
	
	String trafficLightState;
	String densityLevel;
	String lightIntervalTime;

	
	
	
	String averageSpeed;
	String congestionRate;
	
	public AnalysisLog(int speedLimit, String trafficLightState,int lightIntervalTime
,String averageSpeed,String densityLevel, String congestionRate) {
		super();
		
		this.no = count;
		if(speedLimit == ConstValues.NA){
			this.speedLimit = "N/A";
		}
		else {
		this.speedLimit = speedLimit+"m/s";
		}
		this.trafficLightState = trafficLightState;
		
		
		if(lightIntervalTime == ConstValues.NA){
			this.lightIntervalTime = "N/A";
		}else {
		this.lightIntervalTime = lightIntervalTime+" sec";
		}
		this.averageSpeed = averageSpeed+"m/s";
		this.densityLevel = densityLevel;
		this.congestionRate = congestionRate+"%";
		count++;
	}

	
	public String getDensityLevel() {
		return densityLevel;
	}


	public int getNo() {
		return no;
	}

	public String getSpeedLimit() {
		return speedLimit;
	}

	public String getTrafficLightState() {
		return trafficLightState;
	}

	public String getAverageSpeed() {
		return averageSpeed;
	}

	public String getCongestionRate() {
		return congestionRate;
	}

	public String getLightIntervalTime() {
		return lightIntervalTime;
	}
	
	
	
	
	
	
	
}
