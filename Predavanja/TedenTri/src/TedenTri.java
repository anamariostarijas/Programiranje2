import myholders.*;

public class TedenTri {

	public static void main(String[] args) {
		MyUrn<String> h = new MyUrn<String>();
		
		h.put("dva");
		h.put("tri");
		h.put("pet");
						
		System.out.println (h.take());
		System.out.println (h.take());
		
		h.put("sedem");
		
		System.out.println (h.take());
		System.out.println (h.take());
		

	}

}
