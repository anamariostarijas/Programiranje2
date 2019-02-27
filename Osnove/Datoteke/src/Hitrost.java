import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.*;
import java.math.*;

public class Hitrost {

	public static void main(String[] args) throws IOException{
		int n = krsitelji("src/podatki.txt", "src/Krsitelji.txt");
		System.out.println("Na datoteki je " + n + " krsiteljev.");

	}
	public static int krsitelji(String imeVhod, String imeIzhod) throws IOException {
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod));
		PrintWriter izhod = new PrintWriter(new FileWriter(imeIzhod));
		int krsitelji = 0;
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("0.00", symbols);
		df.setRoundingMode(RoundingMode.HALF_UP);
		while (vhod.ready()) { // ready preveri, ali je na vhodu še kaj za prebrati
			String vrstica = vhod.readLine().trim();
			if (vrstica.equals("")) continue; // equals preverja po vsebini, == preverja, èe je objekt enak (id objekta)
			String[] info = vrstica.split(" "); //poljubno št presledkov vzame kot loèilo
			int vstop = Integer.parseInt(info[0]);
			int izstop = Integer.parseInt(info[1]);	
			double povprecje = 0.622 / (izstop-vstop)*60*60;
			//povprecje = 622/(izstop-vstop) * 3.6;
			if (povprecje > 80) {
				krsitelji += 1;
				izhod.println(info[2] + df.format(povprecje));
			}
		}
		vhod.close();
		izhod.close();
		return krsitelji;
	}

}
