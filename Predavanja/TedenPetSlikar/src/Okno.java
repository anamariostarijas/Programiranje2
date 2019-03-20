import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;

@SuppressWarnings("serial")
public class Okno extends JFrame implements ActionListener {
	
	private Platno platno;
	
	private JButton zbrisiVse;
	private JSlider sirinaSlider;
	private JButton izberiBarvo;
	private JLabel trenutnaBarvaLabel;
	
	public Color trenutnaBarva;
	
	
	public Okno(int width, int height) {
		super();
		setTitle("Slikar");
		
		platno = new Platno(this, width, height);
		this.add(platno);
		
		JPanel orodjarna = new JPanel();
		orodjarna.setLayout(new BoxLayout(orodjarna, BoxLayout.X_AXIS));
		//orodja postavimo v orodjarno
		
		zbrisiVse = new JButton("Zbrisi vse");
		zbrisiVse.addActionListener(this);
		
		sirinaSlider = new JSlider(JSlider.HORIZONTAL, 1, 11, 6);
		orodjarna.add(sirinaSlider);
		
		trenutnaBarva = Color.black;
		trenutnaBarvaLabel = new JLabel("    ");
		trenutnaBarvaLabel.setOpaque(true);
		trenutnaBarvaLabel.setBackground(trenutnaBarva);
		izberiBarvo = new JButton("Izberi barvo");
		izberiBarvo.addActionListener(this);
		orodjarna.add(trenutnaBarvaLabel);
		orodjarna.add(izberiBarvo);
		
		//razdelimo okno na dva dela, zgoraj platno, spodaj orodjarna
		getContentPane().add(new JSplitPane(JSplitPane.VERTICAL_SPLIT, platno, orodjarna));
		
	}
	
	public int getTrenutnaSirina() {
		return sirinaSlider.getValue();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == zbrisiVse) {
			platno.zbrisiVse();
		}
		else if (e.getSource() == izberiBarvo) {
			Color novaBarva = JColorChooser.showDialog(this, "Izberite barvo", trenutnaBarva);
			if (novaBarva != null) {
				trenutnaBarva = novaBarva;
				trenutnaBarvaLabel.setBackground(trenutnaBarva);
			}
		}
	}

}
