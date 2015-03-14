package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import log.AnalysisLog;
import log.LogManagement;

public class AnalysisView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JButton btnOk;


	
	
	/**
	 * Create the frame.
	 */
	public AnalysisView() {
		
	

		
		
		//initial table
		LogManagement lm = LogManagement.getInstance();
		
		//test
		AnalysisLog al0 = new AnalysisLog(10,"on",20,30);
		AnalysisLog al1 = new AnalysisLog(10,"off",2.0,30);
		AnalysisLog al2 = new AnalysisLog(0,"off",2.0,3.0);
		lm.addLog(al0);
		lm.addLog(al1);

		lm.addLog(al2);

		
		
		
		List<AnalysisLog> aLogs = lm.getALogs();
		int x = aLogs.size();

		
		
		int colSize = 5;
	 Object[][] playerInfo = new Object[x][colSize];
	 String[] s;
	 
	 String[] Names={"No","Speed Limit","Traffic Lights","Average Speed","Congestion Rate"}; 
		
	 for(int i = 0;i<aLogs.size();i++){
		 s = new String[colSize];
         s[0] = aLogs.get(i).getNo()+"";		 
         s[1] = aLogs.get(i).getSpeedLimit()+"";	
         s[2] = aLogs.get(i).getTrafficLightState();	
         s[3] = aLogs.get(i).getAverageSpeed()+"";	
         s[4] = aLogs.get(i).getCongestionRate()+"";	
		 playerInfo[i] = s;
		 
	 }
	 
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JTable(playerInfo,Names);
		
		
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		table.setShowHorizontalLines(true); 
		table.setGridColor(new Color(0, 0, 0)) ;

		
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 100));
		this.getContentPane().add(scrollPane, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
close();				
			}

		
		});
		panel.add(btnOk);
		//this.getContentPane().add(table);
		this.setTitle("Traffic Policies Analysis"); 
		this.pack(); 
		this.setVisible(true);
	}
	
	private void close() {
		this.setVisible(false);
		
	}

}
