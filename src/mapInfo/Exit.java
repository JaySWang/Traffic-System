package mapInfo;

public class Exit {
	int no;
	int location_x;
	int location_y;
	
	//count the number of passing vehicles
	int count = 0;

	public Exit(int no, int location_x, int location_y) {
		super();
		this.no = no;
		this.location_x = location_x;
		this.location_y = location_y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
