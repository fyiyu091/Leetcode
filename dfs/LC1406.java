package dfs;

/*
    [1,2,3,7]
    Player can take 1, 2 or 3 stones from the first remaining stones
    So the player can pick 1, 1,2 or 1,2,3

    Initially, I thought we had to use two sums to keep track of both BOB and ALICE's score
    but later realized that we could just subtract the other player's gain to current player
 */
public class LC1406 {
    public String stoneGameIII(int[] stoneValue) {
        int res = dfs(stoneValue, 0);
        if (res > 0) {
            return "Alice";
        }
        if (res < 0) {
            return "Bob";
        }
        return "Tie";
    }

    /*
        Search state: stating at current idx
        Return value: what's the maximum stones I can get
     */
    private int dfs(int[] stoneValue, int idx) {
        if (idx >= stoneValue.length) {
            return 0;
        }

        int sum = stoneValue[idx] - dfs(stoneValue, idx + 1);
        if (idx + 1 < stoneValue.length) {
            sum = Math.max(sum, stoneValue[idx] + stoneValue[idx + 1] - dfs(stoneValue, idx + 2));
        }
        if (idx + 2 < stoneValue.length) {
            sum = Math.max(sum, stoneValue[idx] + stoneValue[idx + 1] + stoneValue[idx + 2] - dfs(stoneValue, idx + 3));
        }
        return sum;
    }
}
