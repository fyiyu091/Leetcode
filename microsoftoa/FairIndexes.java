package microsoftoa;

public class FairIndexes {
    private int getNumOfFairIndexes(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            throw new IllegalArgumentException();
        }

        int res = 0;
        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
            sumB += B[i];
        }

        if (sumA != sumB || sumA % 2 != 0) {
            return 0;
        }

        int sumASoFar = 0;
        int sumBSoFar = 0;
        for (int i = 0; i < A.length - 1; i++) {
            sumASoFar += A[i];
            sumBSoFar += B[i];
            if (sumASoFar * 2 == sumA && sumASoFar == sumBSoFar) {
                res++;
            }
        }

        return res;
    }
}
