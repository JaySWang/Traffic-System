package mapInfo;

import javax.swing.ImageIcon;

import constValue.ConstValues;

public class Light {

	int location_x;
	int location_y;
	ImageIcon state;
	int lightSize = 30;

	ImageIcon greenIcon = new ImageIcon(getClass().getResource(
			"/Icon/green.jpg"));
	ImageIcon redIcon = new ImageIcon(getClass().getResource("/Icon/red.jpg"));

	
	
	
	
	public void setState(ImageIcon state) {
		this.state = state;
	}

	public int getLocation_x() {
		return location_x;
	}

	public int getLocation_y() {
		return location_y;
	}

	public ImageIcon getState() {
		return state;
	}

	public int getLightSize() {
		return lightSize;
	}

	public ImageIcon getRedIcon() {
		return redIcon;
	}

	public Light(double x, double y, int s) {

		location_x = (int) x;
		location_y = (int) y;

		setState(s);
	}

	public void setState(int s) {
		if (s == ConstValues.GREEN) {
			state = greenIcon;
		} else if (s == ConstValues.RED) {
			state = redIcon;
		}

	}

}
