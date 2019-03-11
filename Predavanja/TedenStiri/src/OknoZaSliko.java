import javax.swing.*;

@SuppressWarnings("serial")
public class OknoZaSliko extends JFrame {
	//platno JFrama vsakic, ko prepisemo novo platno (dodamo lik na sliko), le naredi novo prazno platno
	//zato bomo raje definirali svoje platno
	
	private Platno platno;
	
	public OknoZaSliko() {
		super(); //you have to use a constructor of superclass in the first line
		//we won't define our own constructor but use the one from superclass JFram
		this.setTitle("Moja slika");
		platno = new Platno ();
		this.add(platno);
	}
	
	public void addLik(Lik l) {
		//dodamo metodo, ki bo risala na platno
		platno.addLik(l);
		
	}

}
