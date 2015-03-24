package mapInfo;

import java.awt.Rectangle;

public class Junction {
	
	
	Rectangle rectangle;
	
	int angle;
	
	
	
	public Junction(int location_x,int location_y,int width,int hight){
		
		
		rectangle = new Rectangle(location_x,location_y,width,hight);
		
	}




	public Rectangle getRectangle() {
		return rectangle;
	}




	public int getAngle() {
		return angle;
	}




	public void setAngle(int angle) {
		this.angle = angle;
	}
	
	
	

	
	
}
