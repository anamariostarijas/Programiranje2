import java.util.*;

public class Ladja {
	
	int nosilnost;
	LinkedList<Integer> tovor;
	int odstranjeni;
	
	public Ladja(int nosilnost) {
		this.nosilnost = nosilnost;
		tovor = new LinkedList<Integer>();
		odstranjeni = 0;
	}
	
	public void natovori (int teza) {
		int nalozen = 0;
		for (int i=0; i<tovor.size(); ++i) nalozen += tovor.get(i);
		if (nalozen + teza > nosilnost) {
			int nova = nalozen + teza; 
			while (nova > nosilnost) {
				int odstranjen = tovor.pollFirst();
				odstranjeni += 1;
				nova -= odstranjen;  
			}
		}
		tovor.add(teza);
	}
	
	public int odstranjeni() {
		return odstranjeni;
	}
	
	
	
	
	
	
	

	public static void main(String[] args) {
		Ladja l = new Ladja(30);
		l.natovori(10);
		l.natovori(10);
		l.natovori(10);
		l.natovori(5);
		l.natovori(15);
		l.natovori(30);
		System.out.println(l.tovor);
		System.out.println(l.odstranjeni);
		
	}
}
