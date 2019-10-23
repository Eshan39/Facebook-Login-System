/*package swing;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLFile {
	
	public void creatXMLFile(){
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(false);
		factory.setValidating(false);
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File file = new File("information.xml"); // XML file to read
		Document document;
		try {
			document = builder.parse(file);
			
			Element userList = document.getDocumentElement();
			
			Element user1 = document.createElement("User");
			user1.setAttribute("UserName", );
			
			String[] elnames = {"FirstName", "LastName", "Email",
					"Password", "ConfirmPassword", "Gender", "BirthDate"};

			String[] elvalues = {user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
					user.getConfirmPw(), user.getGender(), user.getBirthDate()};
			for (int i =0; i < elnames.length; i++) {
			  Element el = createElement(document, elnames[i], elvalues[i]);
			  user1.appendChild(el);
			}
			userList.appendChild(user1);
			writeXMLToFile(document);
			System.out.println("done");
					
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	static private Element createElement(Document document, String elName,String elValue)
	{
		
		Element el = document.createElement(elName);
		el.setTextContent(elValue);
		//javax.xml.soap.Text text = (javax.xml.soap.Text) document.createTextNode(elValue);
		//el.appendChild(text);
		return el;
	}

	static private void writeXMLToFile(Document document)
	{
		TransformerFactory tfact = TransformerFactory.newInstance();
		Transformer tform;
		try {
			tform = tfact.newTransformer();
			tform.setOutputProperty(OutputKeys.INDENT, "yes");
			tform.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
			tform.transform(new DOMSource(document), new StreamResult(new File("information.xml")));
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String[][] ReadXML(){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(false);
		factory.setValidating(false);
	         
	        try {
				DocumentBuilder builder = factory.newDocumentBuilder();
				File file = new File("information.xml"); // XML file to read
				Document document = builder.parse(file);
				Element UserList = document.getDocumentElement();
				
				NodeList users = UserList.getChildNodes();
				for (int i = 0, ii = 0, n = users.getLength() ; i < n ; i++) {
				  Node child = users.item(i);
				  if ( child.getNodeType() != Node.ELEMENT_NODE )
				    continue;
				  Element user = (Element)child;
				  ii++;

				  String Uname = user.getAttribute("UserName");
				  String firstName = getCharacterData(findFirstNamedElement(child,"FirstName"));
				  String lastName = getCharacterData(findFirstNamedElement(child,"LastName"));
				  String email = getCharacterData(findFirstNamedElement(child,"Email"));
				  String password = getCharacterData(findFirstNamedElement(child,"Password"));
				  String conpw = getCharacterData(findFirstNamedElement(child,"ConfirmPassword"));
				  String gender = getCharacterData(findFirstNamedElement(child,"Gender"));
				  String birthdate = getCharacterData(findFirstNamedElement(child,"BirthDate"));
				  
				  String [][] up = new String[n][9];
				  up[ii][0] = Uname;
				  up[ii][1] = firstName;
				  up[ii][2] = lastName;
				  up[ii][3] = email;
				  up[ii][4] = password;
				  up[ii][5] = conpw;
				  up[ii][6] = gender;
				  up[ii][7] = birthdate;
				  return up;
				  

				}
				
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}
	
	
	static private Node findFirstNamedElement(Node parent,String tagName)
	{
	  NodeList children = parent.getChildNodes();
	  for (int i = 0, in = children.getLength() ; i < in ; i++) {
	    Node child = children.item(i);
	    if ( child.getNodeType() != Node.ELEMENT_NODE )
	      continue;
	    if ( child.getNodeName().equals(tagName) )
	      return child;
	  }
	  return null;
	}

	static private String getCharacterData(Node parent)
	{
	  StringBuilder text = new StringBuilder();
	  if ( parent == null )
	    return text.toString();
	  NodeList children = parent.getChildNodes();
	  for (int k = 0, kn = children.getLength() ; k < kn ; k++) {
	    Node child = children.item(k);
	    if ( child.getNodeType() != Node.TEXT_NODE )
	      break;
	    text.append(child.getNodeValue());
	  }
	  return text.toString();
	}
	
	public boolean isOk(String uname, String password){
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(false);
		factory.setValidating(false);
	         
	        try {
				DocumentBuilder builder = factory.newDocumentBuilder();
				File file = new File("information.xml"); // XML file to read
				Document document = builder.parse(file);
				Element UserList = document.getDocumentElement();
				
				NodeList users = UserList.getChildNodes();
				for (int i = 0, ii = 0, n = users.getLength() ; i < n ; i++) {
					  Node child = users.item(i);
					  if ( child.getNodeType() != Node.ELEMENT_NODE )
					    continue;
					  Element user = (Element)child;
					  ii++;
	
					  String Uname = user.getAttribute("UserName");
					  String pass = getCharacterData(findFirstNamedElement(child,"Password"));
					  if(Uname.equals(uname) && pass.equals(password)){
						  return true;
					  }
				}
	        }
	        
	 catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		return false;
	}
}

*/