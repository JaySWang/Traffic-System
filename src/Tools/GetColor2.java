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
 * this class different from GetColor, the return value is hexadecimal it will
 * be simplified in the end
 * 
 * @author qutong
 * */

public class GetColor2 {
	File f = new File("screensho_current.png");
	BufferedImage screenshot;

	public GetColor2() throws IOException {
		getImageRGB();
	}

	/**
	 * »°µ√ÕºœÒ…œ÷∏∂®Œª÷√œÒÀÿµƒ rgb —’…´∑÷¡ø,≤¢±£¥ÊµΩ ˝◊Èrgb¿Ô√Ê°£
	 * 
	 * @param image
	 *            ‘¥ÕºœÒ°£
	 * @param x
	 *            ÕºœÒ…œ÷∏∂®œÒÀÿŒª÷√µƒ x ◊¯±Í°£
	 * @param y
	 *            ÕºœÒ…œ÷∏∂®œÒÀÿŒª÷√µƒ y ◊¯±Í°£
	 * @param rgb
	 *            —’…´µƒ∫Ï°¢¬Ã∫Õ¿∂…´≥…∑÷±ª∑÷±Àı∑≈Œ™Œª”⁄ 0 ( »±…Ÿ’‚∏ˆª˘…´ ) ∫Õ
	 *            255 ( ÕÍ»´±•∫Õ ) ÷Æº‰µƒ÷µ°£ ∑µªÿ’˚ ˝µƒ 24-31 Œª « 0xff £¨16-23
	 *            Œª±Ì æ∫Ï…´÷µ£¨8-15 Œª±Ì æ¬Ã…´÷µ£¨0-7 Œª±Ì æ¿∂…´÷µ°£
	 * @return ∑µªÿ∞¸∫¨ rgb —’…´∑÷¡ø÷µµƒ ˝◊È°£‘™Àÿ index ”…–°µΩ¥Û∑÷±∂‘”¶
	 *         r£¨g£¨b°£
	 * @throws IOException
	 */
	public void getImageRGB() throws IOException {
		this.setScreenshot(ImageIO.read(f));
	}

	public BufferedImage getScreenshot() {
		return screenshot;
	}

	public void setScreenshot(BufferedImage screenshot) {
		this.screenshot = screenshot;
	}

	/**
	 * »°µ√JFrame…œ÷∏∂®Œª÷√œÒÀÿµƒ rgb —’…´∑÷¡ø°£
	 * 
	 * @param obj
	 *            JFrame  µÃÂ°£
	 * @param x
	 *            JFrame…œ÷∏∂®œÒÀÿŒª÷√µƒ x ◊¯±Í°£
	 * @param y
	 *            JFrame…œ÷∏∂®œÒÀÿŒª÷√µƒ y ◊¯±Í°£
	 * @return ∑µªÿ RGB —’…´°£
	 * @throws AWTException
	 */
	public Color getJframeRGB(JFrame obj, int x, int y) throws AWTException {
		Robot rbt = new Robot();
		Color selectedColor = rbt.getPixelColor(x, y);
		return selectedColor;
	}

	/**
	 * ¿˚”√robotªÒ»°¥∞ø⁄ΩÿÕº£¨≤¢ π”√µ⁄“ª÷÷∑Ω∑®∂‘ΩÿÕº…œµƒœÒÀÿΩ¯––∂¡»°£¨≤¢±£¥Êrgb
	 * —’…´∑÷¡øµΩ ˝◊Èrgb¿Ô√Ê
	 * advantage£∫Œﬁ¬€ «◊‘º∫ª≠µƒµÿÕºªπ «œ÷¥ÊµÿÕº¥¶¿Ì∫Û÷±Ω” 
	 * π”√µƒÕº∆¨∂ºø…“‘Ω¯–– ∂±
	 * 
	 * @param ScreenShot
	 *            ∂‘µÿÕºµƒΩÿÕº°£
	 * @param obj
	 *            JFrame  µÃÂ°£
	 * @param x
	 *            JFrame…œ÷∏∂®œÒÀÿŒª÷√µƒ x ◊¯±Í°£
	 * @param y
	 *            JFrame…œ÷∏∂®œÒÀÿŒª÷√µƒ y ◊¯±Í°£
	 * @return ∑µªÿ∞¸∫¨ rgb —’…´∑÷¡ø÷µµƒ ˝◊È°£‘™Àÿ index ”…–°µΩ¥Û∑÷±∂‘”¶
	 *         r£¨g£¨b°£
	 * @throws AWTException
	 */
	public static int getJframebySt(JFrame obj, int x, int y)
			throws AWTException {
		Robot rbt = new Robot();
		Point point = obj.getLocationOnScreen();
		BufferedImage ScreenShot = rbt.createScreenCapture(new Rectangle(
				point.x, point.y, obj.getWidth(), obj.getHeight()));
		System.out.println("location x: " + point.x);
		System.out.println("location y: " + point.y);
		System.out.println("width: " + obj.getWidth());
		System.out.println("length: " + obj.getHeight());
		// System.out.println("color of thi spoint is:"
		// +getImageRGB(ScreenShot,x,y));
		return 12;// getImageRGB(ScreenShot,x,y);
	}

