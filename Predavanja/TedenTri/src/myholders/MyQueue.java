package myholders;

public class MyQueue<E> extends MyHolder<E> {
	//FIFO holder
	
	public E take () {
		int size = holder.size();
			E val = holder.get(size-1);
			holder.remove(size-1);
			return val;
	}

}
