package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.TrafficLight;
import modelInterface.ITrafficLight;
import Controller.TrafficLightController;
import ControllerInterface.ITrafficLightController;

import observer.IVehicleObservable;
import observer.IVehicleObserver;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import Tools.ScreenShotofMap;

import constValue.ConstValues;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView implements IVehicleObserver{

	private JFrame frame;
	MapView mapPanel;
	JPanel controlPanel;
	Graphics g ;
    Toolkit kit = Toolkit.getDefaultToolkit();




 	private final JPanel panel = new JPanel();
    
    
 	JButton btnOn;
 	JButton btnOff;
 	JComboBox comboBox;
    
    
    
    
    
	/**
	 * Create the application.
	 */
	public MainView(MapView mp) {
		super();
		mapPanel = mp;
		initialize();
	}
	
	
	



	public void setMapPanel(MapView mp){
		
		mapPanel = mp;
	};

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		
		Dimension screenSize = kit.getScreenSize();
		frame.setBounds(0, 0, screenSize.width,screenSize.height);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1280, 0};
		gridBagLayout.rowHeights = new int[]{100, 600, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		
		//control view
		controlPanel = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		frame.getContentPane().add(controlPanel, gbc_panel_1);
		FlowLayout fl_controlPanel = new FlowLayout(FlowLayout.CENTER, 5, 5);
		fl_controlPanel.setAlignOnBaseline(true);
		controlPanel.setLayout(fl_controlPanel);
		
		JLabel lblTrafficlightSetting = new JLabel("TrafficLight\uFF1A");
		controlPanel.add(lblTrafficlightSetting);
		
		JSplitPane splitPane = new JSplitPane();
		controlPanel.add(splitPane);
		
		 btnOn = new JButton("On");
		btnOn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				mapPanel.setTrafficLightState(ConstValues.ON);
				btnOn.setEnabled(false);
				btnOff.setEnabled(true);

				
			}
		});
		splitPane.setLeftComponent(btnOn);
		
		btnOff = new JButton("Off");
		btnOff.setEnabled(false);

		btnOff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mapPanel.setTrafficLightState(ConstValues.OFF);
				btnOn.setEnabled(true);
				btnOff.setEnabled(false);

			}
		});
		splitPane.setRightComponent(btnOff);
		
		JLabel lblIntervalTime = new JLabel("Interval Time\uFF1A");
		controlPanel.add(lblIntervalTime);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		controlPanel.add(comboBox);
		
		JButton btnSet = new JButton("Set");
		btnSet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mapPanel.setIntervalTime((String) comboBox.getSelectedItem());
							
			}
		});
		controlPanel.add(btnSet);
		controlPanel.add(panel);
		
		JButton btnAnalysisResult = new JButton("Analysis Result");
		btnAnalysisResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			AnalysisView analysisFrame = new AnalysisView();
				
			}
		});
		panel.add(btnAnalysisResult);
		
		

		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(mapPanel, gbc_panel);
		frame.setVisible(true);

		
	
		frame.setVisible(true);
	    
	}


	@Override
	public void update(IVehicleObservable o) {
		mapPanel.update(o);
		
	}
}