	/**
	 * ¿˚”√robotªÒ»°¥∞ø⁄ΩÿÕº£¨≤¢ π”√µ⁄“ª÷÷∑Ω∑®∂‘ΩÿÕº…œµƒœÒÀÿΩ¯––∂¡»°£¨≤¢±£¥Êrgb
	 * —’…´∑÷¡øµΩ ˝◊ÈrgbArray¿Ô√Ê
	 * advantage£∫Œﬁ¬€ «◊‘º∫ª≠µƒµÿÕºªπ «œ÷¥ÊµÿÕº¥¶¿Ì∫Û
	 * ÷±Ω” π”√µƒÕº∆¨∂ºø…“‘Ω¯–– ∂±
	 * 
	 * @param ScreenShot
	 *            ∂‘µÿÕºµƒΩÿÕº°£
	 * @param obj
	 *            JFrame  µÃÂ°£
	 * @param rgbArray
	 *            rgb —’…´∑÷¡ø
	 * @param offset
	 *             « ˝◊È÷–Ω” ’µ⁄“ª∏ˆœÒÀÿ÷µµƒŒª÷√µƒÀ˜“˝
	 * @param scansize
	 *             «ÕºœÒ÷–œ‡¡⁄¡Ω––÷–æﬂ”–œ‡Õ¨––À˜“˝µƒœÒÀÿµƒÀ˜“˝∆´“∆÷µ°£
	 *            »Áπ˚’‚∏ˆ÷µ
	 *            ”Î“™Ã·»°µƒ«¯”ÚµƒøÌ∂»œ‡Õ¨£¨ƒ«√¥“ª––µƒµ⁄“ª∏ˆœÒÀÿæÕª·¥Ê¥¢
	 *            ‘⁄ ˝◊È÷–«∞“ª––◊Ó∫Û“ª∏ˆœÒÀÿ∫Û √ÊµƒÀ˜“˝Œª÷√°£
	 *            »Áπ˚’‚∏ˆ÷µ¥Û”⁄Ã·»°«
	 *            ¯”ÚµƒøÌ∂»£¨ƒ«√¥ ˝◊È÷–£¨‘⁄“ª––◊Ó∫Û∫Õœ¬“ª––ø™ 
	 *            º÷Æº‰æÕª·”–“ª–©Œ¥ π”√µƒÀ˜“˝
	 * @return rgb—’…´∑÷¡ø
	 * @throws AWTException
	 */
	public static int[] getJframebySt2(JFrame obj, int x, int y)
			throws AWTException {
		int[] rgbArray = null;
		int offset = 0;
		int scansize = 0;
		Robot rbt = new Robot();
		Point point = obj.getLocationOnScreen();
		BufferedImage ScreenShot = rbt.createScreenCapture(new Rectangle(
				point.x, point.y, obj.getWidth(), obj.getHeight()));
		ScreenShot.getRGB(point.x, point.y, obj.getWidth(), obj.getHeight(),
				rgbArray, offset, scansize);
		return rgbArray;
	}

	/**
	 * this method get image from the screenshot got by View and store in local
	 * path.
	 * 
	 * @param x
	 * @param y
	 * @return
	 * @throws IOException
	 */
	public int getColorFromImage(int x, int y) throws IOException {
		int result = this.getScreenshot().getRGB(x, y);
		return result;
	}

	/*public static void main(String[] arg) throws IOException {
		GetColor2 g = new GetColor2();
		int[] result;
		result = seperateRGB.transfer16(g.getColorFromImage(1, 113));
		System.out.println("the color in position is : ");
		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);
	}*/

}
