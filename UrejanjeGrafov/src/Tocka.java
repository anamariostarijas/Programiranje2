import java.util.*;

public class Tocka {
	
	//KOMPONENTE
	String ime;
	Set<Tocka> sosedi; //genericen tip<..>, sosedje tock so tocke
	double x,y;
	
	static int stevec = 0; // stejemo, koliko objektov tega razreda smo naredili
	//static Graf g = new Graf();
	//static {  ta metoda se poklièe samo na zaèetku
	//	g = new Graf();
	//	g.dodajTocko();
	//}
	
	//KONSTRUKTOR
	public Tocka(String ime) { //konstruktorji nimajo tipa pred imenom
		this.ime = ime; //isto kot self. v pythonu, tako se sklièemo na komponento v tem razredu in mu dali 
		//vednost komponente
		sosedi = new HashSet<Tocka>(); //oklepaji, ker je to klic konstruktorja
		//Set ni razred je le vmesnik, zato novega objekta Set ne moremo naredit,rabimo implementacijo vmesnika
		//--> HashSet
		//tudi lahko: this.sosedi, èe nimamo 2 isti imeni, raje ne uporabljamo
		x = y = 0;
		
		//++stevec;
	}
	
	//METODE
	public int stopnja() { //ne rabimo parametra, ker bo avtomatsko vzela tocko this.
		return sosedi.size();
	}
	
	public String toString() {
		return ime;
	}
}
