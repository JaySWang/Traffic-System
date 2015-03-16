package log;

public class AnalysisLog {
	static int  count = 0;
	int no;
	int speedLimit;
	
	String trafficLightState;
	int lightIntervalTime;

	double averageSpeed;
	double congestionRate;
	
	public AnalysisLog(int speedLimit, String trafficLightState,int lightIntervalTime
,double averageSpeed, double congestionRate) {
		super();
		
		this.no = count;
		this.speedLimit = speedLimit;
		this.trafficLightState = trafficLightState;
		this.lightIntervalTime = lightIntervalTime;

		this.averageSpeed = averageSpeed;
		this.congestionRate = congestionRate;
		count++;
	}

	public int getNo() {
		return no;
	}

	public int getSpeedLimit() {
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

	public int getLightIntervalTime() {
		return lightIntervalTime;
	}
	
	
	
	
	
	
	
}
