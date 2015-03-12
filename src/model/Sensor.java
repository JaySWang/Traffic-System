package model;

import java.awt.Color;
import java.io.IOException;
import java.util.Random;

/**
 * This is the implementation of sensors, it's like the drivers' eyes it will
 * provide a method return the color of particular area. this is the superclass
 * 
 * @author qutong
 * */
public class Sensor {
	private int location_x;
	private int location_y;
	private int size_x;
	private int size_y;
	private int x_min;
	private int x_max;
	private int y_min;
	private int y_max;

	public int getX_min() {
		return x_min = this.getLocation_x() - (this.getSize_x() / 2);
	}

	public void setX_min(int x_min) {
		this.x_min = x_min;
	}

	public int getX_max() {
		return x_max = this.getLocation_x() + (this.getSize_x() / 2);
	}

	public void setX_max(int x_max) {
		this.x_max = x_max;
	}

	public int getY_min() {
		return y_min = this.getLocation_y() - (this.getSize_y() / 2);
	}

	public void setY_min(int y_min) {
		this.y_min = y_min;
	}

	public int getY_max() {
		return y_max = this.getLocation_y() + (this.getSize_y() / 2);
	}

	public void setY_max(int y_max) {
		this.y_max = y_max;
	}

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

	int[] allPointsColor() {
		int[] pColor = null;
		return pColor;
	}

	int[] randomPointsColor() throws IOException {
		int[] pColor = null;
		return pColor;
	}

	/**
	 * this method is designed to get the random points in sensors' area
	 * 
	 * @param min
	 *            lower limit
	 * @param max
	 *            upper limit
	 * @return s integrate value in this range
	 */
	int randomInt(int min, int max) {
		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;
		return s;
	}

	/**
	 * 
	 * @param points
	 *            the sample points in this area can be all or some
	 * @return coa this is the color of this area, the value should be
	 *         calculated, the specific method will be decided after research
	 *         work
	 * @throws IOException
	 */
	Color areaColor() throws IOException {
		Color coa = null;
		return coa;
	}

	/**
	 * this method is used to make sure are the components R,G,B in the reliable
	 * range.
	 * 
	 * @param color
	 * @param sample
	 * @return
	 */
	boolean isRound(int color, int sample) {
		boolean result;
		int range = 40;
		int upper, lower;
		if (color >= 215) {
			upper = 255;
			lower = color - range;
		} else if (color <= range) {
			upper = color + range;
			lower = 0;
		} else {
			upper = color + range;
			lower = color - range;
		}
		if (sample >= lower && sample <= upper) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

}
