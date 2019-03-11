import java.awt.Color;
import java.awt.Graphics;


public class Krog extends Lik{
	
		private int polmer;
		
		public Krog(int x, int y, Color barva, int polmer) {
			super(x, y, barva);
			this.polmer = polmer;
		}

		public void narisiSe(Graphics g) {
			g.setColor(this.barva);
			g.fillOval(x - polmer, y - polmer, 2 * polmer, 2 * polmer);

		}

		public double ploscina() {
			return Math.PI * polmer * polmer;
		}

	


}
