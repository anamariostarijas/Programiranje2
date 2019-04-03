
public class Test {

	public static void main(String[] args) {
		Graf graf = Graf.cikel(5);
		
		graf.izpis();
		
		//Graf g = new Graf();
		//Tocka a = g.dodajTocko("a");
		//Tocka b = g.dodajTocko("b");
		//Tocka c = g.dodajTocko("c");
		//Tocka d = g.dodajTocko();
		//g.dodajPovezavo(a, b);
		//g.dodajPovezavo(b, c);
		//g.dodajPovezavo(c, d);
		//g.izpis();
		
		Okno okno = new Okno();
		okno.pack();
		okno.setVisible(true);
		graf.razporedi(300, 300, 200);
		okno.platno.narisi(graf);
	}

}
