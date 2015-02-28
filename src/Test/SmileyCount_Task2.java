package Test;

/*
 * used to test the getJframebySt()method
 * @ author Qu Tong
 * @version ver2.0
 * 
 * */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Tools.GetColor;
public class SmileyCount_Task2 {
	/*
	 * @parameter max the maximum number can be used in this program
	 * @return a random number of simely
	 * */
	public static int Generator(int max) {
		int num = 0;
		num = (int) (1 + Math.random() * max);
		System.out.print(num);
		return num;
	}

	static ImageIcon smiley = new ImageIcon("smiley.png");
	/*
	 * @parameter row:number of row in this program; column:number of column in this program;nume:the random number
	 * @return the block contains simely
	 * */
	public static JPanel generater(int row, int column, int num) {
		JPanel SmileyBlock = new JPanel(new GridLayout(row, column));
		for (int i = 0; i < num; i++) {
			JLabel Smiley = new JLabel(smiley);
			SmileyBlock.add(Smiley);
		}
		return SmileyBlock;
	}

	String num[]={"1","2","3","4","5","6","7","8","9","10"};
	private String title = "Welcome to Smiley Count task2";
	private String Enter = "Enter two operands, result and clcik on'check'";
	private String Right = "Correct! Have another go?";
	private String Wrong = "Wrong! Try again!";
	ImageIcon plus = new ImageIcon("plus.png");
	JLabel Top = new JLabel(Enter, JLabel.CENTER);
	JLabel Plus = new JLabel(plus);
	JComboBox num1 = new JComboBox(num);
	JComboBox num2 = new JComboBox(num);
	JComboBox result = new JComboBox(num);
	JLabel plus_bottom = new JLabel("+");
	JLabel equal = new JLabel("=");
	JButton check = new JButton("Check!");
	/*
	 * @parameter right_block:smiley in the right block;left_block:smiley in the right block
	 * @return no return 
	 * this method is used to generate the window of this program. it includes neccesary layout design
	 * */
	public void create() throws AWTException {
		final int ran_right = Generator(10);
		final int ran_left = Generator(10);
		JPanel right_block = generater(3, 4, ran_right);
		JPanel left_block = generater(3, 4, ran_left);
		final JFrame frame = new JFrame(title);
		frame.setVisible(true);
		frame.setSize(1100,450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JPanel panel = new JPanel(new BorderLayout());
		JPanel bottom = new JPanel();
		final FlowLayout flowLayout2 = new FlowLayout(FlowLayout.CENTER, 0, 0);
		flowLayout2.setHgap(0);
		flowLayout2.setVgap(0);
		JPanel outter = new JPanel(flowLayout2);
		
		outter.add(bottom);
		bottom.add(num1);
		bottom.add(plus_bottom);
		bottom.add(num2);
		bottom.add(equal);
		bottom.add(result);
		bottom.add(check);
		panel.add(Top, BorderLayout.NORTH);
		panel.add(outter, BorderLayout.SOUTH);
		panel.add(right_block, BorderLayout.EAST);
		panel.add(left_block, BorderLayout.WEST);
		panel.add(Plus, BorderLayout.CENTER);
		frame.add(panel);
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nu1 = num1.getToolTipText();
				String nu2 = num2.getToolTipText();
				String rs = result.getToolTipText();
				System.out.println("num1:" + nu1 + "num2:" + nu2 + "result:" + rs);
				if (nu1.equals(String.valueOf(ran_left))
						&& nu2.equals(String.valueOf(ran_right))
						&& rs.equals(String.valueOf(ran_left+ran_right))) {
					SmileyCount_Task2 n = new SmileyCount_Task2();
					try {
						n.create();
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					n.Top.setText(Right);
				} else {
					Top.setText(Wrong);
				}
			}
		});
		//this part is used to test the method, it dose work
		int[] result;
		int[] target={29,13};
		result=GetColor.getJframebySt(frame,target[0], target[1]);
		System.out.println("The RGB value of position"+"("+target[0]+","+target[1]+") is: ");
		System.out.println("R: "+result[0]);
		System.out.println("G: "+result[1]);
		System.out.println("B: "+result[2]);
	}

	public static void main(String[] args) throws AWTException {
		SmileyCount_Task2 o = new SmileyCount_Task2();
		o.create();
		
	}
}

