import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Platno extends JPanel {
	
	private List<Lik> liki;
	
	public Platno () {
		super();
		this.setPreferredSize(new Dimension(500,500));
		this.setBackground(Color.white);	
		this.liki = new LinkedList<Lik>();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Lik l : this.liki) {
			l.narisiSe(g);
		}
	}
	
	public void addLik(Lik l) {
		liki.add(l);
		this.repaint();
	}


}
