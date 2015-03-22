package Tools;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * this class different from GetColor, the return value is hexadecimal
 * it will be simplified in the end
 * 
 * @author qutong
 * */

public class GetColor2{
	/**
	 * ȡ��ͼ����ָ��λ�����ص� rgb ��ɫ����,�����浽����rgb���档
	 * 
	 * @param image
	 *            Դͼ��
	 * @param x
	 *            ͼ����ָ������λ�õ� x ���ꡣ
	 * @param y
	 *            ͼ����ָ������λ�õ� y ���ꡣ
	 * @param rgb 
	 * 			  ��ɫ�ĺ졢�̺���ɫ�ɷֱ��ֱ�����Ϊλ�� 0 ( ȱ�������ɫ ) �� 255 ( ��ȫ���� ) ֮���ֵ��
	 * 			  ���������� 24-31 λ�� 0xff ��16-23 λ��ʾ��ɫֵ��8-15 λ��ʾ��ɫֵ��0-7 λ��ʾ��ɫֵ��
	 * @return ���ذ��� rgb ��ɫ����ֵ�����顣Ԫ�� index ��С����ֱ��Ӧ r��g��b��
	 */
	public static int getImageRGB(BufferedImage image, int x, int y) {
		int pixel = image.getRGB(x, y);
		return pixel;
	}

	/**
	 * ȡ��JFrame��ָ��λ�����ص� rgb ��ɫ������
	 * @param obj
	 *            JFrame ʵ�塣
	 * @param x
	 *            JFrame��ָ������λ�õ� x ���ꡣ
	 * @param y
	 *            JFrame��ָ������λ�õ� y ���ꡣ
	 * @return ���� RGB ��ɫ��
	 * @throws AWTException 
	 */
	public  Color getJframeRGB(JFrame obj, int x, int y) throws AWTException {
		Robot rbt = new Robot();
		Color selectedColor = rbt.getPixelColor(x, y);
		return selectedColor;
	}
	/**
	 * ����robot��ȡ���ڽ�ͼ����ʹ�õ�һ�ַ����Խ�ͼ�ϵ����ؽ��ж�ȡ��������rgb ��ɫ����������rgb����
	 * advantage���������Լ����ĵ�ͼ�����ִ��ͼ�����ֱ��ʹ�õ�ͼƬ�����Խ���ʶ��
	 * @param ScreenShot
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
	public static  int getJframebySt(JFrame obj, int x, int y) throws AWTException {
		Robot rbt = new Robot();
		Point point = obj.getLocationOnScreen();
		BufferedImage ScreenShot = rbt.createScreenCapture(new Rectangle(point.x,
				point.y, obj.getWidth(), obj.getHeight()));
		System.out.println("location x: "+point.x);
		System.out.println("location y: "+point.y);
		System.out.println("width: "+obj.getWidth());
		System.out.println("length: "+obj.getHeight());
		System.out.println("color of thi spoint is:" +getImageRGB(ScreenShot,x,y));
		return getImageRGB(ScreenShot,x,y);
	}
	/**
	 * ����robot��ȡ���ڽ�ͼ����ʹ�õ�һ�ַ����Խ�ͼ�ϵ����ؽ��ж�ȡ��������rgb ��ɫ����������rgbArray����
	 * advantage���������Լ����ĵ�ͼ�����ִ��ͼ�����ֱ��ʹ�õ�ͼƬ�����Խ���ʶ��
	 * @param ScreenShot
	 *            �Ե�ͼ�Ľ�ͼ��
	 * @param obj
	 *            JFrame ʵ�塣
	 * @param rgbArray
	 *            rgb ��ɫ����
	 * @param offset
	 *            �������н��յ�һ������ֵ��λ�õ�����
	 * @param scansize
	 *            ��ͼ�������������о�����ͬ�����������ص�����ƫ��ֵ��
	 *            ������ֵ��Ҫ��ȡ������Ŀ����ͬ����ôһ�еĵ�һ�����ؾͻ�洢��������ǰһ�����һ�����غ� �������λ�á�
	 *            ������ֵ������ȡ����Ŀ�ȣ���ô�����У���һ��������һ�п�ʼ֮��ͻ���һЩδʹ�õ�����   
	 * @return rgb��ɫ����
	 * @throws AWTException 
	 */
	public static int[] getJframebySt2(JFrame obj, int x, int y) throws AWTException{
		int[] rgbArray = null;
		int offset = 0;
		int scansize = 0;
		Robot rbt = new Robot();
		Point point = obj.getLocationOnScreen();
		BufferedImage ScreenShot = rbt.createScreenCapture(new Rectangle(point.x,
				point.y, obj.getWidth(), obj.getHeight()));
		ScreenShot.getRGB(point.x, point.y, obj.getWidth(), obj.getHeight(),rgbArray, offset, scansize);
		return rgbArray;
	}
	/**
	 * this method get image from the screenshot got by View and store in local path.
	 * @param x
	 * @param y
	 * @return
	 * @throws IOException
	 */
	public static int getColorFromImage(int x, int y) throws IOException{
		File f= new File("screensho_current.png");
		BufferedImage screenshot =ImageIO.read(f);
		int[] result;
		
		result=seperateRGB.transfer16(getImageRGB(screenshot,x,y));
		/*System.out.println("the color in position is : ");
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);*/
		
		return getImageRGB(screenshot,x,y);
	} 
	
	public static void main(String[] arg) throws IOException{
		GetColor2 g= new GetColor2();
		int[] result;
		result=seperateRGB.transfer16(g.getColorFromImage(1,113 ));
		System.out.println("the color in position is : ");
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);
	}

}
