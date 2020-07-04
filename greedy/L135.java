package greedy;

import java.util.Arrays;

/* Candy
   Each child must have at least one candy
   Children with a higher rating get more candies than their neighbors

   1 2 2
   1 2 1

   1 23 2 1 12 36
   1 1  1 1 1  1
   1 3  2 1 2  3

   Why simple from left to right is not enough?

   1 3 2 2 1
   1 2 1 2 1

   1 3 4 5 2
   1 2 3 4 1
 */
public class L135 {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }

        int len = ratings.length;
        int[] candy = new int[len];
        Arrays.fill(candy, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        // candy can only increase
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
            }
        }

        int res = 0;
        for (int num : candy) {
            res += num;
        }

        return res;
    }
}
