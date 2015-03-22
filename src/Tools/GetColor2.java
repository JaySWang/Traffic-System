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
	 * 取得图像上指定位置像素的 rgb 颜色分量,并保存到数组rgb里面。
	 * 
	 * @param image
	 *            源图像。
	 * @param x
	 *            图像上指定像素位置的 x 坐标。
	 * @param y
	 *            图像上指定像素位置的 y 坐标。
	 * @param rgb 
	 * 			  颜色的红、绿和蓝色成分被分别缩放为位于 0 ( 缺少这个基色 ) 和 255 ( 完全饱和 ) 之间的值。
	 * 			  返回整数的 24-31 位是 0xff ，16-23 位表示红色值，8-15 位表示绿色值，0-7 位表示蓝色值。
	 * @return 返回包含 rgb 颜色分量值的数组。元素 index 由小到大分别对应 r，g，b。
	 */
	public static int getImageRGB(BufferedImage image, int x, int y) {
		int pixel = image.getRGB(x, y);
		return pixel;
	}

	/**
	 * 取得JFrame上指定位置像素的 rgb 颜色分量。
	 * @param obj
	 *            JFrame 实体。
	 * @param x
	 *            JFrame上指定像素位置的 x 坐标。
	 * @param y
	 *            JFrame上指定像素位置的 y 坐标。
	 * @return 返回 RGB 颜色。
	 * @throws AWTException 
	 */
	public  Color getJframeRGB(JFrame obj, int x, int y) throws AWTException {
		Robot rbt = new Robot();
		Color selectedColor = rbt.getPixelColor(x, y);
		return selectedColor;
	}
	/**
	 * 利用robot获取窗口截图，并使用第一种方法对截图上的像素进行读取，并保存rgb 颜色分量到数组rgb里面
	 * advantage：无论是自己画的地图还是现存地图处理后直接使用的图片都可以进行识别
	 * @param ScreenShot
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
	 * 利用robot获取窗口截图，并使用第一种方法对截图上的像素进行读取，并保存rgb 颜色分量到数组rgbArray里面
	 * advantage：无论是自己画的地图还是现存地图处理后直接使用的图片都可以进行识别
	 * @param ScreenShot
	 *            对地图的截图。
	 * @param obj
	 *            JFrame 实体。
	 * @param rgbArray
	 *            rgb 颜色分量
	 * @param offset
	 *            是数组中接收第一个像素值的位置的索引
	 * @param scansize
	 *            是图像中相邻两行中具有相同行索引的像素的索引偏移值。
	 *            如果这个值与要提取的区域的宽度相同，那么一行的第一个像素就会存储在数组中前一行最后一个像素后 面的索引位置。
	 *            如果这个值大于提取区域的宽度，那么数组中，在一行最后和下一行开始之间就会有一些未使用的索引   
	 * @return rgb颜色分量
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
