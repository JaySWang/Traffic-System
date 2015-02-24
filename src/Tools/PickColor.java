package Tools;

import java.awt.*;

public class PickColor {
	public static void main(String[] args) {
		PickColor pc = new PickColor();
		Color color = pc.pickColor();
		System.out.println("color = " + color);
	}

	Color pickColor() {
		Color pixel = new Color(0, 0, 0);
		Robot robot = null;
		Point mousepoint;
		int R, G, B;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			System.exit(1);
		}
		mousepoint = MouseInfo.getPointerInfo().getLocation();
		pixel = robot.getPixelColor(mousepoint.x, mousepoint.y);
		R = pixel.getRed();
		G = pixel.getGreen();
		return pixel;
	}
}