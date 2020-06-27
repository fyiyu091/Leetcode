package binaryreduction;

/* H-index II
   the citations is sorted in ascending order
   the problem becomes find the left most that citations[i] >= i
   answer will be len - the index of the left most
   need to be square
   0 1 3 5 6
   l
           r
       m

   when exit the loop
   c[r] < len - r    c[l] > len - l
   r                       l
   Need to form a square, so we will have to take l
 */
public class L275 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int len = citations.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == len - mid) {
                return len - mid;
            }
            if (citations[mid] < len - mid) { // because mid decrease, len - mid increase, so the left part is not possible
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return len - left;
    }
}
