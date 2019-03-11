import java.awt.Color;
import java.awt.Graphics;

public class Kvadrat extends Lik {

	private int stranica;
	
	public Kvadrat(int x, int y, Color barva, int stranica) {
		super(x, y, barva);
		this.stranica = stranica;
	}

	public void narisiSe(Graphics g) {
		g.setColor(this.barva);
		g.fillRect(x, y, this.stranica, this.stranica);

	}

	public double ploscina() {
		return this.stranica * this.stranica;
	}
}
