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
import Controller.MainController;
import Controller.TrafficLightController;
import ControllerInterface.ITrafficConditionController;
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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainView implements IVehicleObserver{

	private JFrame frame;
	MapView mapPanel;
	JPanel controlPanel;
	Graphics g ;
    Toolkit kit = Toolkit.getDefaultToolkit();




 	private final JPanel panel = new JPanel();
    
    
 	JButton btnOn;
 	JButton btnOff;
 	JButton btnLightSet;
 	JComboBox comboBox;
    
 	
 	ITrafficConditionController tcc;
 	private JLabel lblSpeedlimit;
 	private JLabel label;
 	private JLabel lblDensityLevel;
 	private JComboBox comboBox_density;
 	private JButton btnDensitySet;
 	private JComboBox comboBox_speedLimit;
 	private JButton btnSpeedSet;
 	private JMenuBar menuBar;
 	private JMenu mnMaps;
 	private JMenuItem mntmTRoad;
 	private JMenuItem mntmCrossRoad;
 	private JMenuItem mntmTcrosslRoad;
	private MainController mainController;
	private JLabel lblMs;
	private JLabel lblSec;
	private JButton btnPrivilege;
    
    
    
    
	/**
	 * Create the application.
	 * @param mainController 
	 */
	public MainView(MapView mapView,MainController mainController, ITrafficConditionController tcc) {
		super();
		this.mainController = mainController;
		this.tcc = tcc;
		mapPanel = mapView;
		initialize();
	}
	
	
	



	public void setMapPanel(MapView mp){
		frame.getContentPane().remove(mapPanel);
		mapPanel = mp;
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(mapPanel, gbc_panel);
		
		
	};

	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		
		Dimension screenSize = kit.getScreenSize();
		frame.setBounds(0, 0, 1200,screenSize.height);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1200, 0};
		gridBagLayout.rowHeights = new int[]{100, 600, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		
		//control view
		controlPanel = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.WEST;
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
				comboBox.setEnabled(true);
				comboBox.setSelectedIndex(0);
				btnLightSet.setEnabled(true);

				
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
				comboBox.setEnabled(false);
				btnLightSet.setEnabled(false);

			}
		});
		splitPane.setRightComponent(btnOff);
		
		JLabel lblIntervalTime = new JLabel("Interval Time\uFF1A");
		controlPanel.add(lblIntervalTime);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		controlPanel.add(comboBox);
		
		btnLightSet = new JButton("Set");
		
		btnLightSet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mapPanel.setIntervalTime((String) comboBox.getSelectedItem());
							
			}
		});
		btnLightSet.setEnabled(false);
		comboBox.setEnabled(false);
		
		lblSec = new JLabel("sec");
		controlPanel.add(lblSec);

		controlPanel.add(btnLightSet);
		
		lblSpeedlimit = new JLabel("SpeedLimit\uFF1A");
		controlPanel.add(lblSpeedlimit);
		
		label = new JLabel("");
		controlPanel.add(label);
		
		comboBox_speedLimit = new JComboBox();
		comboBox_speedLimit.setModel(new DefaultComboBoxModel(new String[] {"N/A", "4", "8", "16", "32"}));
		controlPanel.add(comboBox_speedLimit);
		
		btnSpeedSet = new JButton("Set");
		btnSpeedSet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String speedLimit = (String)comboBox_speedLimit.getSelectedItem();
				tcc.setSpeedLimit(speedLimit);

				
			}
		});
		btnSpeedSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		lblMs = new JLabel(" m/s");
		controlPanel.add(lblMs);
		controlPanel.add(btnSpeedSet);
		
		lblDensityLevel = new JLabel("Density Level:");
		controlPanel.add(lblDensityLevel);
		
		comboBox_density = new JComboBox();
		comboBox_density.setModel(new DefaultComboBoxModel(new String[] {"low", "medium", "high"}));
		controlPanel.add(comboBox_density);
		
		btnDensitySet = new JButton("Set");
		btnDensitySet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String densityLevel = (String)comboBox_density.getSelectedItem();
				
				tcc.setDensity(densityLevel);

				
			}
		});
		controlPanel.add(btnDensitySet);
		controlPanel.add(panel);
		
		JButton btnAnalysisResult = new JButton("Analysis Result");
		btnAnalysisResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			AnalysisView analysisFrame = new AnalysisView();
				
			}
		});
		panel.add(btnAnalysisResult);
		
		btnPrivilege = new JButton("Privilege");
		btnPrivilege.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tcc.newPrivilegeVehicle();

			
			}
		});
		panel.add(btnPrivilege);
		
		

		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(mapPanel, gbc_panel);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnMaps = new JMenu("Maps");
		menuBar.add(mnMaps);
		
		mntmTRoad = new JMenuItem("T Road");
		mntmTRoad.addMouseListener(new MouseAdapter() {
		

			@Override
			public void mousePressed(MouseEvent e) {
				frame.setVisible(false);

				mainController.setMaps("TRoad");
				mainController.start();
			}
		});
		
		
		
		mnMaps.add(mntmTRoad);
		
		mntmCrossRoad = new JMenuItem("Cross Road");
		mntmCrossRoad.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				frame.setVisible(false);

				mainController.setMaps("CrossRoad");
				mainController.start();

				
				
			}
		});
		mnMaps.add(mntmCrossRoad);
		
		mntmTcrosslRoad = new JMenuItem("T&Cross&L Road");
		mntmTcrosslRoad.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				frame.setVisible(false);

				mainController.setMaps("TLCrossRoad");
				mainController.start();

			}
		});
		mnMaps.add(mntmTcrosslRoad);

		
	
		frame.setVisible(true);
	    
	}


	@Override
	public void update(IVehicleObservable o) {
		mapPanel.update(o);
		
	}
	
	
	
	
}
