package stack;

/* Find the shortest subarray that with sum at least K (K is positive number)
   [2,5,3,-2,7,1], k = 6, looking for the shortest subarray

   p[1] - p[0] -> [0,0]
   p[2] - p[1] -> [1,1]
   p[6] - p[3] -> [3,5]

   [0,2,7,10,8,15,16] this is the prefix sum array -> p[y] - p[x] representing arr subarray sum [x, y - 1]
   Deque only stores the index of prefix sum array
   deque: 0
   deque: 0 1 -> looking for if the new coming prefix - the first element is >= k, it is not
   deque: 0 1 2 -> because 7 - 0 >= 6 -> we pop 0 out and ans = 2 - 0 = 2
          deque becomes 1 2 -> 7 - 2 < 6 -> so we stop poping
   deque: 1 2 3 -> 10 - 2 >= 6 -> we pop 2 out and ans = 3 - 1 = 2
          deque becomes 2 3 -> 10 - 7 < 6 -> so we stop poping
   deque: 2 3 4 (p[4] < p[3] so we need to pop 3 to keep the monolithic) -> 2 4
   deque: 2 4 5 p[5] - p[2] = 8 -> ans = 4 - 2 = 2
                p[5] - p[4] = 7 > 6 -> ans = 5 - 4 = 1 -> 5
   deque: 5 6 keeps the monolithic and p[6] - p[5] < 6

   we can get the subarray sum by subtracting two prefix sum array
   if x1 < x2 and prefix[x1] >= prefix[x2] -> x1 will never be the answer
   because y - x2 < y - x1 && prefix[y] - prefix[x2] >= prefix[y] - prefix[x1]
   so the data structure have to be increasing

   Looking at the first element in the data structure if it works then just keep polling it out,
   because for a specific y, it will be the final answer

* */

import java.util.ArrayDeque;
import java.util.Deque;

public class L862 {
    public int shortestSubarray(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        int len = A.length;
        long[] prefixSum = new long[len + 1];  //prefixSum[i] = sum of A[0] ... A[i - 1]
        for (int i = 0; i < len; i++) {
            prefixSum[i + 1] = prefixSum[i] + (long) A[i];
        }

        Deque<Integer> deque = new ArrayDeque<>(); // stores prefixSum's idx
        for (int i = 0; i < prefixSum.length; i++) {
            while (!deque.isEmpty() && prefixSum[i] < prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= K) {
                int idx = deque.pollFirst();
                res = Math.min(res, i - idx);
            }
            deque.offerLast(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
