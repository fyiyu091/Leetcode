package microsoftoa;

/*
    Given a integer, find the largest value by inserting a 5

    N = 269 -> 5268
    N = 670 -> 6750
    N = 0 -> 50
    N = -999 -> -5999
    N = -100 -> -1005

    Solution: Brute force try insert into every position
 */
public class MaximumPossibleValue {
    public static int MaximumPossibleValue(int N) {
        if (N == 0) {
            return 50;
        }

        int sign = 1;
        if (N < 0) {
            sign *= -1;
        }

        //Get how many digits do we have
        int curr = N;
        int digits = 0;
        while (curr > 0) {
            digits++;
            curr /= 10;
        }

        int position = 1;
        int res = Integer.MIN_VALUE;
        int absValue = Math.abs(N);


        for (int i = 0; i <= digits; i++) {
            int newValue = (absValue / position) * (position * 10) + (position * 5) + (absValue % position);
            res = Math.max(newValue * sign, res);
            position *= 10;
        }

        return res;
    }

    public static void main(String[] string) {
        System.out.println(MaximumPossibleValue(5)); //55
        System.out.println(MaximumPossibleValue(0)); //50
        System.out.println(MaximumPossibleValue(269)); //5269
        System.out.println(MaximumPossibleValue(-100)); //-1005
        System.out.println(MaximumPossibleValue(670)); // 6750
        System.out.println(MaximumPossibleValue(888)); // 8885
    }
}
