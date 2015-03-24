package mapInfo;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import constValue.ConstValues;

public class Light {

	int location_x;
	int location_y;
	int state;
	
	boolean on = false;
	
    ImageIcon icon;
	
	
	Rectangle rectangle;
	
	
	int width;
	int height;
	
	ImageIcon greenIcon = new ImageIcon(getClass().getResource(
			"/Icon/green.jpg"));
	ImageIcon redIcon = new ImageIcon(getClass().getResource("/Icon/red.jpg"));

	int direction; //dectetion direction
	
	
	
	public Rectangle getRectangle() {
		return rectangle;
	}

	public int getDirection() {
		return direction;
	}



	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public int getLocation_x() {
		return location_x;
	}

	public int getLocation_y() {
		return location_y;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public int getState() {
		return state;
	}
	
	public int getLightSize() {
		return greenIcon.getIconWidth();
	}

	public ImageIcon getRedIcon() {
		return redIcon;
	}

	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setLocation_x(int location_x) {
		this.location_x = location_x;
	}

	public void setLocation_y(int location_y) {
		this.location_y = location_y;
	}

	public Light(double x, double y, int s ,int direction) {

		location_x = (int) x;
		location_y = (int) y;

		width = greenIcon.getIconWidth();
		height = greenIcon.getIconHeight();
		this.direction = direction;

		setRectangle();
		
		setState(s);
	}

	private void setRectangle() {

		

		
		int x = getLocation_x();
		int y = getLocation_y();
	    
		int rWidth = ConstValues.trafficLightArea;
		int rHeight = ConstValues.trafficLightArea;
       
        
        double  increment = ConstValues.roadWidth;
        
		switch(getDirection()){
		case ConstValues.EastToWest:
			x -= increment;
			rWidth = (int)(rWidth+increment);
			
    	    y-= (rHeight-height);

    	    rHeight = rHeight/4;
			
			
		break;
    	case ConstValues.WestToEest:
    	
    	    rWidth = (int)(width+increment);
    	    y+= rHeight*3/4;
    	    rHeight = rHeight/4;
    	   
		break;
		case ConstValues.NorthToSouth: 
			x -=(rWidth-width);
			rHeight =(int)(height + increment) ;
			
	    	    rWidth = rWidth/4;
		
		break;
		case ConstValues.SouthToNorth: 

		rHeight =(int)(rHeight + increment) ;
		y = (int)(y - increment);
		
		  x+= rWidth*3/4;
  	    rWidth = rWidth/4;
		
		break;
		
		}

		
		rectangle = new Rectangle( x, y,rWidth,rHeight);

	

		
	}

	public void setState(int s) {
		state = s;
		if (s == ConstValues.GREEN) {
			icon = greenIcon;
		} else if (s == ConstValues.RED) {
			icon = redIcon;
		}

	}

}
