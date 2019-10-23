package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPasswordField;

public class loginFacebook {

	JFrame frame;
	private JTextField fName;
	private JTextField lName;
	private JTextField textField_6;
	private JTextField email;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	File file = new File("information.txt");
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					loginFacebook window = new loginFacebook();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public loginFacebook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.setBounds(100, 100, 681, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblFacebook = new JLabel("Facebook");
		lblFacebook.setBounds(57, 31, 127, 59);
		lblFacebook.setFont(new Font("Tahoma", Font.BOLD, 25));
		frame.getContentPane().add(lblFacebook);
		
		fName = new JTextField();
		fName.setBounds(349, 109, 164, 30);
		frame.getContentPane().add(fName);
		fName.setColumns(10);
		
		lName = new JTextField();
		lName.setBounds(349, 150, 164, 30);
		frame.getContentPane().add(lName);
		lName.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("new password");
		lblNewPassword.setBounds(232, 197, 107, 14);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblNewPassword);
		String y[]=new String[119];
		y[0]="year";
		for(int i=1,j=118;i<119;i++,j--) {
			y[i]=String.valueOf(j+1900);
		}
		
		JComboBox year = new JComboBox();
		year.setBounds(250, 330, 69, 20);
		year.setModel(new DefaultComboBoxModel(y));
		frame.getContentPane().add(year);
		
		String [] m= {"Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"};
		
		JComboBox month = new JComboBox();
		month.setBounds(349, 330, 69, 23);
		month.setModel(new DefaultComboBoxModel(m));
		frame.getContentPane().add(month);
		
		String d[]=new String[32];
		d[0]="date";
		for(int i=1,j=31;i<32;i++,j--) {
			d[i]=String.valueOf(j);
		}
	
		JComboBox date = new JComboBox();
		date.setBounds(453, 329, 63, 23);
		date.setModel(new DefaultComboBoxModel(d));
		frame.getContentPane().add(date);
		
		JRadioButton male = new JRadioButton("male");
		male.setBounds(250, 363, 82, 23);
		frame.getContentPane().add(male);
		
		JRadioButton female = new JRadioButton("female");
		female.setBounds(356, 363, 73, 23);
		frame.getContentPane().add(female);
		female.addActionListener((ActionEvent ae)->{
			if(female.isSelected())
				male.setSelected(false);
		});
		male.addActionListener((ActionEvent ae)->{
			if(male.isSelected())
				female.setSelected(false);
		});
		
		
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(126, 364, 82, 23);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(lblGender);
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.setBounds(298, 393, 88, 23);
		btnSubmit.addActionListener(new ActionListener() {
			//private Login l;

			public void actionPerformed(ActionEvent e) {
				
				FileWriterClass fw=new FileWriterClass();
				String firstname = fName.getText();
				String lastname=lName.getText();
				String ema=email.getText();
				String pass=new String(passwordField.getPassword());
				String conPass=new String(passwordField_1.getPassword());
				String myr=(String) year.getSelectedItem();
				String mnth=(String) month.getSelectedItem();
				String dt=(String) date.getSelectedItem();
				String gender="";
				
				Validation vb=new Validation();
				
				if(male.isSelected()) {
					gender="male";
				}
				
				else if(female.isSelected()) {
					gender="female";
				}
				
				System.out.println(firstname +","+ lastname+"," + ema+"," + pass+","+conPass+","+gender+"\n");
				
				if(!firstname.equals("")&&!lastname.equals("")&&!ema.equals("")&&!pass.equals("")&&!conPass.equals("")&&!myr.equals("")&&!mnth.equals("")&&!dt.equals("")&&!gender.equals("")) {
					if(vb.nameValidation(firstname)&&vb.emailValidation(ema)&&vb.passwordValidation(pass)) {
						if(pass.equals(conPass)) {
								XML wx = new XML();
								try {
									wx.writeXML(firstname, lastname,ema,pass,gender);
								} catch (Exception e1) {
								// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
								try {
									fw.saveInfo(firstname +","+ lastname+"," + ema+"," + pass+","+gender+"\n");
									
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								JOptionPane.showMessageDialog(null,"Successfully created......");
						}
							else
								JOptionPane.showMessageDialog(null,"please match password.!");
					}	
						
				}
				else {
					JOptionPane.showMessageDialog(null,"Error,Fullfill the remain blank field......");
					
					}
					
				
			}
		});
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblFirstName_1 = new JLabel("first name");
		lblFirstName_1.setBounds(250, 115, 88, 24);
		lblFirstName_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblFirstName_1);
		
		JLabel lblLastName = new JLabel("last name");
		lblLastName.setBounds(250, 152, 89, 28);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(lblLastName);
		
		JLabel lblConfirmPassword = new JLabel("confirm password");
		lblConfirmPassword.setBounds(195, 229, 151, 30);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(lblConfirmPassword);
		
		JLabel lblEmail_1 = new JLabel("email");
		lblEmail_1.setBounds(270, 273, 69, 34);
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(lblEmail_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(383, 288, -32, 1);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		email = new JTextField();
		email.setBounds(349, 276, 164, 35);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		
		
		JLabel lblBirthdate = new JLabel("BirthDate");
		lblBirthdate.setBounds(116, 330, 107, 23);
		lblBirthdate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.getContentPane().add(lblBirthdate);
		
		
		
		JLabel label = new JLabel("");
		label.setBounds(253, 59, 46, 14);
		frame.getContentPane().add(label);
		
		JButton btnSignIn = new JButton("sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Login();
				frame.setVisible(false);
			}
		});
		btnSignIn.setBounds(340, 55, 89, 23);
		frame.getContentPane().add(btnSignIn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(349, 191, 164, 30);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(349, 229, 164, 28);
		frame.getContentPane().add(passwordField_1);
		
		 FileWriterClass fw=new FileWriterClass();
		 
		
		JButton btnShowinfo = new JButton("ShowInfo");
		
		btnShowinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] columns;
				String [][] data;
				
				columns = new String[] {"Firstname", "Lastname", "Email", "Password", "Gender","Country"};
				
				try {
					data=fw.readInfo(file.getName());
					TableClass table = new TableClass(data,columns);
					
					//table.showTable(data, columns);
			
					//new Table(data, columns);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
				
			}
		});
		btnShowinfo.setBounds(205, 25, 89, 23);
		frame.getContentPane().add(btnShowinfo);
		
		frame.setVisible(true);
	}
}
