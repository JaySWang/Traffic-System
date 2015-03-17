package model;
/**
 * 
 * @author qutong
 *
 */
public class CrossTuring {
boolean east_west;
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
