import java.awt.Color;

public class Slika {

	public static void main(String[] args) {
		// Nariše sliko
		
		OknoZaSliko okno1 = new OknoZaSliko ();
		okno1.pack();
		okno1.setVisible(true);		
		
		for (int i = 0; i < 48; i++) {
			double theta = Math.PI * i / 9;
			int x = (int) Math.round(250 + (200 * Math.cos(theta) * (480 - 10*i) / 480));
			int y = (int) Math.round(250 + (200 * Math.sin(theta) * (480 - 10*i) / 480));
			int r = 0, g = 0 ,b = 0;
			if (i < 8) {r = 255; g = 32 * i ; b = 0;}
			else if (i < 16) {r = 255 - 32 * (i - 8); g = 255 ; b = 0;}
			//else if (i < 24) {r = 0; g = 255; b = 32 * (i - 16);}
			//else if (i < 32) {r = 0; g = 255 - 32 * (i - 24); b = 255;}
			//else if (i < 40) {r = 32 * (i - 32); g = 0 ; b = 255;}
			//else if (i < 48) {r = 255 ; g = 0 ; b = 255 - 32 * (i - 40);}
			Lik k;
			if (i%2 == 0) {k = new Kvadrat(x - 24 + i/2, y - 24 + i/2, new Color(r, g, b), 48 - i);} //sodi so kvadrati
			//else continue;
			else {k = new Krog (x, y, new Color(r, g, b), 24 - i/2);}
			okno1.addLik(k);
		}

	}

}
