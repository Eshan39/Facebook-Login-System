/*package swing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table {
	
	public void showTable(String[][] data, String[] columns) {

		JFrame tableFrame = new JFrame("SignUpInfoTable");
		JButton back = new JButton("BACK");

//		JPanel tablePanel = new JPanel();
//		JPanel buttonPanel = new JPanel();
//		JPanel fulPanel = new JPanel();
//		fulPanel.setLayout(new FlowLayout());
//		

		JTable infoTable = new JTable(data, columns);

		tableFrame.add(new JScrollPane(infoTable));
		
		
//		back.addActionListener((ActionEvent ae)->{
//			new SignUpWindow();
//			tableFrame.setVisible(false);
//		});
//		buttonPanel.add(back);
//		fulPanel.add(tablePanel);
//		fulPanel.add(buttonPanel);
//		tableFrame.add(fulPanel);
		//tableFrame.add(tablePanel);
		//tableFrame.add(buttonPanel);
		//tablePanel.add(infoTable);
		//tableFrame.add(infoTable);
		tableFrame.setSize(800, 600);
		//tableFrame.pack();
		tableFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tableFrame.setVisible(true);
		
	}

}
*/