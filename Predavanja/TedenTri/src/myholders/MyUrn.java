package myholders;
import java.util.Random;
import java.util.ArrayList;


public class MyUrn <E> extends MyHolder<E> {
	//removed element is randomly selected
	
	private Random randoms = new Random();
	
	public E take () {
		int size = holder.size();
		int index = randoms.nextInt(size);
		E val = holder.get(index);
		holder.remove(index);
		return val;
	}

}
