import java.util.Iterator;


public class Q284_Peeking_Iterator {
	class PeekingIterator implements Iterator<Integer> {
		private Iterator<Integer> iter;
		private int next;

		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
			iter = iterator;
			if(iter.hasNext()){
				next = iter.next();
			} else {
				next = (Integer) null;
			}
		}

	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
	        return next;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
		    int ans = next;
		    next = (iter.hasNext()) ? iter.next() : null;
		    return ans;
		}

		@Override
		public boolean hasNext() {
			return next != (Integer) null;
		}
	}
}
