import javax.swing.*;

@SuppressWarnings("serial")
public class Okno extends JFrame {
	
	Platno platno;
	
	public Okno() {
		super();
		setTitle("Urejevalnik grafa");
		platno = new Platno(600, 600);
		add(platno);
	}
	
	

}
