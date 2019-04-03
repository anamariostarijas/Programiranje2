import javax.swing.JDialog;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Nastavitve extends JDialog {
	
	public Nastavitve(JFrame okno) {
		super(okno, "Nastavitve", true); //modalno okno, dokler je odprto, nièesar ne moremo poèeti
		pack();
	}

}
