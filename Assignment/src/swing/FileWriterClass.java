package swing;
import java.io.*;

public class FileWriterClass {
	
	private String fileName = "information.txt";
	private File infofile = new File(fileName);
	
	public String getFileName(){
		return fileName;
	}
	public void saveInfo(String info) throws IOException{
		if(!infofile.exists()){
			infofile.createNewFile();
		}
		FileWriter fw = new FileWriter(fileName, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(info);
		bw.flush();
		bw.close();
	}
	
	public int numberOfLine() throws IOException{
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		String line; 
		int lineNumber = 0;
		while((line = br.readLine() )!= null){
			lineNumber++;
		}
		br.close();
		return lineNumber;
	}
	public String[][] readInfo(String file) throws IOException{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		String [] lines = new String[numberOfLine()];
		String [][] info = new String[numberOfLine()][];
		int linenumber = 0; 
		while((line = br.readLine())!= null){
			lines[linenumber] = line;
			info[linenumber] = line.split(",");
			linenumber++;
		}
		br.close();
		return info;
	}
	
	public String getInfo(String searchKey) throws IOException{
		
		
		String [][] elements = readInfo(infofile.getName());
		String s = null;
		System.out.println(searchKey);
		
		for(int i=0; i<numberOfLine(); i++){
			for(int j=0; j<elements[i].length; j++){
				System.out.println(i + " " + j);
				if(elements[i][j].equals(searchKey)){
					s =  elements[i][j];
					
					System.out.println(elements[i][j]);
				}
				//else s=null;
			}
		}
		return s;
	}
}



