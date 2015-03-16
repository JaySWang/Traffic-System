package model;

import java.awt.Color;
import java.io.IOException;

import modelInterface.IVehicle;

/**
 * this class is the model of all the vehicle in this system, this version
 * doesn't consider the circle
 * 
 * @author qutong
 * @version 1.0
 * 
 */
public class Vehicle implements IVehicle {
	private int width;
	private int length;
	private int location_x;
	private int location_y;
	private int speed;// if the refresh 0.1s,the min speed is 1m/s therefore
						// every pixel represent 0.1 meter
	private int angle;// 0-360
	private int acceleration;
	private String next;// what will the vehicle do

	Sensor_withoutCircle s1 = new Sensor_withoutCircle();
	Sensor_withoutCircle s2 = new Sensor_withoutCircle();
	Sensor_withoutCircle s3 = new Sensor_withoutCircle();
	Sensor_withoutCircle s4 = new Sensor_withoutCircle();
	Sensor_withoutCircle s5 = new Sensor_withoutCircle();
	Sensor_withoutCircle s6 = new Sensor_withoutCircle();

	public Sensor_withoutCircle getS1() {
		return s1;
	}

	public void setS1(Sensor_withoutCircle s1) {
		this.s1 = s1;
	}

	public Sensor_withoutCircle getS2() {
		return s2;
	}

	public void setS2(Sensor_withoutCircle s2) {
		this.s2 = s2;
	}

	public Sensor_withoutCircle getS3() {
		return s3;
	}

	public void setS3(Sensor_withoutCircle s3) {
		this.s3 = s3;
	}

	public Sensor_withoutCircle getS4() {
		return s4;
	}

	public void setS4(Sensor_withoutCircle s4) {
		this.s4 = s4;
	}

	public Sensor_withoutCircle getS5() {
		return s5;
	}

	public void setS5(Sensor_withoutCircle s5) {
		this.s5 = s5;
	}

	public Sensor_withoutCircle getS6() {
		return s6;
	}

	public void setS6(Sensor_withoutCircle s6) {
		this.s6 = s6;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	/**
	 * this part used to configure sensors based on vehicle's position on the
	 * map, and different sensor has different size this part hasn't been wrote
	 * coz the value need more research work
	 * 
	 * @param Dsv
	 *            related position
	 * @param vehicle
	 *            's parameters
	 * @throws IOException
	 */
	void configureSensors() throws IOException {
		if (this.getAngle() == 0) {
			System.out.println("the car is heading north");
			System.out.println("for sensors:position of the vehicle now is: ("
					+ this.getLocation_x() + "," + this.getLocation_y() + ")");
			/*
			 * Sensor_withoutCircle s1 = new Sensor_withoutCircle();
			 * Sensor_withoutCircle s2 = new Sensor_withoutCircle();
			 * s1.setLocation_x(this.getLocation_x() - 19);
			 * s1.setLocation_y(this.getLocation_y() + 14); s1.setSize_x(1);
			 * s1.setSize_y(5); s2.setLocation_x(this.getLocation_x() + 20);
			 * s2.setLocation_y(this.getLocation_y() - 14); s2.setSize_x(1);
			 * s2.setSize_y(5);
			 */

			this.getS1().setLocation_x(this.getLocation_x() - 19);
			this.getS1().setLocation_y(this.getLocation_y() + 14);
			this.getS1().setSize_x(1);
			this.getS1().setSize_y(5);
			this.getS2().setLocation_x(this.getLocation_x() + 19);
			this.getS2().setLocation_y(this.getLocation_y() - 14);
			this.getS2().setSize_x(1);
			this.getS2().setSize_y(5);

			/*
			 * if (s1.areaColor() == Color.black && s2.areaColor() ==
			 * Color.white) { this.setLocation_y((int) (this.getLocation_y() -
			 * this .getSpeed() * 0.1)); } else { this.setAngle(90); }
			 */
		} else if (this.getAngle() == 90) {
			System.out.println("the car is heading east");
		} else if (this.getAngle() == 180) {
			System.out.println("the car is heading south");
		} else {
			System.out.println("the car is heading west");
		}

	}

	/**
	 * this part used to decide what will the vehicle do in next,
	 * 
	 * @param next
	 *            this value will be set to tell the UI what will the car do in
	 *            the next,it can be: ahead,left,right,slow,stop
	 * @param vehicle
	 *            's parameters
	 */
	void turnJudgement() {

	}

	/**
	 * based on the value of next calculate the position and speed next 0.1s
	 * 
	 * @throws IOException
	 */

	void calculateNextPosition() throws IOException {
		if (s1.areaColor() == Color.black && s2.areaColor() == Color.white) {
			this.setLocation_x((int) (this.getLocation_x() + this.getSpeed() * 0.1));
		} else {
			this.setAngle(90);
		}
	}

	public static void main(String[] arg) throws IOException {
		Vehicle v = new Vehicle();
		v.setLocation_x(290);
		v.setLocation_y(400);
		v.setLength(32);
		v.setWidth(26);
		v.setSpeed(100);
		while (v.getAngle() == 0) {
			System.out.println("position of the vehicle now is: ("
					+ v.getLocation_x() + "," + v.getLocation_y() + ")");
			v.configureSensors();
			v.calculateNextPosition();
			System.out.println("next position of the vehicle is: ("
					+ v.getLocation_x() + "," + v.getLocation_y() + ")"
					+ v.getAngle());
		}
	}

}
