
public class Naloga1 {

	public static void main(String[] args) {
		String niz ="00110010011101101010101011110000";
		System.out.println("rezultat: ");
		int[] rez = stevila(niz);
		for (int i=0; i<niz.length()/8; ++i) System.out.print(rez[i] + " ");

	}
	
	public static int[] stevila(String niz) {
		int n = niz.length()/8;
		int[] tab = new int[n];
		for (int j = 0; j < n; ++j) {
			int stevilo = 0;
			int k = 7;
			for (int i=0; i<8; ++i) {
				String znak = ""+niz.charAt(i+j*8);
				stevilo += (Integer.valueOf(znak))*Math.pow(2, k);
				k -= 1;
			}
			tab[j] = stevilo;
		}
		return tab;
	}

}
