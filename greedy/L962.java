package greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
   Maximum width ramp
   a ramp is a tuple (i, j) for which i < j and A[i] <= A[j], the width of such a ramp is j - i
   Find the maximum width of a ramp in A

   6,0,8,2,1,5
   0 1 2 3 4 5

   // Sort the index array based on the array value
   1 4 3 5 0 2
   0 1 2 3 4 5
 */
public class L962 {
    public int maxWidthRamp(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int len = A.length;
        Integer[] indexArr = new Integer[len];
        for (int i = 0; i < indexArr.length; i++) {
            indexArr[i] = i;
        }

        Comparator comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return A[o1] - A[o2];
            }
        };
        Arrays.sort(indexArr, comp);

        int res = 0;
        int min = len;
        // has nothing to do with the index
        for (int index : indexArr) {
            res = Math.max(res, index - min);
            min = Math.min(min, index);
        }

        return res;
    }
}
