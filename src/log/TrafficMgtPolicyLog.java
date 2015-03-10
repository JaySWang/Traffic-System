package log;



public class TrafficMgtPolicyLog {

int id;	
int lightState;
int speedLimit;
	
int startTime;
int endTime;
public TrafficMgtPolicyLog(int id, int lightState, int speedLimit, int startTime) {
	super();
	this.id = id;
	this.lightState = lightState;
	this.speedLimit = speedLimit;
	this.startTime = startTime;
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
	



	
	
	
}
