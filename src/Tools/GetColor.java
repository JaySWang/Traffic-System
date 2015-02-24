package Tools;
/**
 * get color from image is ok
 * using robot to get the image and then use getRGB to get the point
 * using getPixel of robot
 * 
 * @author qutong
 * */

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GetColor {
	/**
	 * 取得图像上指定位置像素的 rgb 颜色分量,并保存到数组rgb里面。
	 * 
	 * @param image
	 *            源图像。
	 * @param x
	 *            图像上指定像素位置的 x 坐标。
	 * @param y
	 *            图像上指定像素位置的 y 坐标。
	 * @return 返回包含 rgb 颜色分量值的数组。元素 index 由小到大分别对应 r，g，b。
	 */
	public static int[] getImageRGB(BufferedImage image, int x, int y) {
		int[] rgb = new int[3];
		int pixel = image.getRGB(x, y);
		rgb[0] = (pixel & 0xff0000) >> 16;
		rgb[1] = (pixel & 0xff00) >> 8;
		rgb[2] = (pixel & 0xff);

		return rgb;
	}

	/**
	 * 取得JFrame上指定位置像素的 rgb 颜色分量,并保存到数组rgb里面。
	 * @param image
	 *            对地图的截图。
	 * @param obj
	 *            JFrame 实体。
	 * @param x
	 *            JFrame上指定像素位置的 x 坐标。
	 * @param y
	 *            JFrame上指定像素位置的 y 坐标。
	 * @return 返回包含 rgb 颜色分量值的数组。元素 index 由小到大分别对应 r，g，b。
	 * @throws AWTException 
	 */
	public static Color getJframeRGB(JFrame obj, int x, int y) throws AWTException {
		Robot rbt = new Robot();
		/*Point point = obj.getLocationOnScreen();
		BufferedImage image = rbt.createScreenCapture(new Rectangle(point.x,
				point.y, obj.getWidth(), obj.getHeight()));*/
		Color selectedColor = rbt.getPixelColor(x, y);
		return selectedColor;
	}
}
