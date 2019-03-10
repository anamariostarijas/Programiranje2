package myholders;

import java.util.ArrayList;

public class MyHolder <E>{
	
	ArrayList<E> holder;
	
	public MyHolder () {
		holder = new ArrayList<E> ();
	}
	
	public void put (E val) {
		holder.add(0, val);
	}
	
}
