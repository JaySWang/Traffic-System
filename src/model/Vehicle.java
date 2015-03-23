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
	private int id;
	private int width;
	private int length;
	private int location_x;
	private int location_y;
	private int speed;// if the refresh 0.1s,the min speed is 1m/s therefore
						// every pixel represent 0.1 meter
	private int angle;// 0-360
	private int acceleration;
	private int direction;
	private int status;// next position will calculate based on this information
	/*
	 * 0: normal; 1: emergency stop; 2: stop; 4: recover from emergency stop;
	 */

	private String next;// what will the vehicle do

	Sensor_withoutCircle s1 = new Sensor_withoutCircle();
	Sensor_withoutCircle s2 = new Sensor_withoutCircle();
	Sensor_withoutCircle s3 = new Sensor_withoutCircle();
	Sensor_withoutCircle s4 = new Sensor_withoutCircle();
	Sensor_withoutCircle s5 = new Sensor_withoutCircle();
	Sensor_withoutCircle s6 = new Sensor_withoutCircle();
	Sensor_withoutCircle s7 = new Sensor_withoutCircle();

	public Vehicle() {

	}

	public Vehicle(int id, int width, int length, int location_x,
			int location_y, int direction, int speed) {
		super();
		this.id = id;
		this.width = width;
		this.length = length;
		this.location_x = location_x;
		this.location_y = location_y;
		this.speed = speed;
		this.direction = direction;
	}

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

	public Sensor_withoutCircle getS7() {
		return s7;
	}

	public void setS7(Sensor_withoutCircle s7) {
		this.s7 = s7;
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
		if (this.getAngle() == 0) {// the car is heading north
			System.out.println("the car is heading north");
			System.out.println("for sensors:position of the vehicle now is: ("
					+ this.getLocation_x() + "," + this.getLocation_y() + ")");

			/* configuration for sensor1 */
			this.getS1().setLocation_x(this.getLocation_x() - 30);
			this.getS1().setLocation_y(this.getLocation_y()+15);
			this.getS1().setSize_x(5);
			this.getS1().setSize_y(5);
			/* configuration for sensor2 */
			this.getS2().setLocation_x(this.getLocation_x() - 6);
			this.getS2().setLocation_y(this.getLocation_y() - 30);
			this.getS2().setSize_x(1);
			this.getS2().setSize_y(30);
			/* configuration for sensor3 */
			this.getS3().setLocation_x(this.getLocation_x());
			this.getS3().setLocation_y(this.getLocation_y() - 20);
			this.getS3().setSize_x(26);
			this.getS3().setSize_y(10);
			/* configuration for sensor4 */
			this.getS4().setLocation_x(this.getLocation_x());
			this.getS4().setLocation_y(this.getLocation_y() - 38);
			this.getS4().setSize_x(26);
			this.getS4().setSize_y(1);
			/* configuration for sensor5 */
			this.getS5().setLocation_x(this.getLocation_x() + 33);
			this.getS5().setLocation_y(this.getLocation_y() - 30);
			this.getS5().setSize_x(1);
			this.getS5().setSize_y(30);
			/* configuration for sensor6 */
			this.getS6().setLocation_x(this.getLocation_x() + 18);
			this.getS6().setLocation_y(this.getLocation_y() - 30);
			this.getS6().setSize_x(1);
			this.getS6().setSize_y(30);
			/* configuration for sensor7 */
			this.getS7().setLocation_x(this.getLocation_x() - 5);
			this.getS7().setLocation_y(this.getLocation_y() + 42);
			this.getS7().setSize_x(36);
			this.getS7().setSize_y(10);

		} else if (this.getAngle() == 90) {// the car is heading east
			System.out.println("the car is heading east");
			/* configuration for sensor1 */
			this.getS1().setLocation_x(this.getLocation_x() - 35);
			this.getS1().setLocation_y(this.getLocation_y() - 42);
			this.getS1().setSize_x(35);
			this.getS1().setSize_y(35);
			/* configuration for sensor2 */
			this.getS2().setLocation_x(this.getLocation_x() + 1);
			this.getS2().setLocation_y(this.getLocation_y() - 6);
			this.getS2().setSize_x(30);
			this.getS2().setSize_y(1);
			/* configuration for sensor3 */
			this.getS3().setLocation_x(this.getLocation_x() + 11);
			this.getS3().setLocation_y(this.getLocation_y());
			this.getS3().setSize_x(10);
			this.getS3().setSize_y(26);
			/* configuration for sensor4 */
			this.getS4().setLocation_x(this.getLocation_x() + 38);
			this.getS4().setLocation_y(this.getLocation_y());
			this.getS4().setSize_x(1);
			this.getS4().setSize_y(26);
			/* configuration for sensor5 */
			this.getS5().setLocation_x(this.getLocation_x() + 1);
			this.getS5().setLocation_y(this.getLocation_y() + 31);
			this.getS5().setSize_x(30);
			this.getS5().setSize_y(1);
			/* configuration for sensor6 */
			this.getS6().setLocation_x(this.getLocation_x() + 1);
			this.getS6().setLocation_y(this.getLocation_y() + 68);
			this.getS6().setSize_x(30);
			this.getS6().setSize_y(1);
			/* configuration for sensor7 */
			this.getS7().setLocation_x(this.getLocation_x() - 51);
			this.getS7().setLocation_y(this.getLocation_y() - 5);
			this.getS7().setSize_x(10);
			this.getS7().setSize_y(36);
		} else if (this.getAngle() == 180) {// the car is heading south
			System.out.println("the car is heading south");
			/* configuration for sensor1 */
			this.getS1().setLocation_x(this.getLocation_x() + 7);
			this.getS1().setLocation_y(this.getLocation_y() - 35);
			this.getS1().setSize_x(35);
			this.getS1().setSize_y(35);
			/* configuration for sensor2 */
			this.getS2().setLocation_x(this.getLocation_x() + 6);
			this.getS2().setLocation_y(this.getLocation_y() + 1);
			this.getS2().setSize_x(1);
			this.getS2().setSize_y(30);
			/* configuration for sensor3 */
			this.getS3().setLocation_x(this.getLocation_x() - 25);
			this.getS3().setLocation_y(this.getLocation_y() + 11);
			this.getS3().setSize_x(26);
			this.getS3().setSize_y(10);
			/* configuration for sensor4 */
			this.getS4().setLocation_x(this.getLocation_x() - 25);
			this.getS4().setLocation_y(this.getLocation_y() + 11);
			this.getS4().setSize_x(26);
			this.getS4().setSize_y(1);
			/* configuration for sensor5 */
			this.getS5().setLocation_x(this.getLocation_x() - 25);
			this.getS5().setLocation_y(this.getLocation_y() + 38);
			this.getS5().setSize_x(1);
			this.getS5().setSize_y(30);
			/* configuration for sensor6 */
			this.getS6().setLocation_x(this.getLocation_x() - 68);
			this.getS6().setLocation_y(this.getLocation_y() + 1);
			this.getS6().setSize_x(1);
			this.getS6().setSize_y(30);
			/* configuration for sensor7 */
			this.getS7().setLocation_x(this.getLocation_x() - 31);
			this.getS7().setLocation_y(this.getLocation_y() - 51);
			this.getS7().setSize_x(36);
			this.getS7().setSize_y(10);
		} else {// the car is heading west
			System.out.println("the car is heading west");
			/* configuration for sensor1 */
			this.getS1().setLocation_x(this.getLocation_x());
			this.getS1().setLocation_y(this.getLocation_y() + 7);
			this.getS1().setSize_x(35);
			this.getS1().setSize_y(35);
			/* configuration for sensor2 */
			this.getS2().setLocation_x(this.getLocation_x() - 30);
			this.getS2().setLocation_y(this.getLocation_y() + 8);
			this.getS2().setSize_x(30);
			this.getS2().setSize_y(1);
			/* configuration for sensor3 */
			this.getS3().setLocation_x(this.getLocation_x() - 20);
			this.getS3().setLocation_y(this.getLocation_y() - 26);
			this.getS3().setSize_x(10);
			this.getS3().setSize_y(26);
			/* configuration for sensor4 */
			this.getS4().setLocation_x(this.getLocation_x() - 38);
			this.getS4().setLocation_y(this.getLocation_y() - 26);
			this.getS4().setSize_x(1);
			this.getS4().setSize_y(26);
			/* configuration for sensor5 */
			this.getS5().setLocation_x(this.getLocation_x() - 30);
			this.getS5().setLocation_y(this.getLocation_y() - 31);
			this.getS5().setSize_x(30);
			this.getS5().setSize_y(1);
			/* configuration for sensor6 */
			this.getS6().setLocation_x(this.getLocation_x() - 30);
			this.getS6().setLocation_y(this.getLocation_y() - 68);
			this.getS6().setSize_x(30);
			this.getS6().setSize_y(1);
			/* configuration for sensor7 */
			this.getS7().setLocation_x(this.getLocation_x() + 42);
			this.getS7().setLocation_y(this.getLocation_y() - 30);
			this.getS7().setSize_x(10);
			this.getS7().setSize_y(36);
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
	 * @throws IOException
	 */
	void turnJudgement() throws IOException {
		System.out.println("Color of sensor1 is : " + s1.areaColor() + "\n"
				+ "Color of sensor2 is : " + s2.areaColor() + "\n"
				+ "Color of sensor5 is : " + s5.areaColor() + "\n"
				+"number of white pixel is : "+s5.countColor());
		if (s7.areaColor() == Color.red) {
			this.setStatus(1);
		} else if (s1.areaColor() == Color.red// traffic light is red
				|| s3.areaColor() != Color.gray// there is not the road in front
												// of the vehicle, car or end of
												// the road
		) {
			this.setStatus(1);

		} else if (s6.areaColor() != Color.gray
				&& s6.areaColor() != Color.black) {// not drive normally or
													// there is a car come from
													// the road behind it

		} else if (s2.areaColor() == Color.black
				&& s5.areaColor() == Color.white) {
			this.setStatus(0);
		} else if (s2.areaColor() == Color.gray && s5.areaColor() == Color.gray) {
			System.out.println("I need to turn");
			this.setAngle(0);
		} else {
			System.out.println("unknown");
		}
	}

	/**
	 * based on the value of next calculate the position and speed next 0.1s
	 * 
	 * @throws IOException
	 */

	void calculateNextPosition() throws IOException {
		if (this.status == 2) {// do nothing is stop

		} else if (this.status == 1) {// emergency stop will make the vehicle
										// stop on its left side close to the
										// edge
			switch (this.angle) {
			case 0:
				this.setLocation_x(this.getLocation_x() - 6);
			case 90:
				this.setLocation_y(this.getLocation_y() - 6);
			case 180:
				this.setLocation_x(this.getLocation_x() + 6);
			case 270:
				this.setLocation_y(this.getLocation_y() + 6);
			}
		} else if (this.status == 4) {// recover from emergency stop
			switch (this.angle) {
			case 0:
				this.setLocation_x(this.getLocation_x() + 6);
			case 90:
				this.setLocation_y(this.getLocation_y() + 6);
			case 180:
				this.setLocation_x(this.getLocation_x() - 6);
			case 270:
				this.setLocation_y(this.getLocation_y() - 6);
			}
		} else if (this.status == 0) {
			switch (this.angle) {
			case 0:
				this.setLocation_y((int) (this.getLocation_y() - this
						.getSpeed() * 0.1));
			case 90:
				this.setLocation_x((int) (this.getLocation_x() + this
						.getSpeed() * 0.1));
			case 180:
				this.setLocation_y((int) (this.getLocation_y() + this
						.getSpeed() * 0.1));
			case 270:
				this.setLocation_x((int) (this.getLocation_x() - this
						.getSpeed() * 0.1));
			}

		} else {
			System.out.println("There is something wrong");
		}
	}

	public static void main(String[] arg) throws IOException {
		Vehicle v = new Vehicle();
		v.setLocation_x(760);
		v.setLocation_y(539);
		v.setAngle(0);
		v.setLength(32);
		v.setWidth(26);
		v.setSpeed(80);
		// simulate
		while (v.getAngle() == 0) {
			System.out.println("position of the vehicle now is: ("
					+ v.getLocation_x() + "," + v.getLocation_y() + ")");
			v.configureSensors();
			v.turnJudgement();
			v.calculateNextPosition();
			System.out.println("next position of the vehicle is: ("
					+ v.getLocation_x() + "," + v.getLocation_y() + ")"
					+ v.getAngle());
		}
	}

	@Override
	public int getId() {
		return id;
	}

}






