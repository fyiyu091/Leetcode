package array;

import java.util.HashSet;
import java.util.Set;

/*
   Find the num of pairs that have the same diff k
   1, 1, 4, 4   k = 3
   (1, 4) return 1
 */
public class NumOfPairSameDiff {
    public static int numOfPairSameDiff(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int n : arr) {
            if (!set.add(n)) {
                continue;
            }
            if (set.contains(n + k)) {
                res++;
            }
            if (set.contains(n - k)) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7};
        System.out.println(numOfPairSameDiff(arr, 1));
    }
}
