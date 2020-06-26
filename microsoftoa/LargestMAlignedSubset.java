package microsoftoa;

public class LargestMAlignedSubset {
    public static int getLargestMAlignedSubset(int[] array, int M) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int res = 0;
        /*
          aggregate numbers by the reminder divided by M
          if two numbers have the same reminder when divided by M
          then they distance is divisible by M
        */
        int[] subsetSize = new int[M];
        for (int n : array) {
            // Calculate the reminder, need to convert negative to non-negative
            int reminder = n < 0 ? ((n % M) + M) % M : n % M;
            res = Math.max(++subsetSize[reminder], res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-3,-2,1,0,8,7,1};
        System.out.println(getLargestMAlignedSubset(a, 3));
    }
}
