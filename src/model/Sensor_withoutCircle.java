package model;

import java.awt.AWTException;
import java.awt.Color;

import javax.swing.JFrame;

import Tools.GetColor;
import Tools.GetColor2;
import Tools.seperateRGB;
/**
 * this sensor can only be used in the no circle maps
 * @author qutong
 *
 */
public class Sensor_withoutCircle extends Sensor{
	int x_min=this.getLocation_x()-this.getSize_x()/2;
	int x_max=this.getLocation_x()+this.getSize_x()/2;
	int y_min=this.getLocation_y()-this.getSize_y()/2;
	int y_max=this.getLocation_y()-this.getSize_y()/2;
	/**
	 * this method is used to get all the pixels in particular area
	 * @param obj
	 * 		the UI's Jframe
	 * @return pColor 
	 * 		all the pixels' GRB(hexadecimal)
	 * @throws AWTException
	 */
	int[] allPointsColor(JFrame obj) throws AWTException{
		int[] pColor=null;
		int i=0;
		for(int x=x_min;x<x_max;x++){
			for(int y=y_min;y<y_max;y++){
				pColor[i]=GetColor2.getJframebySt(obj,  x,  y);
			}
		}
		i++;
		return pColor;
	}
	/**
	 * this method is used to get some the pixels in particular area 
	 * the number should be decided after some research work
	 * @param obj
	 * 		the UI's Jframe
	 * @return pColor 
	 * 		all the pixels' GRB(hexadecimal)
	 * @throws AWTException
	 */
	int[] randomPointsColor(JFrame obj) throws AWTException{
		int[] pColor=new int[4];
		for(int i=0;i<5;i++){
			pColor[i]=GetColor2.getJframebySt(obj,  randomInt(x_min,x_max),  randomInt(y_min,y_max));
		}
		return pColor;
	}
	/**
	 * 
	 * @param points
	 * 		the sample points in this area can be all or some
	 * @return coa
	 * 		this is the color of this area, the value should be calculated, 
	 * 		the specific method will be decided after research work
	 * @throws AWTException 
	 */
	Color areaColor(JFrame obj) throws AWTException{
		int[] points=this.randomPointsColor(obj);
		Color coa = null;
		for(int i=0;i<points.length;i++){
			int rgb[]=seperateRGB.transfer16(points[i]);
		}
		
		return coa;
	}
}
