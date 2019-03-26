import java.util.LinkedList;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Platno extends JPanel implements MouseListener, MouseMotionListener {
	
	private List<Poteza> poteze;
	private Poteza aktivnaPoteza;
	private Color aktivnaBarva;
	private int aktivnaSirina;
	
	public Platno(int sirina, int visina) {
		super();
		this.setPreferredSize(new Dimension(sirina, visina));
		this.setBackground(Color.white);
		aktivnaBarva = Color.black;
		aktivnaSirina = 11;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.poteze = new LinkedList<Poteza>();
		
	}
	
	public List<Poteza> getPoteze () {
		return poteze;
	}
	
	public void setPoteze (List<Poteza> poteze) {
		this.poteze = poteze;
		repaint();
	}
	
	public void setBarva (Color barva) {
		this.aktivnaBarva = barva;
	}
	
	public Color getBarva() {
		return aktivnaBarva;
	}
	
	public void setSirina (int sirina) {
		this.aktivnaSirina = sirina;
	}
	
	public void zbrisiVse () {
		poteze = new LinkedList<Poteza>();
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for (Poteza p : poteze) {
			p.narisi(g2);
		}
		if (aktivnaPoteza != null) {
			aktivnaPoteza.narisi(g2);
		}
	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Mouse dragged");
		aktivnaPoteza.dodajTocko(e.getX(), e.getY());
		this.repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Mouse moved: " + e.getX() + ", " + e.getY());
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked");
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		System.out.println("Mouse entered");
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		System.out.println("Mouse exited");		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse pressed");
		aktivnaPoteza = new Poteza(aktivnaBarva, aktivnaSirina, e.getX(), e.getY());
		this.repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse released");
		aktivnaPoteza.dodajTocko(e.getX(), e.getY());
		poteze.add(aktivnaPoteza);
		aktivnaPoteza = null;
		this.repaint();
		
	}
	

}
