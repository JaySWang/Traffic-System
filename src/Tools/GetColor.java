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
	 * ȡ��ͼ����ָ��λ�����ص� rgb ��ɫ����,�����浽����rgb���档
	 * 
	 * @param image
	 *            Դͼ��
	 * @param x
	 *            ͼ����ָ������λ�õ� x ���ꡣ
	 * @param y
	 *            ͼ����ָ������λ�õ� y ���ꡣ
	 * @return ���ذ��� rgb ��ɫ����ֵ�����顣Ԫ�� index ��С����ֱ��Ӧ r��g��b��
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
	 * ȡ��JFrame��ָ��λ�����ص� rgb ��ɫ����,�����浽����rgb���档
	 * @param image
	 *            �Ե�ͼ�Ľ�ͼ��
	 * @param obj
	 *            JFrame ʵ�塣
	 * @param x
	 *            JFrame��ָ������λ�õ� x ���ꡣ
	 * @param y
	 *            JFrame��ָ������λ�õ� y ���ꡣ
	 * @return ���ذ��� rgb ��ɫ����ֵ�����顣Ԫ�� index ��С����ֱ��Ӧ r��g��b��
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
