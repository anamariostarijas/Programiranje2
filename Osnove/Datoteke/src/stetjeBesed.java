import java.io.*;

public class stetjeBesed {

	public static void main(String[] args) throws IOException{ //napako bo vrgla sistemu, ta bo izpisal, kje je prišlo do napake
		int n = stetjeBesed("src/stetjeBesed.java", "src/StetjeBesed.txt");
		System.out.println("Na datoteki je " + n + " besed.");
	}
	
	public static int stetjeBesed(String imeVhod, String imeIzhod) throws IOException { //namesto try, catch, napako da na main metodo
		BufferedReader vhod = new BufferedReader(new FileReader(imeVhod));
		PrintWriter izhod = new PrintWriter(new FileWriter(imeIzhod));
		int stevec = 0;
		while (vhod.ready()) { // ready preveri, ali je na vhodu še kaj za prebrati
			int n = 0;
			String vrstica = vhod.readLine().trim();
			if (vrstica.equals("")) continue; // equals preverja po vsebini, == preverja, èe je objekt enak (id objekta)
			String[] besede = vrstica.split("\\W+"); //poljubno št presledkov vzame kot loèilo
			stevec += besede.length;
			for (String beseda : besede) izhod.println(beseda);
		}
		vhod.close();
		izhod.close();
		return stevec;
	}
}
