package mapInfo;

import java.awt.Rectangle;

public class Exit {
	int no;
	int location_x;
	int location_y;
	int direction;
	Rectangle retangle;
	//count the number of passing vehicles
	int count = 0;

	
	public Exit(int no, int location_x, int location_y, int direction) {
		super();
		this.no = no;
		this.location_x = location_x;
		this.location_y = location_y;
		this.direction = direction;
		retangle = new Rectangle(location_x,location_y,30,30);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Rectangle getRetangle() {
		return retangle;
	}

	public int getDirection() {
		return direction;
	}
	
	
	
}
