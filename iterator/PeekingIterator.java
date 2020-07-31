package iterator;

import java.util.Iterator;

/*
    Once peek, advance the iterator
 */

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> it;
    private Integer peek;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.it = iterator;
        this.peek = null;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peek == null) {
            if (it.hasNext()) {
                peek = it.next();
            }
            else {
                throw new IllegalStateException();
            }
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer res = null;
        if (peek != null) {
            res = peek;
        }
        else {
            res = it.next();
        }
        peek = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return peek != null || it.hasNext();
    }
}
