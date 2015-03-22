package log;

import constValue.ConstValues;

public class AnalysisLog {
	static int  count = 0;
	int no;
	String speedLimit;
	
	String trafficLightState;
	String densityLevel;
	String lightIntervalTime;

	
	
	
	double averageSpeed;
	double congestionRate;
	
	public AnalysisLog(int speedLimit, String trafficLightState,int lightIntervalTime
,double averageSpeed,String densityLevel, double congestionRate) {
		super();
		
		this.no = count;
		if(speedLimit == ConstValues.NA){
			this.speedLimit = "N/A";
		}
		else {
		this.speedLimit = speedLimit+"";
		}
		this.trafficLightState = trafficLightState;
		
		
		if(lightIntervalTime == ConstValues.NA){
			this.lightIntervalTime = "N/A";
		}else {
		this.lightIntervalTime = lightIntervalTime+"";
		}
		this.averageSpeed = averageSpeed;
		this.densityLevel = densityLevel;
		this.congestionRate = congestionRate;
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

	public double getAverageSpeed() {
		return averageSpeed;
	}

	public double getCongestionRate() {
		return congestionRate;
	}

	public String getLightIntervalTime() {
		return lightIntervalTime;
	}
	
	
	
	
	
	
	
}
