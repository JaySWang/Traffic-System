package log;

public class AnalysisLog {
	static int  count = 0;
	int no;
	int speedLimit;
	
	String trafficLights;
	
	double averageSpeed;
	double congestionRate;
	
	public AnalysisLog(int speedLimit, String trafficLights,
			double averageSpeed, double congestionRate) {
		super();
		
		this.no = count;
		this.speedLimit = speedLimit;
		this.trafficLights = trafficLights;
		this.averageSpeed = averageSpeed;
		this.congestionRate = congestionRate;
		count++;
	}
	
	
	
	
	
	
	
}
