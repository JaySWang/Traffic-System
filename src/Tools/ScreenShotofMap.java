package Tools;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * this class include methods used to get screenshot of the UI of system.
 * 
 * @author qutong
 * 
 */
public class ScreenShotofMap {
	/**
	 * this method used to get the image of map
	 * 
	 * @param obj
	 *            software's UI
	 * @throws AWTException
	 * @throws IOException
	 */
	public void updateScreenShot(JPanel obj) throws AWTException, IOException {
		Robot rbt = new Robot();
		Point point = obj.getLocationOnScreen();
		BufferedImage ScreenShot = rbt.createScreenCapture(new Rectangle(
				point.x, point.y, obj.getWidth(), obj.getHeight()));
		// BufferedImage image = MyScreenShot.this.robot.createScreenCapture(new
		// Rectangle(0, 0,screenSize.width, screenSize.height));
	
		ImageIO.write(ScreenShot, "png", new File("screensho_current.png"));
	}

	/**
	 * 
	 * @param obj
	 *            software's UI
	 * @param serial
	 *            the serial number used to distinguish the sequence,maybe it's
	 *            the timer's value
	 */
	void recordHistory(JFrame obj, int serial) {
	}
}
