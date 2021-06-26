package iterator;

import java.util.Iterator;
import java.util.List;

/* [1,2,2,3,3,4,5,6] -> 1,2,3,4,5,6
   the dedupIterator needs to remove the duplicate and just output
   the distinct values
   might have element is null case

   Solution: Use a next variable to store the next non repeating value
 */
public class DedupIterator<T> implements Iterator<T> {
    private Iterator<T> iter;
    private T next;

    DedupIterator(List<T> list) {
        // Get the iterator of the list
        iter = list.iterator();
        next = null;
    }

    @Override
    public T next() {
        // Need to make sure that only output the deduped data
        T curr = null;
        if (next != null) {
            curr = next;
            next = null;
        }
        else {
            curr = this.iter.next();
        }

        while (iter.hasNext()) {
            T val = iter.next();
            // Find the next that is not equal to curr and saves it to next
            if (!val.equals(curr)) {
                next = val;
                break;
            }
        }

        return curr;
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext() || next != null;
    }
}
