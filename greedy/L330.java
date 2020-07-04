package greedy;

/* Patching array
   Given a sorted positive integer nums and an integer n, add elements to the array
   such that any number in range [1, n] can be formed by the sum of some elements in the array
   Return the minimum number of patches required

   If the array is continuous, like 1 2 3, it can cover 1, 2, 3, 4, 5, 6
   why? 1 2 3
   4 can be covered by 1 + 3, 5 can be covered by 2 + 3, 6 can be covered by 1 + 2 + 3
   1 2 3 4 5 -> 15
   6 -> 1 + 5  7 -> 2 + 5   8 -> 3 + 5   9 -> 4 + 5   10 -> 1 4 5  11 -> 2 4 5  12 -> 3 4 5
   13 -> 1 3 4 5   14 -> 2 3 4 5   15 -> 1 2 3 4 5

   1 2 4, it can cover 1 2 3 4 5 6
   1. To cover all [1,n], we just need fewer than n numbers of element
   Assume the current missing number is miss, so [1, miss) is covered
   Because if we want to cover miss number, we will have to add a number that is <= miss
   After adding it, we will cover [1, miss) and [x, x + miss) -> [1, x + miss)
   We want this range to be maximum as much as possible, so we add miss == x
   Because the array is sorted, we can do one pass

   1 2 4 13 43  n = 100
          1     2       4         13     13  ...  43
   miss   2     4       8         16     29
   res    0     0       0         1      1
   insert                         8
 */
public class L330 {
    public int minPatches(int[] nums, int n) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }

        long miss = 1;
        int res = 0, i = 0;
        while (miss <= n) { // now just loop # of nums times
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            }
            else {
                miss += miss; // After we adding the missing number we don't increment i yet, because the range will be incremented later
                res++;
            }
        }

        return res;
    }
}
