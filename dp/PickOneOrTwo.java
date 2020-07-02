package dp;

/* Two players, A and B, pick balls from left to right
   One player can pick one or two balls at a time, starting from A, A and B take turns
   Write the function to check whether player A is guarantee to win

   [1,2,100,3] A is not guarantee to win because B can always pick 100
   [10,1,2,100,3] A is guarantee to win, A pick 10, then A can always pick 100

   Search problem, how to branch?
   The current player can either pick one ball or two balls
   Search status? dp[i] means the max balls I can get from [i, len - 1]

   i  i + 1  i + 2  i + 3  i + 4
   Two way for dp[i]
   1. dp[i] = balls[i] + min(dp[i + 1], dp[i + 2])
   2. dp[i] = balls[i] + balls[i + 1] + min(dp[i + 2], dp[i + 3])
   Find the max of this two cases

   [2] -> [2]
   [1,2] -> [3,2]
   [5,1,2] -> [6,3,2]
   [5,1,2,6] -> [11,7,8,6]
 */
public class PickOneOrTwo {
    public static boolean whetherWin(int[] balls) {
        if (balls == null || balls.length == 0) {
            throw new IllegalArgumentException();
        }

        int sum = 0;
        for (int ball : balls) {
            sum += ball;
        }
        int len = balls.length;
        int[] dp = new int[len + 1];
        dp[len - 1] = balls[len - 1];
        dp[len - 2] = balls[len - 1] + balls[len - 2];
        for (int i = len - 3; i >= 0; i--) {
            dp[i] = Math.max((balls[i] + Math.min(dp[i + 2], dp[i + 3])),
                    (balls[i] + balls[i + 1] + Math.min(dp[i + 3], i + 4 < len ? dp[i + 4] : 0)));
        }

        return dp[0] >= sum / 2;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,100,3}; // dp[0] should be 4
        int[] arr2 = new int[] {10,1,2,100,3};
        int[] arr3 = new int[] {5,1,2,6};
        System.out.println(whetherWin(arr1));
        System.out.println(whetherWin(arr2));
        System.out.println(whetherWin(arr3));
    }
}
