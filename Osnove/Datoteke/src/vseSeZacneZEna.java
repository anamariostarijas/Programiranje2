
public class vseSeZacneZEna {

	public static void main(String[] args) {
		String[] t = zaporedje(20);
		for (int i = 0; i < t.length; ++i) System.out.println(t[i]);

	}
	public static String[] zaporedje(int n) { 
		String[] zap = new String[n];
		zap[0] = "1";
		for (int i = 1; i < n; ++i) {
			String p = zap[i-1];
			String t = "";
			int j = 0;
			while (j < p.length()) {
				int k = j;
				while (k < p.length() && p.charAt(k) == p.charAt(j)) ++k;
					t += "" + (k-j) + p.charAt(j); //tu znak pretvori v število in ga prišteje številu, èe ne bi imeli ""
					j = k;
			}
			zap[i] = t;
		}
		return zap;
	}

}
