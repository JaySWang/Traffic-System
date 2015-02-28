package model;

import java.awt.Color;
import java.util.Random;

/**
 * This is the implementation of sensors, it's like the drivers' eyes
 * it will provide a method return the color of particular area.
 * @author qutong
 * */
public class Sensor {
	private int location_x;
	private int location_y;
	private int size_x;
	private int size_y;
	public int getLocation_x() {
		return location_x;
	}
	public void setLocation_x(int location_x) {
		this.location_x = location_x;
	}
	public int getLocation_y() {
		return location_y;
	}
	public void setLocation_y(int location_y) {
		this.location_y = location_y;
	}
	public int getSize_x() {
		return size_x;
	}
	public void setSize_x(int size_x) {
		this.size_x = size_x;
	}
	public int getSize_y() {
		return size_y;
	}
	public void setSize_y(int size_y) {
		this.size_y = size_y;
	}
	int[] allPointsColor(){
		int[] pColor = null;
		return pColor;
	}
	int[] randomPointsColor(){
		int[] pColor = null;
		return pColor;
	}
	/**
	 * this method is designed to get the random points in sensors' area
	 * 
	 * @param min 
	 * 			lower limit 
	 * @param max
	 * 			upper limit
	 * @return s
	 * 			integrate value in this range
	 */
	int randomInt(int min,int max){
		Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
		return s;
	}
	/**
	 * 
	 * @param points
	 * 		the sample points in this area can be all or some
	 * @return coa
	 * 		this is the color of this area, the value should be calculated, 
	 * 		the specific method will be decided after research work
	 */
	Color areaColor(){
		Color coa = null;
		return coa;
	}
}
