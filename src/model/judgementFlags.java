package model;
/**
 * 
 * @author qutong
 *
 */
public class judgementFlags {
boolean east_west;
boolean emergency;//show the car if emergency stop status or not.
public boolean isEmergency() {
	return emergency;
}

public void setEmergency(boolean emergency) {
	this.emergency = emergency;
}

/**
 * if east_west==true then vehicle with angle 90 and 270 go first
 * once this vehicle pass set this flag to false
 * otherwise set true
 * @return
 */
public boolean isEast_west() {
	return east_west;
}

public void setEast_west(boolean east_west) {
	this.east_west = east_west;
}
}
