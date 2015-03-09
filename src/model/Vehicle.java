package model;
/**
 * this class is the model of all the vehicle in this system, this version doesn't consider the circle
 * @author qutong
 * @version 1.0
 *
 */
public class Vehicle implements IVehicle {
	private int width;
	private int length;
	private int location_x;
	private int location_y;
	private int speed;//if the refresh 0.1s,the min speed is 1m/s therefore every pixel represent 0.1 meter
	private int angle;//0-360
	private int acceleration;
	private String next;//what will the vehicle do

	Sensor s1;
    Sensor s2;
    Sensor s3;
    Sensor s4;
    Sensor s5;
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
	public Sensor getS1() {
		return s1;
	}
	public void setS1(Sensor s1) {
		this.s1 = s1;
	}
	public Sensor getS2() {
		return s2;
	}
	public void setS2(Sensor s2) {
		this.s2 = s2;
	}
	public Sensor getS3() {
		return s3;
	}
	public void setS3(Sensor s3) {
		this.s3 = s3;
	}
	public Sensor getS4() {
		return s4;
	}
	public void setS4(Sensor s4) {
		this.s4 = s4;
	}
	public Sensor getS5() {
		return s5;
	}
	public void setS5(Sensor s5) {
		this.s5 = s5;
	}
    public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	/**
	 * this part used to configure sensors based on vehicle's position on the map, 
	 * and different sensor has different size
	 * this part hasn't been wrote coz the value need more research work
	 * @param Dsv
	 * related position
	 * @param vehicle's parameters
	 */
	void configureSensors(){
		
	}
	/**
	 * this part used to decide what will the vehicle do in next,
	 * @param next
	 * this value will be set to tell the UI what will the car do in the next,it can be:
	 * ahead,left,right,slow,stop
	 * @param vehicle's parameters
	 */
    void turnJudgement(){
    	
    }
    /**
     * based on the value of next calculate the position and speed next 0.1s
     */
    void calculateNextPosition(){
    	
    }

}
