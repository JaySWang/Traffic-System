package Tools;
/**
 * used to transfer grb from 16 to seperate colors
 * @author qutong
 *
 */
public class seperateRGB {
	public static int[] transfer16(int pixel) {
		// TODO Auto-generated method stub
		int[] rgb = new int[3];
		rgb[0] = (pixel & 0xff0000) >> 16;
		rgb[1] = (pixel & 0xff00) >> 8;
		rgb[2] = (pixel & 0xff);
		return rgb;
	}
}
