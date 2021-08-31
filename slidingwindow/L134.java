package slidingwindow;

/* Gas station */
/* If the gas sum is less than the cost sum, then we cannot do a circle */
/* If during the iteration, the curr gas is smaller than the cost, need to start at i + 1

   i here is gas - cost
   Saying we have i, i + 1, ... j all sum becomes negative the first time
   Then it is not possible to have a k in range [i + 1, j] because from [i, k] must be positive
   Otherwise it would be stopped
 */

public class L134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return 0;
        }

        int start = 0;
        int total = 0;
        int curr = 0;

        for (int i = 0; i < gas.length; i++) {
            curr += gas[i] - cost[i];

            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }

            total += gas[i] - cost[i];
        }

        return total < 0 ? -1 : start;
    }
}
