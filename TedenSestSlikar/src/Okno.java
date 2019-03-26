import java.awt.Color;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class Okno extends JFrame implements ActionListener, ChangeListener {
	
	private Platno platno;
	private JButton zbrisiVse;
	private JSlider sirinaSlider;
	private JButton izberiBarvo;
	private JLabel  aktivnaBarvaLabel;
	private JButton shrani;
	private JButton nalozi;
	
	private final JFileChooser FC = new JFileChooser ();
	
	public Okno(int width, int height) {
		super();
		setTitle("Slikar");
		
		//Glavna plosca
		JPanel glavnaPlosca = new JPanel();
		glavnaPlosca.setLayout(new BoxLayout(glavnaPlosca, BoxLayout.Y_AXIS));
		this.add(glavnaPlosca);
		
		//Platno, na katerega risemo
		platno = new Platno(width, height);
		
		glavnaPlosca.add(platno);
		
		//JPanel za orodja
		JPanel orodjarna = new JPanel();
		
		//orodja damo v orodjarno
		
		//gumb izbrisi vse
		zbrisiVse = new JButton("Zbrisi se");
		orodjarna.add(zbrisiVse);
		zbrisiVse.addActionListener(this);
		
		//izbor sirine
		sirinaSlider = new JSlider(JSlider.HORIZONTAL, 1, 21, 11);
		sirinaSlider.setMajorTickSpacing(5);
		sirinaSlider.setPaintTicks(true);
		orodjarna.add(sirinaSlider);
		sirinaSlider.addChangeListener(this);
		
		//izbor barv
		Color aktivnaBarva = Color.black;
		aktivnaBarvaLabel = new JLabel("       ");
		aktivnaBarvaLabel.setOpaque(true);
		aktivnaBarvaLabel.setBackground(aktivnaBarva);
		platno.setBarva(aktivnaBarva);
		izberiBarvo = new JButton("Izberi barvo");
		izberiBarvo.addActionListener(this);
		orodjarna.add(izberiBarvo);
		orodjarna.add(aktivnaBarvaLabel);
		
		glavnaPlosca.add(orodjarna);
		
		//JPanel za datoteke
		JPanel datoteke = new JPanel();
		
		//shrani datoteko
		shrani = new JButton("Shrani");
		datoteke.add(shrani);
		shrani.addActionListener(this);
		
		//nalozi datoteko
		nalozi = new JButton("Nalozi");
		datoteke.add(nalozi);
		nalozi.addActionListener(this);
		
		glavnaPlosca.add(datoteke);
		
	}
	

	@Override
	public void stateChanged(ChangeEvent e) {
		platno.setSirina(sirinaSlider.getValue());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == zbrisiVse) {
			platno.zbrisiVse();
		} else if (e.getSource() == izberiBarvo) {
			Color novaBarva = JColorChooser.showDialog(this, "Izberite barvo", platno.getBarva());
			if (novaBarva != null) {
				platno.setBarva(novaBarva);
				aktivnaBarvaLabel.setBackground(novaBarva);
			}
			
		} else if (e.getSource() == shrani) {
			FileOutputStream fileOut;
			int returnVal = FC.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = FC.getSelectedFile();
				try {
					fileOut = new FileOutputStream (file);
					ObjectOutputStream objectOut = new ObjectOutputStream (fileOut);
					objectOut.writeObject(platno.getPoteze());
					fileOut.close();
				} catch (IOException exn) {
					exn.printStackTrace();
				}
			}
			
		} else if (e.getSource() == nalozi) {
			FileInputStream fileIn;
			int returnVal = FC.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = FC.getSelectedFile();
				try {
					fileIn = new FileInputStream(file);
					ObjectInputStream objectIn = new ObjectInputStream(fileIn);
					List<Poteza> poteze = (List<Poteza>) objectIn.readObject();
					fileIn.close();
					platno.setPoteze(poteze);
				} catch(Exception exn) {
					exn.printStackTrace();
				}
			}
		}
		
	}

}
