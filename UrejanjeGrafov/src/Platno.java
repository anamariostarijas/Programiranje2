import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

@SuppressWarnings("serial")
public class Platno extends JPanel implements MouseMotionListener, MouseListener, KeyListener {
	
	Integer sirina;
	Integer visina;
	Graf graf;
	
	Color barvaPovezave;
	Color barvaTocke;
	Color barvaRoba;
	double polmer;
	float debelinaPovezave;
	float debelinaRoba;
	Color barvaAktivneTocke;
	Color barvaIzbraneTocke;
	
	Tocka aktivnaTocka;
	Set<Tocka> izbraneTocke;
	
	private int klikX, klikY; //kje smo kliknili
	private int premikX, premikY;
	
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
		
		addMouseListener(this); //na platno dodamo listener
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true); //lahko prejema fokus, da lahko prejme dogodke v tipkah
		
		aktivnaTocka = null;
		izbraneTocke = new HashSet<Tocka>(); //set je ime vmesnika, HashSet je ime razreda, ki implementira Set
		
		barvaAktivneTocke = Color.MAGENTA;
		barvaIzbraneTocke = Color.YELLOW;
		
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
		
		//dobimo vse kostruktorje iz paintComponent superclassa
		super.paintComponent(g); 
		
		//nastavimo barvo ozadja platna
		setBackground(Color.white); //this.setBackground
		Graphics2D g2 = (Graphics2D)g;
		
		//èe nimamo grafa, naj se ne zgodi niè
		if (g == null) return;
		
		//povezave in toèke grafa
		g.setColor(barvaPovezave);
		g.setColor(barvaTocke);
		g2.setStroke(new BasicStroke(debelinaPovezave));
		
		//narišemo povezave med toèkami in njihovimi sosedi
		for (Tocka v : graf.tocke.values()) {
			for (Tocka u : v.sosedi)
				if (v.ime.compareTo(u.ime) > 0) {//poz, ce prvi vecji od drugega, neg sicer
					//tako se izognemo dvakratnemu risanju povezav
					g.drawLine(round(v.x), round(v.y), round(u.x), round(u.y));
				}
		}
		
		int premer = round(2*polmer);
		
		for (Tocka v : graf.tocke.values()) {
			//nastavimo posebne barve za aktivne tocke in izbrane tocke
			if (v == aktivnaTocka) g.setColor(barvaAktivneTocke);
			else if (izbraneTocke.contains(v)) g.setColor(barvaIzbraneTocke);
			else g.setColor(barvaTocke);
			//risanje toèk
			g.fillOval(round(v.x-polmer), round(v.y-polmer), premer, premer);
			g.setColor(barvaRoba);
			g.drawOval(round(v.x-polmer), round(v.y-polmer), premer, premer);
			
		}
		
	}
	
	private static int round(double s) {
		//dodatna metoda za zaokroževanje
		return (int)(s + 0.5);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (graf == null) return;
		char tipka = e.getKeyChar(); //dobimo èrko, katere tipko smo pritisnili
		if (tipka == 'a') izbraneTocke.addAll(graf.tocke.values());
		if (tipka == 's') izbraneTocke.clear();
		if (tipka == 'c') {
			for (Tocka v : izbraneTocke) graf.odstraniTocko(v);
			izbraneTocke.clear();
		}
		if (tipka == 'd') {
			for (Tocka v : izbraneTocke) {
				for (Tocka u : izbraneTocke) {
					graf.odstraniPovezavo(u, v);
				}
			}
		}
		if (tipka == 'e') {
			for (Tocka v : izbraneTocke) {
				for (Tocka u : izbraneTocke) {
					graf.dodajPovezavo(u, v);
				}
			}
		}
		repaint();	
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		if (graf == null) return;
		
		if (aktivnaTocka != null) {
			//ce imamo aktivno tocko, se ta premika skupaj z misko, od zadnje koordinate naprej
			aktivnaTocka.x += e.getX() - premikX;
			aktivnaTocka.y += e.getY() - premikY;
		}
		else {
			//ce nimamo aktivne tocke, se morajo vse izbrane tocke premikati skupaj z misko
			for (Tocka v : izbraneTocke) {
				v.x += e.getX() - premikX;
				v.y += e.getY() - premikY;
			}
		}
		premikX = e.getX();
		premikY = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	

	@Override
	public void mousePressed(MouseEvent e) {
		
		if (graf == null) return;
		
		klikX = premikX = e.getX();
		klikY = premikY = e.getY();
		
		Tocka najblizja = null;
		double razdalja = Double.POSITIVE_INFINITY;
		
		for (Tocka v: graf.tocke.values()) {
			double r = Math.sqrt(Math.pow(klikX - v.x, 2) + Math.pow(klikY - v.y, 2));
			if (r < razdalja) {
				//ce kliknemo na tocko, ta postane aktivna (drugace obarvana)
				razdalja = r;
				najblizja = v;
			}
		}
		if (razdalja < polmer + 5) {
			//ce ne kliknemo direktno na tocko, postane aktivna najblizja
			aktivnaTocka = najblizja;
			repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if (graf == null) return;
		
		if (e.getX() == klikX && e.getY() == klikY) {
			//med pritiskom in spustom se miska ne premakne
			if (aktivnaTocka == null) {
				//ce ni aktivne tocke, doda novo in jo poveze z vsemi izbranimi
				Tocka v = graf.dodajTocko();
				v.x = e.getX();
				v.y = e.getY();
				for (Tocka u : izbraneTocke) graf.dodajPovezavo(v, u);
			}
			
			else { //imamo aktivno tocko
				//tocka, ki je bila oznacena, po spustu miske ni vec oznacena
				if (izbraneTocke.contains(aktivnaTocka)) izbraneTocke.remove(aktivnaTocka); 
				//ce tocka prej ni bila oznacena sedaj je
				else izbraneTocke.add(aktivnaTocka);
				
			}	
		}
		aktivnaTocka = null;
		repaint();
	}

}
