import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Okno extends JFrame {
	
	private Platno platno;
	
	public Okno(int width, int height) {
		super();
		setTitle("Slikar");
		platno = new Platno(width, height);
		this.add(platno);
	}

}
