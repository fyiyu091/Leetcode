package slidingwindow;

/* Gas station */
/* If the gas sum is less than the cost sum, then we cannot do a circle */
/* If during the iteration, the curr gas is smaller than the cost, need to start at i + 1 */

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
