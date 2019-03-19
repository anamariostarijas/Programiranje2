import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Platno extends JPanel implements MouseListener, MouseMotionListener {
	
	private List<Poteza> poteze;
	private Poteza aktivnaPoteza;
	
	public Platno(int sirina, int visina) {
		super();
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(sirina, visina));
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

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Mouse clicked");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse entered");
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		System.out.println("Mouse exited");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse pressed");
		aktivnaPoteza = new Poteza(Color.black, 5, e.getX(), e.getY());
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
