package greedy;

public class L1578 {
    public int minCost(String s, int[] cost) {
        if (s == null || s.length() == 0 || cost == null || cost.length == 0) {
            return 0;
        }

        int res = 0;
        int len = s.length();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if ( i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                res += sum - max;
                sum = 0;
                max = 0;
            }
            sum += cost[i];
            max = Math.max(max, cost[i]);
        }

        res += sum - max;
        return res;
    }
}
