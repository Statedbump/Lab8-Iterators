package llPositionalList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import interfaces.PositionalList;
import interfaces.Position;


public class PositionalListElementIteratorBackwards<E> implements Iterator<E> {

	private Position<E> current; 
	private PositionalList<E> theList; 
	
	public PositionalListElementIteratorBackwards(PositionalList<E> list) { 
		theList = list; 
		try { 
			current = theList.last(); 
		}
	    catch (IllegalStateException e) { 
	    	current = null; 
	    }
	}
	public boolean hasNext() {
		return current != null;
	}
	public E next() throws NoSuchElementException {
		if (!hasNext()) 
			throw new NoSuchElementException("Iterator has past the end.");
		Position<E> ptr = current; 
		try { 
			current = theList.before(current); 
		}
		catch (Exception e) { 
			current = null; 
		}
		return ptr.getElement();
	}
	
}