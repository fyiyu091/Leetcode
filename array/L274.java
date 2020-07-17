package array;

/* H-index
   The possible answer can only be 0, 1, ... length of citations
   count how many citations is larger or equals to the possible answer
   1,3,2,3,5

     1 1 2   1
   0 1 2 3 4 5
   This array means the count of each specific citation
   What we are looking for is the maximum index that have >= index citations
 */
public class L274 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int len = citations.length;
        int[] count = new int[len + 1]; // 0, 1, ... len
        for (int c : citations) { // Convert to how many paper with that specific citations
            count[Math.min(c, len)]++;
        }

        int sum = 0;
        for (int i = len; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) { // The first time seeing sum >= i means that we have that many paper with i amount of citations
                return i;
            }
        }

        throw new IllegalStateException();
    }
}
