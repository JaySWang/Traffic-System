package log;



public class TrafficMgtPolicyLog {

static int count = 0;	
int id;
int lightState;
int lightIntervalTime;

int speedLimit;
	
int startTime;
int endTime;


public TrafficMgtPolicyLog(int lightState,int lightIntervalTime, int speedLimit, int startTime, int endTime ) {
	super();
	this.lightState = lightState;
	this.lightIntervalTime = lightIntervalTime;
	this.speedLimit = speedLimit;
	this.startTime = startTime;
	this.endTime = endTime;
	this.id = count;
	count++;
}
public int getId() {
	return id;
}

public int getLightState() {
	return lightState;
}

public int getSpeedLimit() {
	return speedLimit;
}

public int getStartTime() {
	return startTime;
}

public int getEndTime() {
	return endTime;
}
public void setEndTime(int endTime) {
	this.endTime = endTime;
}
public int getLightIntervalTime() {
	return lightIntervalTime;
}
	



	
	
	
}
