package swing;

import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
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

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XML {
	//public static String id ="0";
	public void writeXML(String firstname ,String lastname,String email, String password, String gender) throws Exception {
		
		
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbf.newDocumentBuilder();
		
		Document document=db.parse(new File("information.xml"));
		
		Element element=document.getDocumentElement();
		Element account=document.createElement("Account");
		//account.setAttribute("id", id);
		
		String[] elementValue= {firstname,lastname,email,password,gender};
		String[] elementName= {"FirstName","LastNames","Email","password","gender"};
		
		for(int i=0;i<elementValue.length;i++) {
			
			Element elmt=createNewElement(document,elementName[i],elementValue[i]);
			account.appendChild(elmt);
			
		}
		
		element.appendChild(account);
		addNewAttribute(document);
		
	}


	private Element createNewElement(Document document, String elementName, String elementValue) {
		Element element=document.createElement(elementName);
		
		element.setTextContent(elementValue);
		
		return element;
	}

		
	private void addNewAttribute(Document document){
		
		TransformerFactory tf=TransformerFactory.newInstance();
		
		Transformer transfer;
		try {
			transfer = tf.newTransformer();
			transfer.setOutputProperty(OutputKeys.INDENT, "yes");
			transfer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
			
			DOMSource source=new DOMSource(document);
			StreamResult sr=new StreamResult(new File("information.xml"));
			try {
				transfer.transform(source,sr);
			} catch (TransformerException e) {
				
				e.printStackTrace();
			}
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
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
	public boolean isOk(String email, String password){
		
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
	
					  String email1 = user.getAttribute("Email");
					  String pass = getCharacterData(findFirstNamedElement(child,"password"));
					  if(email1.equals(email1) && pass.equals(password)){
						  
						  System.out.println("Read HOise");
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