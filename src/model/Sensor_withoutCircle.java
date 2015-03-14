package model;

import java.awt.AWTException;
import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;

import Tools.GetColor;
import Tools.GetColor2;
import Tools.seperateRGB;

/**
 * this sensor can only be used in the no circle maps
 * 
 * @author qutong
 * 
 */
public class Sensor_withoutCircle extends Sensor {

	/**
	 * this method is used to get all the pixels in particular area
	 * 
	 * @param obj
	 *            the UI's Jframe
	 * @return pColor all the pixels' GRB(hexadecimal)
	 * @throws AWTException
	 */
	int[] allPointsColor(JFrame obj) throws AWTException {
		int[] pColor = null;
		int i = 0;
		for (int x = this.getX_min(); x < this.getX_max(); x++) {
			for (int y = this.getY_min(); y < this.getY_max(); y++) {
				pColor[i] = GetColor2.getJframebySt(obj, x, y);
			}
		}
		i++;
		return pColor;
	}

	/**
	 * this method is used to get some the pixels in particular area the number
	 * should be decided after some research work
	 * 
	 * @param obj
	 *            the UI's Jframe
	 * @return pColor all the pixels' GRB(hexadecimal)
	 * @throws IOException
	 */
	int[] randomPointsColor() throws IOException {
		int[] pColor = new int[5];
		for (int i = 0; i < 5; i++) {
			pColor[i] = GetColor2.getColorFromImage(
					randomInt(this.getX_min(), this.getX_max()),
					randomInt(this.getY_min(), this.getY_max()));
		}
		return pColor;
	}

	/**
	 * 
	 * @param points
	 *            the sample points in this area can be all or some
	 * @return coa this is the color of this area, the value should be
	 *         calculated, the specific method will be decided after research
	 *         work
	 * @throws IOException
	 */
	Color areaColor() throws IOException {
		int[] points = this.randomPointsColor();
		int r = 0, g = 0, b = 0;
		Color coa = null;
		for (int i = 0; i < points.length; i++) {
			int rgb[] = seperateRGB.transfer16(points[i]);
			r = rgb[0] + r;
			g = rgb[1] + g;
			b = rgb[2] + b;
		}
		r = r / points.length;
		g = g / points.length;
		b = b / points.length;
		if (this.isRound(255, r) && this.isRound(255, g)
				&& this.isRound(255, b)) {
			coa = Color.white;
		} else if (this.isRound(190, r) && this.isRound(190, g)
				&& this.isRound(190, b)) {
			coa = Color.gray;
		} else if (this.isRound(0, r) && this.isRound(0, g)
				&& this.isRound(0, b)) {
			coa = Color.black;
		} else if (this.isRound(255, r) && this.isRound(0, g)
				&& this.isRound(0, b)) {
			coa = Color.red;
		} else if (this.isRound(255, r) && this.isRound(255, g)
				&& this.isRound(0, b)) {
			coa = Color.yellow;
		} else if (this.isRound(0, r) && this.isRound(255, g)
				&& this.isRound(0, b)) {
			coa = Color.green;
		} else if (this.isRound(0, r) && this.isRound(0, g)
				&& this.isRound(255, b)) {
			coa = Color.blue;
		} else if (this.isRound(255, r) && this.isRound(165, g)
				&& this.isRound(0, b)) {
			coa = Color.orange;
		} else if (this.isRound(0, r) && this.isRound(255, g)
				&& this.isRound(255, b)) {
			coa = Color.cyan;
		}

		return coa;
	}

	public static void main(String[] arg) throws IOException {
		Sensor_withoutCircle n = new Sensor_withoutCircle();
		n.setLocation_x(271);
		n.setLocation_y(590);//147,186
		n.setSize_x(1);
		n.setSize_y(10);
		System.out.println("xmax: " + n.getX_max() + "xmin: " + n.getX_min()
				+ "yman: " + n.getY_max() + "ymin: " + n.getY_min());
		System.out.println("location x: " + n.getLocation_x() + "location y: "
				+ n.getLocation_y() + "x: " + n.getSize_x() + "y: "
				+ n.getSize_y());
		System.out.println("the position's color is " + n.areaColor());
	}
}
