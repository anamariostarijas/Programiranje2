import java.util.*;

public class Tocka {
	
	//KOMPONENTE
	String ime;
	Set<Tocka> sosedi; //genericen tip<..>, sosedje tock so tocke
	
	//KONSTRUKTOR
	public Tocka(String ime) { //konstruktorji nimajo tipa pred imenom
		this.ime = ime; //isto kot self. v pythonu, tako se sklièemo na komponento v tem razredu in mu dali 
		//vednost komponente
		sosedi = new HashSet<Tocka>(); //oklepaji, ker je to klic konstruktorja
		//Set ni razred je le vmesnik, zato novega objekta Set ne moremo naredit,rabimo implementacijo vmesnika
		//--> HashSet
		//tudi lahko: this.sosedi, èe nimamo 2 isti imeni, raje ne uporabljamo 
	}
	
	//METODE
	public int stopnja() { //ne rabimo parametra, ker bo avtomatsko vzela tocko this.
		return sosedi.size();
	}
	
	public String toString() {
		return ime;
	}
}
