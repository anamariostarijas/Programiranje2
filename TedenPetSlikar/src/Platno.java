import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Platno extends JPanel implements MouseListener, MouseMotionListener {
	// private Dimension zelenaVelikost;
	private Okno okno;
	private List<Poteza> poteze;
	private Poteza aktivnaPoteza;
	
	public Platno(Okno okno, int sirina, int visina) {
		super();
		this.okno = okno;
		// this.zelenaVelikost = new Dimension(sirina, visina);
		this.setPreferredSize(new Dimension(500,500));
		this.setBackground(Color.white);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.poteze = new LinkedList<Poteza>();

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
	
	public void zbrisiVse () {
		poteze = new LinkedList<Poteza>();
		repaint();
	}


	//@Override
	//public Dimension getPreferredSize() {
	//	return this.zelenaVelikost;
	//}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked");
	 }

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse pressed");
		aktivnaPoteza = new Poteza(okno.trenutnaBarva, okno.getTrenutnaSirina(), e.getX(), e.getY());
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

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse entered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("Mouse exited");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Mouse dragged: " + e.getX() + ", " + e.getY());
		aktivnaPoteza.dodajTocko(e.getX(), e.getY());
		this.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("Mouse moved: " + e.getX() + ", " + e.getY());
	}
	
	
}