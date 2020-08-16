package graph;

/*
   Find the celebrity
   boolean knows(int a, int b) is defined and output is whether a knows b
   We can O(n) rule out n - 1 absolutely no chance to be celebrity options
 */
public class L277 {
    public int findCelebrity(int n) {
        if (n < 0) {
            return 0;
        }

        int potentialCelebrity = 0;
        for (int i = 1; i < n; i++) {
            if (knows(potentialCelebrity, i)) {
                potentialCelebrity = i;
            }
        }

        // Check the potentialCelebrity if can be real celebrity
        for (int i = 0; i < n; i++) {
            if (i == potentialCelebrity) {
                continue;
            }
            if (!knows(i, potentialCelebrity) || knows(potentialCelebrity, i)) {
                return -1;
            }
        }

        return potentialCelebrity;
    }

    private boolean knows (int i, int j) {
        return true;
    }
}
