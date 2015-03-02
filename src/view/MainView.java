package view;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import observer.IVehicleObservable;
import observer.IVehicleObserver;

import java.awt.BorderLayout;

public class MainView implements IVehicleObserver{

	private JFrame frame;
	DrawPanel panel;

	Graphics g ;


	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new DrawPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		frame.setVisible(true);

	
	    
	}

	@Override
	public void update(IVehicleObservable o) {
		panel.update(o);
		
	}
}
