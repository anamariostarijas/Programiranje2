import java.io.*;
import java.util.*;

public class Naloga3 {

	public static void main(String[] args) throws IOException {
		ocene("src/test.txt");
	}
	
	public static void ocene(String imeVhod) throws IOException{
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod));
		int[] ocene = new int[10];
		while (vhod.ready()) { 
			String vrstica = vhod.readLine().trim();
			if (vrstica.equals("")) continue; 
			String[] info = vrstica.split(" "); 
			int tocke = Integer.parseInt(info[2]);
			int ocena = (int) Math.ceil((tocke+1)*0.1);
			if (ocena == 11) ocena = 10;
			ocene[ocena-1] += 1;
		}
		for (int i=0; i<9; i++) {
			int j = i+1;
			System.out.println(" " + j + ": " + String.join("", Collections.nCopies(ocene[i], "*")));
		}
		System.out.println("10" + ": " + String.join("", Collections.nCopies(ocene[9], "*")));

		vhod.close();
		
	}

}
