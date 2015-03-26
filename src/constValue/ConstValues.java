package constValue;

import java.io.IOException;

import Tools.Configurations;

/**
 * get configuration data from configuration.txt and set up the corresponding
 * values of particular vehicle
 * 
 * @author qutong
 * 
 */
public class ConstValues {

	// TrafficLight states
	public final static int GREEN = 1;
	public final static int RED = 0;
	public final static int ON = 1;
	public final static int OFF = 0;

	// vehicle behaviors
	public final static int STOP = 0;
	public final static int RUN = 1;
	public final static int TURN_LEFT = 2;
	public final static int TURN_RIGHT = 3;
	public final static int SLOW_DOWN = 4;
	public final static int SPEED_UP = 5;

	// direction(angle)
	public final static int EastToWest = 270;
	public final static int WestToEest = 90;
	public final static int SouthToNorth = 0;
	public final static int NorthToSouth = 180;

	// density level
	public final static int Low = 1;
	public final static int Medium = 2;
	public final static int High = 3;

	// analysis
	public final static int NA = -1;

	// collision state
	public final static int Clear = 0;
	public final static int VehicleCollision = 1;

	// vehicle types;
	public final static int Car = 0;
	public final static int Coach = 1;
	public final static int Bus = 2;
	public final static int NumOfTypes = 3;

	// vehicle
	// speedLimit;
	public static int CarSpeedLimit = 280;
	public static int CoachSpeedLimit = 200;
	public static int BusSpeedLimit = 280;
	public static int PriorityLimit = 250;

	// acceleration
	public static int CarAcceleration = 40;
	public static int CoachAcceleration = 30;
	public static int BusAcceleration = 20;
	public static int PriorityAcceleration = 45;
	// size
	public static int Carlength;
	public static int Carwidth;
	public static int Coachlength;
	public static int Coachwidth;
	public static int Buslength;
	public static int Buswidth;
	public static int Prioritylength;
	public static int Prioritywidth;

	// road info
	public final static int RoadWidth = 36;
	public final static int TrafficLightArea = 60;

	// vehicle behavior
	public final static int Normal = 0;

	public final static int Cautious = 1;

	public final static int NumOfbehaviorType = 2;

	public static double PerformPossibility = 0.02;

	public ConstValues() throws IOException {
		initialVehicleConfiguration();
		System.out.println("Configuration finished!");
	}

	public static int getCarSpeedLimit() {
		return CarSpeedLimit;
	}

	public static int getCarlength() {
		return Carlength;
	}

	public static void setCarlength(int carlength) {
		Carlength = carlength;
	}

	public static int getCarwidth() {
		return Carwidth;
	}

	public static void setCarwidth(int carwidth) {
		Carwidth = carwidth;
	}

	public static int getCoachlength() {
		return Coachlength;
	}

	public static void setCoachlength(int coachlength) {
		Coachlength = coachlength;
	}

	public static int getCoachwidth() {
		return Coachwidth;
	}

	public static void setCoachwidth(int coachwidth) {
		Coachwidth = coachwidth;
	}

	public static int getBuslength() {
		return Buslength;
	}

	public static void setBuslength(int buslength) {
		Buslength = buslength;
	}

	public static int getBuswidth() {
		return Buswidth;
	}

	public static void setBuswidth(int buswidth) {
		Buswidth = buswidth;
	}

	public static int getPrioritylength() {
		return Prioritylength;
	}

	public static void setPrioritylength(int prioritylength) {
		Prioritylength = prioritylength;
	}

	public static void setCarSpeedLimit(int carSpeedLimit) {
		CarSpeedLimit = carSpeedLimit;
	}

	public static int getCoachSpeedLimit() {
		return CoachSpeedLimit;
	}

	public static void setCoachSpeedLimit(int coachSpeedLimit) {
		CoachSpeedLimit = coachSpeedLimit;
	}

	public static int getBusSpeedLimit() {
		return BusSpeedLimit;
	}

	public static void setBusSpeedLimit(int busSpeedLimit) {
		BusSpeedLimit = busSpeedLimit;
	}

	public static int getPriorityLimit() {
		return PriorityLimit;
	}

	public static void setPriorityLimit(int priorityLimit) {
		PriorityLimit = priorityLimit;
	}

	public static int getCarAcceleration() {
		return CarAcceleration;
	}

	public static void setCarAcceleration(int carAcceleration) {
		CarAcceleration = carAcceleration;
	}

	public static int getCoachAcceleration() {
		return CoachAcceleration;
	}

	public static void setCoachAcceleration(int coachAcceleration) {
		CoachAcceleration = coachAcceleration;
	}

	public static int getBusAcceleration() {
		return BusAcceleration;
	}

	public static void setBusAcceleration(int busAcceleration) {
		BusAcceleration = busAcceleration;
	}

	public static int getPriorityAcceleration() {
		return PriorityAcceleration;
	}

	public static void setPriorityAcceleration(int priorityAcceleration) {
		PriorityAcceleration = priorityAcceleration;
	}

	public static int getPrioritywidth() {
		return Prioritywidth;
	}

	public static void setPrioritywidth(int prioritywidth) {
		Prioritywidth = prioritywidth;
	}

	public static double getPerformPossibility() {
		return PerformPossibility;
	}

	public static void setPerformPossibility(double performPossibility) {
		PerformPossibility = performPossibility;
	}

	/**
	 * get and set
	 * 
	 * @throws IOException
	 */
	public void initialVehicleConfiguration() throws IOException {
		int[] configurations = new int[3];
		// String[] types={"car","coach","bus","priority"};
		// car's configuration
		configurations = Configurations.readConfiguration("car");
		this.setCarlength(configurations[0]);
		this.setCarwidth(configurations[1]);
		this.setCarSpeedLimit(configurations[2]);
		this.setCarAcceleration(configurations[3]);
		// coach's configuration
		configurations = Configurations.readConfiguration("coach");
		this.setCoachlength(configurations[0]);
		this.setCoachwidth(configurations[1]);
		this.setCoachSpeedLimit(configurations[2]);
		this.setCoachAcceleration(configurations[3]);
		// bus's configuration
		configurations = Configurations.readConfiguration("bus");
		this.setBuslength(configurations[0]);
		this.setBuswidth(configurations[1]);
		this.setBusSpeedLimit(configurations[2]);
		this.setBusAcceleration(configurations[3]);
		// prioroty's configuration
		configurations = Configurations.readConfiguration("priority");
		this.setPrioritylength(configurations[0]);
		this.setPrioritywidth(configurations[1]);
		this.setPriorityLimit(configurations[2]);
		this.setPriorityAcceleration(configurations[3]);
		// PerformPossibility
//		configurations = Configurations.readConfiguration("PerformPossibility");
//		this.setPerformPossibility(configurations[1]);
		//configurations = Configurations.PerformPossibility();
	}

	public static void main(String[] arg) throws IOException {
		ConstValues c = new ConstValues();
		System.out.println("car's profile: \n" + "legnth: " + c.getCarlength()
				+ "\nwidth: " + c.getCarwidth() + "\nspeedlimit: "
				+ c.getCarSpeedLimit() + "\naccelerate: " + c.getCarAcceleration());
		System.out.println("PerformPossibility: "+c.getPerformPossibility());
	}
}
