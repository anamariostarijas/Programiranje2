import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.io.Serializable;

public class Poteza implements Serializable {
	
	static final long serialVersionUID = 1L;
	private Color barva;
	private int sirina;
	private GeneralPath pot;
	
	public Poteza(Color barva, int sirina, int x, int y) {
		super();
		this.barva = barva;
		this.sirina = sirina;
		this.pot = new GeneralPath();
		pot.moveTo(x, y);
	}
	
	public void dodajTocko(int x, int y) {
		pot.lineTo(x, y);
	}
	
	public void narisi(Graphics2D g) {
		System.out.println("Drawing..." + pot.getCurrentPoint());
		g.setColor(barva);
		g.setStroke(new BasicStroke(sirina, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g.draw(pot);
	}
	
	

}
