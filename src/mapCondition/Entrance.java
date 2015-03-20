package mapCondition;

public class Entrance {

	
int no;
int location_x;
int location_y;
int direction;

//count the number of passing vehicles
int count = 0;

public Entrance(int no, int location_x, int location_y, int direction) {
	super();
	this.no = no;
	this.location_x = location_x;
	this.location_y = location_y;
	this.direction = direction;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

public int getLocation_x() {
	return location_x;
}

public int getLocation_y() {
	return location_y;
}

public int getDirection() {
	return direction;
}





}
