import java.util.*;
public class Naloga2 {

	public static void main(String[] args) {
		Map <String, Map <String, Integer>> skatla1 = new HashMap<String, Map <String, Integer>>();
		Map<String, Integer> barve1 = new HashMap<String, Integer>();
		barve1.put("modra", 1);
		barve1.put("rdeèa", 2);
		Map<String, Integer> barve2 = new HashMap<String, Integer>();
		barve2.put("rdeèa", 3);
		skatla1.put("4x1", barve1);
		skatla1.put("2x2", barve2);
		Map <String, Map <String, Integer>> skatla2 = new HashMap<String, Map <String, Integer>>();
		Map<String, Integer> barve3 = new HashMap<String, Integer>();
		barve3.put("modra", 1);
		skatla2.put("4x1", barve3);
		Map<String, Integer> barve4 = new HashMap<String, Integer>();
		barve4.put("zelena", 1);
		skatla2.put("2x2", barve4);
		lego(skatla1, skatla2);
		System.out.println(skatla1);
		
		
		
		
		

	}
	
	public static void lego(Map<String, Map<String, Integer>> skatla1, Map<String, Map<String, Integer>> skatla2) {
			for (String tip2 : skatla2.keySet()) {
				Map<String, Integer> kaksni2 = skatla2.get(tip2);
				if (skatla1.containsKey(tip2)) {
					Map<String, Integer> kaksni1 = skatla1.get(tip2);
					for (String barva : kaksni2.keySet()) {
						if (kaksni1.containsKey(barva)) {
							kaksni1.put(barva, kaksni1.get(barva)+kaksni2.get(barva));
							skatla1.put(tip2, kaksni1);
						}
						else {
							kaksni1.put(barva, kaksni2.get(barva));
						}	
					}
				}
				else {
					skatla1.put(tip2, kaksni2);
				}
			}
		}

}
