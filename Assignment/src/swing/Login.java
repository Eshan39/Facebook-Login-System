package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField ema;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 17));
		frame.setBounds(100, 100, 672, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		FileWriterClass fw=new FileWriterClass();
		XML xm = new XML();
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//String firstname = fName.getText();
				//String lastname=lName.getText();
				String emaail=ema.getText();
				String password=new String(passwordField.getPassword());
				
				
				
				
				//fw.saveInfo(firstname +" , "+ lastname+" , " + ema+" , " + pass+"\n");
				//String e=null;
				//e=fw.getInfo(emaail);
				//String p=null;
				//p=fw.getInfo(password);
				//System.out.println(e +" "+p);
				
				
				/*if(emaail.equals(e) && password.equals(p)) {
					JOptionPane.showMessageDialog(null,"Successfully login......");
				}*/
				if(xm.isOk(emaail, password)){
					JOptionPane.showMessageDialog(null, "Successfully login");
					
				}
				//else if(emaail.equals(null)&&password.equals(null)) {
					//JOptionPane.showMessageDialog(null,"Error login account ......");
				//}
				else 
					JOptionPane.showMessageDialog(null,"Error login account ......");
				
			}
		});
		btnLogin.setBounds(220, 241, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblFacebook = new JLabel("Facebook");
		lblFacebook.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFacebook.setBounds(61, 54, 74, 23);
		frame.getContentPane().add(lblFacebook);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(128, 100, 46, 23);
		frame.getContentPane().add(lblEmail);
		
		ema= new JTextField();
		ema.setBounds(205, 99, 192, 28);
		frame.getContentPane().add(ema);
		ema.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(100, 154, 74, 21);
		frame.getContentPane().add(lblPassword);
		
		JButton btnCreateAccount = new JButton("create account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginFacebook fb=new loginFacebook();
			}
		});
		btnCreateAccount.setBounds(352, 241, 140, 23);
		frame.getContentPane().add(btnCreateAccount);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(205, 154, 192, 22);
		frame.getContentPane().add(passwordField);
	}
}
