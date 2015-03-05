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

public class AnalysisView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JButton btnOk;


	
	
	/**
	 * Create the frame.
	 */
	public AnalysisView() {
		
		
	 Object[][] playerInfo={ 
			     {1,new Integer(66),"On",new Integer(98),0.6}, 
				 {2,new Integer(12),"Off",new Integer(128),0.6},
				 {3,new Integer(22),"On",new Integer(128),0.7},
				 {4,new Integer(33),"On",new Integer(128),0.1},
				 {5,new Integer(44),"On",new Integer(128),0.2},
				 }; 
	 String[] Names={"No","Speed Limit","Traffic Lights","Average Speed","Congestion Rate"}; 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JTable(playerInfo,Names);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{new Integer(1), new Integer(66), "On", new Integer(98), new Double(0.6)},
				{new Integer(2), new Integer(12), "Off", new Integer(128), new Double(0.6)},
				{new Integer(3), new Integer(22), "On", new Integer(128), new Double(0.7)},
				{new Integer(4), new Integer(33), "On", new Integer(128), new Double(0.1)},
				{new Integer(5), new Integer(44), "On", new Integer(128), new Double(0.2)},
				{new Integer(6), new Integer(44), "On", new Integer(128), new Double(0.2)},
			},
			new String[] {
				"No", "Speed Limit", "Traffic Lights", "Average Speed", "Congestion Rate"
			}
		));
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
