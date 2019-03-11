import java.awt.Color;
import java.awt.Graphics;

public abstract class Lik {
	//abstract: metodi narisiSe inploscina sta odvisni od posameznega lika 
	protected int x; // protected: do tega lahko dostopa ta razred in podrazredi
	protected int y;
	Color barva;
	
	public Lik(int x, int y, Color barva) {
		this.x = x;
		this.y = y;
		this.barva = barva;
	}

	public void premakni(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	public abstract double ploscina();
	
	public abstract void narisiSe(Graphics g);

}
