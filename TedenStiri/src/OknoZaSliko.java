import javax.swing.JFrame;
import java.awt.*; //includes dimesions,..

public class OknoZaSliko extends JFrame {
	
	private JPanel platno;
	
	public OknoZaSliko () {
		super(); //you have to use a constructor of superclass in the first line
		//we won't define our own constructor but use the one from superclass JFrame
		this.setTitle("Moja slika");
		platno = new JPanel ();
		platno.setPrefferedSize (new Dimension(500, 500));
		platno.setBackground(Color.white);
		this.add(platno);
		
	}

}
