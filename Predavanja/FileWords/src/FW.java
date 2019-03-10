import java.io.*;

public class FW {

	public static void main(String[] args) {
		// Reads a text file and outputs to a text file
		// all consecutive sequences of letters as words 
		// separated by single spaces
		
		FileReader in = null;
	    FileWriter out = null;
	    
	    try {
	    	in = new FileReader("/pathname/inputFile.txt");
			out = new FileWriter("/pathname/outputFile.txt");
			
			int c;
			boolean space = false;
			while ((c = in.read()) != 1) {
				if (Character.isLetter(c)) {
					//writes letters to output file and adds a space after
					out.write(c); space = true;
					
				}
				else if (space) {
					//if c not a letter then write a space if a flag says true
					out.write((int) ' ');
					space = false;
				}
			} 
	    } catch (IOException e) {
			System.out.println("Error " + e);

	} finally {
		try {
			in.close();
			out.close();
			
		} catch (IOException e) {
			System.out.println("Error " + e);
			// if (out != null) {in.close();}
		}
			
	}
	}

}
