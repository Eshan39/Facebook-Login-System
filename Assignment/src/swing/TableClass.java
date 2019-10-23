package swing;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TableClass {

	private JFrame frame;
	JTable table;
	String columns[] ;
	String [][] data;
	/**
	 * @wbp.parser.entryPoint
	 */
	
	public TableClass(String [][] data, String [] columns) {
		this.data = data;
		this.columns = columns;
		InformationTable(data, columns);
	}
	
	public void InformationTable(String [][] data, String [] columns) {
		
		frame = new JFrame();
		table= new JTable(data,columns);
		JScrollPane js = new JScrollPane(table);
		System.out.println("my name");
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		loginFacebook lg = new loginFacebook();
	    		frame.setVisible(false);
	    	
	    	}
	    });
		btnBack.setBounds(353, 283, 66, 23);
		frame.getContentPane().add(btnBack);
		
		frame.add(new JScrollPane(table));
		
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
	
}