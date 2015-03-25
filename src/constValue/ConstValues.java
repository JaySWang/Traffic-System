package constValue;

public class ConstValues {

 //TrafficLight states
 public final static  int GREEN = 1;
 public final static int RED = 0;
 public final static int ON = 1;
 public final static int OFF = 0;
 
 
 //vehicle behaviors
 public final static int STOP = 0;
 public final static int RUN = 1;
 public final  static int TURN_LEFT = 2;
 public final static int TURN_RIGHT = 3;
 public final static int SLOW_DOWN = 4;
 public final static int SPEED_UP = 5;
 
 
 //direction(angle)
 public final static int EastToWest = 270;
 public final static int WestToEest = 90;
 public final  static int SouthToNorth = 0;
 public final static int NorthToSouth = 180;

 
 //density level
 public final static int Low = 1;
 public final static int Medium = 2;
 public final static int High = 3;
 

 //analysis
 public final static int NA = -1;
 
 
//collision state
 public final static int Clear = 0;
 public final static int VehicleCollision = 1;

 //vehicle types;
 public final static int Car = 0;
 public final static int Coach = 1;
 public final static int Bus = 2;
 public final static int NumOfTypes = 3;

 //vehicle 
 //speedLimit;
 public final static int CarSpeedLimit = 280;
 public final static int CoachSpeedLimit = 200;
 public final static int BusSpeedLimit = 280;
 public final static int PriorityLimit = 250;

 //acceleration  
 public final static int CarAcceleration = 40;
 public final static int CoachAcceleration = 30;
 public final static int BusAcceleration = 20;
 public final static int PriorityAcceleration = 45;
 
 //road info
 public final static int roadWidth = 36;
 public final static int trafficLightArea = 60;
 
	
}
