package array;

/*
   Find two non-overlapping sub-arrays and the sum of the lengths of the two is minimum
   All the element in the array is positive number
   3,1,1,1,5,1,2,1 target is 3
   ans wil be 3 from [3] and [2,1]
   prefix sum array to look one ahead
   3,4,5,6,11,12,14,15
   use a map to store <sum, index>
   for any sum in the prefix sum array, whether the map stores sum - target or sum == target
   If we find it, how do we know it is a valid non-overlapping?
 */
public class L1477 {
    public int minSumOfLengths(int[] arr, int target) {
        return 0; // TODO
    }
}
