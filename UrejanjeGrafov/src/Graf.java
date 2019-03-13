import java.util.*;

public class Graf {
	
	//KOMPONENTE
	int stevec;
	Map<String, Tocka> tocke;        //Map --> slovar
	
	//KONSTRUKTOR
	public Graf() {
		stevec = 0;
		tocke = new HashMap<String, Tocka>();
	}
	
	
	//METODE
	public Tocka tocka(String ime) {
		//vrne tocko z danim imenom, ce je ni, null
		return tocke.get(ime);
	}
	
	public boolean povezava(Tocka a, Tocka b) {
		//ali obstaja povezava med danima tockama
		return a.sosedi.contains(b);
	}
	
	public Tocka dodajTocko(String ime) {
		//doda dano tocko in jo vrne
		Tocka v = tocka(ime);
		if (v == null) {
			v = new Tocka(ime); //ustvarimo novo tocko
			tocke.put(ime, v); //dodamo tocko v slovar
		}
		return v;
	}
	
	public Tocka dodajTocko() {
		//ustvari samodejno poimenovano tocko in jo vrne
		while (true) {
			String ime = Integer.toString(++stevec);
			if (tocka(ime) != null) continue;
			Tocka v = new Tocka(ime);
			tocke.put(ime, v);
			return v; //return prekini zanko
		}
		
	}
	
	public void dodajPovezavo(Tocka a, Tocka b) {
		//grafu doda povezavo, ce tocki razlicni
		if (a != b) {
			a.sosedi.add(b);
			b.sosedi.add(a);
		}
		else return;
	}
	
	public void odstraniPovezavo(Tocka a, Tocka b) {
		a.sosedi.remove(b);
		b.sosedi.remove(a);
	}
	
	public void odstraniTocko(Tocka v) {
		//odstani tocko in njene povezave
		for (Tocka u : v.sosedi) u.sosedi.remove(v);
		tocke.remove(v.ime);
	}
	
	//naslednji štirje ne bodo konstruktorji, ker imajo podobne ali iste parametre --> statièna metoda
	//statiène metode ne morejo uporabljati ostalih metod in obratno, lahko jo pa poklièemo na razredu. V obratnem primeru
	//bi morali ustvariti nov objekt in na njem poklicati metodo (lahko bomo: Graf.cikel(5))
	
	public Tocka[] dodajTocke(int n) {
		//pomozna metoda
		//dodaja tocke v graf this
		Tocka[] tab = new Tocka[n];
		for (int i = 0; i < n; ++i) tab[i] = dodajTocko();
		return tab;
	}
	
	public static Graf prazen(int n) {
		//ustvari in vrne nov prazen graf na n tockah
		Graf graf = new Graf();
		graf.dodajTocke(n); //ce spredaj ne bi dali graf., bi razumel this.
		return graf;
	}
	
	public static Graf cikel(int n) {
		//ustvari in vrne nov cikel na n tockah
		Graf graf = new Graf();
		Tocka [] tab = graf.dodajTocke(n);
		for (int i=0; i<n; ++i) graf.dodajPovezavo(tab[i], tab[(i+1) % n]);
		return graf;
	}
	
	public static Graf poln(int n) {
		Graf graf = new Graf();
		Tocka[] tab = graf.dodajTocke(n);
		for (int i = 0; i < n; ++i) {
			for (int k = i+1; k < n; ++k) {
				graf.dodajPovezavo(tab[i], tab[k]);
			}
		}
		return graf;
	}
	
	public static Graf polnDvodelen(int n, int m) {
		Graf graf = new Graf();
		Tocka[] tab1 = graf.dodajTocke(n);
		Tocka[] tab2 = graf.dodajTocke(m);
		for (int i = 0; i < n; ++i) {
			for (int k = 0; k < m; ++k) {
				graf.dodajPovezavo(tab1[i], tab2[k]);
			}
		}
		return graf;
	}
	
	public void izpis() {
		//izpise katere tocke so v grafu in s katerimi so povezane
		for (Tocka i : tocke.values()) {
			System.out.print(i + ": "); //èe print dobi za parameter ime, ga pretvori v string, uporabi metodo toString
			//zato ne rabimo i.ime, ker smo ga sami prilagodili
			
			for (Tocka v : i.sosedi) {
				System.out.print(" " + v);
			}
		System.out.println();
		}
	}
	
	public void razporedi(double x, double y, double r) {
		int n = tocke.size();
		int i = 0;
		for (Tocka v : tocke.values()) {
			double kot = 2*i*Math.PI/n;
			v.x = x + r*Math.cos(kot);
			v.y = y + r*Math.sin(kot); 		//koordinatna os y je obrnjena navzdol
			++i;
		}
	}
	
	
	
	
}
