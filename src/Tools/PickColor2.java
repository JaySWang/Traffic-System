package Tools;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 * this class is the method to get color by robot directly,also used to verify the GetColor class
 * improve the reliability 
 * 
 * @author qutong
 * */
public class PickColor2 extends JFrame {
	public static void main(String[] args) {
		PickColor2 pc = new PickColor2();

	}

	public PickColor2() {
		super("Pick Color");
		setSize(200, 200);
		JPanel p = new JPanel();
		getContentPane().add(p);
		// this mouse listener only is limited in the java desktop region
		p.addMouseMotionListener(new PickColorMouesMotionListener(p));
		// this thread is really effected!
		new PickColorThread(p).start();
		setVisible(true);
	}

	/**
	 * Mouse Motion Listener,when mouse are moving, then set corresping screens
	 * color to the JPanels background Color.
	 */
	class PickColorMouesMotionListener extends MouseMotionAdapter { // ÄÚ²¿Àà
		private JPanel p = null;

		PickColorMouesMotionListener(JPanel p) {
			this.p = p;
		}

		public void mouseMoved(MouseEvent e) {
			Color c = pickColor();
			this.p.setBackground(c);
			// System.out.println (c);
		}
	}

	class PickColorThread extends Thread {
		private JPanel p = null;

		PickColorThread(JPanel p) {
			this.p = p;
		}

		public void run() {
			while (true) {
				try {
					Thread.currentThread().sleep(10);
					Color c = pickColor();
					this.p.setBackground(c);
					// try change the foreground when background s r <= 50 or g
					// <= 50 or b <= 50
					Graphics g = p.getGraphics();
					if (c.getRed() <= 50 || c.getGreen() <= 50
							|| c.getBlue() <= 50) {
						g.setColor(Color.WHITE);
					} else {
						g.setColor(Color.BLACK);
					}
					g.drawString(c.toString(), 0, 100);
					g = null;
					// System.out.println (c);
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
		}
	}

	/** Get Screen Color */
	public Color pickColor() {
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