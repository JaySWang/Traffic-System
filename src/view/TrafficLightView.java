package view;

import java.awt.EventQueue;
import java.awt.IllegalComponentStateException;
import java.awt.TextComponent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;

import model.TrafficLight;
import modelInterface.ITrafficLight;

import observer.ITrafficLightObservable;
import observer.ITrafficLightObserver;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;

import ControllerInterface.ITrafficLightController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

public class TrafficLightView implements ITrafficLightObserver {

	private JFrame frame;
	ImageIcon greenIcon = new  ImageIcon("/Users/ssw/Desktop/green.jpg","green");
	ImageIcon redIcon = new  ImageIcon("/Users/ssw/Desktop/red.jpg","red");

	JButton greenB = new JButton(greenIcon); 
	JButton redB = new JButton(redIcon); 
	List<JButton> lightList;
	JButton light1;
	JButton light2; 
	JButton light3;
	JButton light4;
	private JSplitPane splitPane;
	private JButton btnOff;
	private JButton btnOn;
	
	ITrafficLight trafficLight;
	ITrafficLightController trafficLightController;
	
	//Interval Time in sec
	String[] values = {"1","2","3"};

	

	/**
	 * Launch the application.
	 */
	
	
	public void on(){
	
	}



	public TrafficLightView(ITrafficLight t,ITrafficLightController c) {
		trafficLight = t;
		
		trafficLightController = c;
		
		
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lightList = new ArrayList();
		frame.getContentPane().setLayout(null);
		
		splitPane = new JSplitPane();
		splitPane.setBounds(36, 14, 163, 33);
		frame.getContentPane().add(splitPane);
		
		btnOff = new JButton("Off");
		btnOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Off");
				btnOn.setEnabled(true);

				btnOff.setEnabled(false);
				trafficLightController.off();


			}
		});
		splitPane.setRightComponent(btnOff);
		
		btnOn = new JButton("On");
		btnOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.out.println("On");
				btnOn.setEnabled(false);

				btnOff.setEnabled(true);
				trafficLightController.on();
			}
		});
		splitPane.setLeftComponent(btnOn);
		
		
		light1 = new JButton(greenIcon);
		light1.setBounds(204, 5, 56, 52);
		lightList.add(light1);
		frame.getContentPane().add(light1);
		
		light2 = new JButton(redIcon);
		light2.setBounds(265, 9, 46, 44);
		frame.getContentPane().add(light2);
		lightList.add(light2);
		
	    light3 = new JButton(redIcon);
	    light3.setBounds(316, 9, 46, 44);
		frame.getContentPane().add(light3);
		lightList.add(light3);
		
		light4 = new JButton(redIcon);
		light4.setBounds(367, 9, 46, 44);
		frame.getContentPane().add(light4);
		lightList.add(light4);
		
		JLabel lblIntervalTime = new JLabel("Interval Time");
		lblIntervalTime.setBounds(79, 101, 87, 16);
		frame.getContentPane().add(lblIntervalTime);
		
		

		final JComboBox comboBox = new JComboBox(values);
		
		comboBox.setToolTipText("");
		comboBox.setBounds(176, 97, 84, 27);
		frame.getContentPane().add(comboBox);
		
		
		
		JButton btnSet = new JButton("Set");
		btnSet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				trafficLightController.setIntervalTime((String) comboBox.getSelectedItem());
							
			}
		});
		btnSet.setBounds(281, 96, 117, 29);
		frame.getContentPane().add(btnSet);
		
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
		});
		
		
	}





	@Override
	public void update(ITrafficLightObservable o) {
		List states = ((ITrafficLight)o).getStates();
		for(int i = 0;i<states.size();i++){
			if(states.get(i).equals(new Integer(0))){			
				lightList.get(i).setIcon(redIcon);		
			}
			else 
				lightList.get(i).setIcon(greenIcon);	
		
		
		}
		
		frame.repaint();
		frame.setVisible(true);
		

		
	}
}
