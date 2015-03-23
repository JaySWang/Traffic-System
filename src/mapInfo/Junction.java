package mapInfo;

import java.awt.Rectangle;

public class Junction {
	
	
	Rectangle rect;
	
	
	
	
	public Junction(int location_x,int location_y,int width,int hight){
		
		
		rect = new Rectangle(location_x,location_y,width,hight);
		
	}




	public Rectangle getRect() {
		return rect;
	}
	
	
	

	
	
}
