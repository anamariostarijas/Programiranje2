import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

@SuppressWarnings("serial")
public class Platno extends JPanel {
	
	Integer sirina;
	Integer visina;
	Graf graf;
	
	Color barvaPovezave;
	Color barvaTocke;
	Color barvaRoba;
	double polmer;
	float debelinaPovezave;
	float debelinaRoba;
	
	public Platno(int sirina, int visina) {
		graf = null;
		this.visina = visina;
		this.sirina = sirina;
		barvaPovezave = Color.BLUE;
		barvaTocke = Color.RED;
		barvaRoba = Color.BLACK;
		polmer = 20;
		debelinaPovezave = 2.5f;  //float
		debelinaRoba = 3;
		//Color c = new Color(50, 1, 50)
	}
	
	public void narisi(Graf g) {
		//nastavi nov graf za risanje
		graf = g; 
		repaint(); //od sistema izve, kaj je Graphics g in poklice paintComponent()
	}
	
	@Override  //preveri, ce smo vse napisali kar je zahtevano v nadrazredu
	public Dimension getPreferredSize() {
		return new Dimension(sirina, visina);
		//vsako od komponent vprasa, kako veliko naj bo platno
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		//glavna metoda, ki je namenjena risanju
		//poklice se vsakic, ko obnovimo okno
		//sami jo poklicemo, ce zelimo graf spremeniti
		super.paintComponent(g); 
		setBackground(Color.white); //this.setBackground
		Graphics2D g2 = (Graphics2D)g;
		if (g == null) return;
		g.setColor(barvaPovezave);
		g.setColor(barvaTocke);
		g2.setStroke(new BasicStroke(debelinaPovezave));
		for (Tocka v : graf.tocke.values()) {
			for (Tocka u : v.sosedi)
				if (v.ime.compareTo(u.ime) > 0) {//poz, ce prvi vecji od drugega, neg sicer
					//tako se izognemo dvakratnemu risanju povezav
					g.drawLine(round(v.x), round(v.y), round(u.x), round(u.y));
				}
		}
		
		int premer = round(2*polmer);
		for (Tocka v : graf.tocke.values()) {
			g.setColor(barvaTocke);
			g.fillOval(round(v.x-polmer), round(v.y-polmer), premer, premer);
			g.setColor(barvaRoba);
			g.drawOval(round(v.x-polmer), round(v.y-polmer), premer, premer);
		}
		
	}
	
	private static int round(double s) {
		return (int)(s + 0.5);
	}

}
