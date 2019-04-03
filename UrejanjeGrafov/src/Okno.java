import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class Okno extends JFrame implements ActionListener {
	
	Platno platno;
	private JMenuItem menuOdpri, menuShrani, menuKoncaj;
	private JMenuItem menuPrazen, menuCikel, menuPoln, menuPolnDvodelen;
	private JMenuItem menuBarvaPovezave, menuBarvaTocke, menuBarvaAktivneTocke, menuBarvaIzbraneTocke;
	private JMenuItem menuDebelinaPovezave, menuDebelinaRoba;
	private JMenuItem menuPolmer, NastaviNastavitve;
	
	Nastavitve nastavitve;
	
	public Okno() {
		super();
		setTitle("Urejevalnik grafa");
		platno = new Platno(600, 600);
		add(platno);
		
		JMenuBar menubar = new JMenuBar();
		JMenu menuDatoteka = new JMenu("Datoteka");
		JMenu menuGraf = new JMenu("Graf");
		JMenu menuNastavitve = new JMenu("Nastavitve");
		
		menuOdpri = new JMenuItem("Odpri ..."); //zelimo, da je ta dostopen vsem metodam->napisemo ga med komponente
		menuShrani = new JMenuItem("Shrani ...");
		menuKoncaj = new JMenuItem("Koncaj ...");
		menuPrazen = new JMenuItem("Prazen ...");
		menuPoln = new JMenuItem("Poln ...");
		menuCikel = new JMenuItem("Cikel ...");
		menuPolnDvodelen = new JMenuItem("Poln dvodelen ...");
		menuBarvaPovezave = new JMenuItem("Barva povezave ...");
		menuBarvaTocke = new JMenuItem("Barva tocke ...");
		menuBarvaAktivneTocke = new JMenuItem("Barva aktivne tocke ...");
		menuBarvaIzbraneTocke = new JMenuItem("Barva izbrane tocke ...");
		menuDebelinaPovezave = new JMenuItem("Debelina povezave ...");
		menuDebelinaRoba = new JMenuItem("Debelina roba ...");
		menuPolmer = new JMenuItem("Polmer tocke ...");
		NastaviNastavitve = new JMenuItem("Polmer tocke ...");
		
		menuDatoteka.add(menuOdpri);
		menuDatoteka.add(menuShrani);
		menuDatoteka.add(menuKoncaj);
		menuGraf.add(menuCikel);
		menuGraf.add(menuPrazen);
		menuGraf.add(menuPoln);
		menuGraf.add(menuPolnDvodelen);
		menuNastavitve.add(menuBarvaAktivneTocke);
		menuNastavitve.add(menuBarvaTocke);
		menuNastavitve.add(menuBarvaPovezave);
		menuNastavitve.add(menuBarvaIzbraneTocke);
		menuNastavitve.add(menuDebelinaRoba);
		menuNastavitve.add(menuDebelinaPovezave);
		menuNastavitve.add(menuPolmer);
		menuNastavitve.addSeparator();
		menuNastavitve.add(NastaviNastavitve);
		
		menubar.add(menuNastavitve);
		menubar.add(menuDatoteka);
		menubar.add(menuGraf);
		
		setJMenuBar(menubar);
		
		menuOdpri.addActionListener(this);
		menuShrani.addActionListener(this);
		menuKoncaj.addActionListener(this);
		menuPrazen.addActionListener(this);
		menuPoln.addActionListener(this);
		menuCikel.addActionListener(this);
		menuPolnDvodelen.addActionListener(this);
		menuBarvaTocke.addActionListener(this);
		menuBarvaPovezave.addActionListener(this);
		menuBarvaAktivneTocke.addActionListener(this);
		menuBarvaIzbraneTocke.addActionListener(this);
		menuDebelinaRoba.addActionListener(this);
		menuDebelinaPovezave.addActionListener(this);
		menuPolmer.addActionListener(this);
		NastaviNastavitve.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == menuOdpri) {
			JFileChooser chooser = new JFileChooser();
			int gumb = chooser.showOpenDialog(this);
			if (gumb == JFileChooser.APPROVE_OPTION) {
				String ime = chooser.getSelectedFile().getPath();
				Graf graf = Graf.preberi(ime); //tako lahko samo, ker je statièna, ker navadne metode prièakujejo objekt razreda Graf
				platno.narisi(graf);
				
			}
		}
		else if (source == menuShrani) {
			JFileChooser chooser = new JFileChooser();
			int gumb = chooser.showSaveDialog(this);
			if (gumb == JFileChooser.APPROVE_OPTION) {
				String ime = chooser.getSelectedFile().getPath();
				platno.graf.shrani(ime);

		}
		else if (source == menuKoncaj) {
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)); //sistem bo tako poskrbel, da se bo okno zaprlo
		}
		else if (source == menuShrani) {
			
		}
		else if (source == menuBarvaPovezave) {
			Color barva = JColorChooser.showDialog(this, "Barva povezave", platno.barvaPovezave);
			if (barva != null) {
				platno.barvaPovezave = barva;
				platno.repaint();
			}
		}
		else if (source == menuBarvaTocke) {
			Color barva = JColorChooser.showDialog(this, "Barva tocke", platno.barvaTocke);
			if (barva != null) {
				platno.barvaTocke = barva;
				platno.repaint();
			}
		}
		else if (source == menuBarvaAktivneTocke) {
			Color barva = JColorChooser.showDialog(this, "Barva aktivne tocke", platno.barvaAktivneTocke);
			if (barva != null) {
				platno.barvaAktivneTocke = barva;
				platno.repaint();
			}
		}
		else if (source == menuBarvaIzbraneTocke) {
			Color barva = JColorChooser.showDialog(this, "Barva izbrane tocke", platno.barvaIzbraneTocke);
			if (barva != null) {
				platno.barvaIzbraneTocke = barva;
				platno.repaint();
			}
		}
		else if (source == menuPrazen) {
			String niz = JOptionPane.showInputDialog(this, "Število toèk:");
			if (niz != null && niz.matches("\\d+")) {
				Graf g = Graf.prazen(Integer.parseInt(niz));
				g.razporedi(300, 300, 250);
				platno.narisi(g);
			}
		}
		else if (source == menuCikel) {
			String niz = JOptionPane.showInputDialog(this, "Število toèk:");
			if (niz != null && niz.matches("\\d+")) {
				Graf g = Graf.cikel(Integer.parseInt(niz));
				g.razporedi(300, 300, 250);
				platno.narisi(g);
			}
		}
		else if (source == menuDebelinaPovezave) {
			String niz = JOptionPane.showInputDialog(this, "Debelina povezave:", platno.debelinaPovezave);
			if (niz != null && niz.matches("\\d*\\.?\\d+")) { // regularni izraz za realno število
				platno.debelinaPovezave = Float.parseFloat(niz);
				platno.repaint();
			}
		}
		else if (source == menuPoln) {
			String niz = JOptionPane.showInputDialog(this, "Število toèk:");
			if (niz != null && niz.matches("\\d+")) {
				Graf g = Graf.poln(Integer.parseInt(niz));
				g.razporedi(300, 300, 250);
				platno.narisi(g);
			}
		}
		else if (source == menuDebelinaRoba) {
			String niz = JOptionPane.showInputDialog(this, "Debelina roba:", platno.debelinaRoba);
			if (niz != null && niz.matches("\\d*\\.?\\d+")) { // regularni izraz za realno število
				platno.debelinaRoba = Float.parseFloat(niz);
				platno.repaint();
			}
		}
		else if (source == menuPolmer) {
			String niz = JOptionPane.showInputDialog(this, "Debelina povezave:", platno.polmer);
			if (niz != null && niz.matches("\\d*\\.?\\d+")) { // regularni izraz za realno število
				platno.polmer = Double.parseDouble(niz);
				platno.repaint();
			}
		}
		else if (source == menuPolnDvodelen) {
			JTextField prva = new JTextField();
			JTextField druga = new JTextField();
			JComponent[] polja = {
					new JLabel("Velikost prve množice"), prva, //JLabel in JTextField sta podrazreda JComponent
					new JLabel("Velikost druge množice"), druga
			};
			int rez = JOptionPane.showConfirmDialog(this, polja, "Input", JOptionPane.OK_CANCEL_OPTION);
			//Input je nalov dialognega okna, ok cancel option sta dva gumba
			if (rez == JOptionPane.OK_OPTION && prva.getText().matches("\\d+") && druga.getText().matches("\\d+")) {
				int n = Integer.parseInt(prva.getText());
				int m = Integer.parseInt(druga.getText());
				Graf g = Graf.polnDvodelen(n, m);
				g.razporedi(300, 300, 250);
				platno.narisi(g);
			}
		}
		else if (source == NastaviNastavitve) {
			Nastavitve nastavitve = new Nastavitve(this);
			nastavitve.setVisible(true);
		}
	}
	}
}


