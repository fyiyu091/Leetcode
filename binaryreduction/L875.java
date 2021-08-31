package binaryreduction;

/*
    The binary reduction condition is that can KoKo finishes or not
    What's the maximum speed for KoKo, the maximum pile in the piles
    What's the minimum speed for KoKo, 1

    0 0 0 0 1 1 1 1 1
    0 1 2 3 4 5 6 7 8
            l
          h
    Need to find the very first 1 above
 */
public class L875 {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canFinish(piles, mid, h)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / speed;
            if (pile % speed != 0) {
                hours++;
            }
        }

        return hours <= h;
    }

    private int findMax(int[] piles) {
        int res = 0;
        for (int pile : piles) {
            res = Math.max(res, pile);
        }

        return res;
    }
}
