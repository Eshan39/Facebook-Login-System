package swing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Validation {
	
	public boolean nameValidation(String name){
		
		String line = name; 
		String pattern="^(?=.*[A-Z]).{6,14}$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		
		if(m.find()){
			
			return true;
		}
		else
			JOptionPane.showMessageDialog(null, "Name is not valid.");
		return false;
	}
	
	public boolean passwordValidation(String password){
		
		String line = password; 
		String pattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,14})";   
		//String pattern=
		Pattern r = Pattern.compile(pattern);										
		Matcher m = r.matcher(line);												
		
		if(m.find()){
			return true;
		}
		else
			JOptionPane.showMessageDialog(null, "password is not valid");
		return false;
		
	}
	
	public boolean emailValidation(String email){
		
		String line = email; 
		//String pattern = "\\A[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\z";
		//String pattern="^(?=.[@gmail.com]|[@yahoo.com].{2,63})$";
		String pattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		
		if(m.find()){
			return true;
		}
		else
			JOptionPane.showMessageDialog(null, "email is not valid.");
		return false;
	}

	
}
