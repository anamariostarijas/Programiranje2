import java.util.*;

public class Graf {
	
	int stevec;
	Map<String, Tocka> tocke;
	
	public Graf() {
		stevec = 0;
		tocke = new HashMap<String, Tocka>();
	}
	
	public Tocka tocka(String ime) {
		return tocke.get(ime);
	}
	
	public boolean povezava(Tocka a, Tocka b) {
		return a.sosedi.contains(b);
	}
	
	public Tocka dodajTocko(String ime) {
		Tocka v = tocka(ime);
		if (v == null) {
			v = new Tocka(ime); //ustvarimo novo tocko
			tocke.put(ime, v); //dodamo tocko v slovar
		}
		return v;
	}
	
	public Tocka dodajTocko() {
		while (true) {
			String ime = Integer.toString(++stevec);
			if (tocka(ime) != null) continue;
			Tocka v = new Tocka(ime);
			tocke.put(ime, v);
			return v; //return prekini zanko
		}
		
	}
	
	public void dodajPovezavo(Tocka a, Tocka b) {
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
		for (Tocka u : v.sosedi) u.sosedi.remove(v);
		tocke.remove(v.ime);
	}
	
	//naslednji štirje ne bodo konstruktorji, ker imajo podobne ali iste parametre --> statièna metoda
	//stataiène metode ne morejo uporabljati ostalih metod in obratno, lahko jo pa puklièemo na razredu. Vobratnem primeru
	//bi morali ustvariti nov objekt in na njem poklicati metodo (lahko bomo: Graf.cikel(5))
	
	public Tocka[] dodajTocke(int n) {
		//doodaja tocke v graf this
		Tocka[] tab = new Tocka[n];
		for (int i = 0; i < n; ++i) tab[i] = dodajTocko();
		return tab;
	}
	
	public static Graf prazen(int n) {
		Graf graf = new Graf();
		graf.dodajTocke(n); //ce spredaj ne bi dali graf., bi razumel this.
		return graf;
	}
	
	public static Graf cikel(int n) {
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
		for (Tocka i : tocke.values()) {
			System.out.print(i + ": "); //èe print dobi za parameter ime, ga pretvori v string, uporabi metodo toString
			//zato ne rabimo i.ime, ker smo ga sami prilagodili
			
			for (Tocka v : i.sosedi) {
				System.out.print(" " + v);
			}
		System.out.println();
		}
	}
	
}
