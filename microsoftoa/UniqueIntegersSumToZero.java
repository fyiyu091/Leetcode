package microsoftoa;

public class UniqueIntegersSumToZero {
    public int[] sumZero(int n) {
        int[] res = new int[n];

        int idx = 0;
        int maxVal = n / 2;
        while (maxVal > 0) {
            res[idx] = maxVal;
            res[n - idx - 1] = -maxVal;
            idx++;
            maxVal--;
        }

        return res;
    }
}
