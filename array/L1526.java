package array;

/*
    Picture a brick wall

    3 1 5 4 2

        |
        | |
    |   | |
    |   | | |
    | | | | |

    Since we only increment a subarray by 1 everytime
    It becomes how many bricks are facing its left and not covered
 */
public class L1526 {
    public int minNumberOperations(int[] target) {
        int res = target[0];
        for (int i = 1; i < target.length; i++) {
            res += Math.max(target[i] - target[i - 1], 0);
        }

        return res;
    }
}
