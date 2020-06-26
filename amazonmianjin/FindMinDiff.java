package amazonmianjin;

/*
Matrix - m rows and n cols;
Every element is uniq;
Integer values(+,-,0);
rows are sorted;
Pick one element from each row such that diff between min and max element chosen is minimum
 */
public class FindMinDiff {
    public int findMinDiff(int[][] matrix) {//rows: num of rows,
        //cc
        int rows = matrix.length;
        int cols = matrix[0].length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < cols; i++) {
            int diff = helper(matrix[0][i], matrix[0][i], 1, matrix);
            minDiff = Math.min(diff, minDiff);
        }

        return minDiff;

    }

    private int helper(int min, int max, int level, int[][] matrix) {
        //base case到达最后一行
        int rows = matrix.length;
        int cols = matrix[0].length;
        //base case
        if (level == rows) return max - min;

        //这行所有数字都在挡板左边
        if (min > matrix[level][cols - 1]) {
            return helper(matrix[level][rows - 1], max, level + 1, matrix);
        }
        //这行所有数字都在挡板右边
        else if (max < matrix[level][0]) {
            return helper(min, matrix[level][0], level + 1, matrix);
        }
        //有在左挡板左也有在右挡板右 - 分叉
        else if (min > matrix[level][0]  && max <matrix[level][cols - 1]){
            //先找出小于min的最大和大于max的最小，然后分叉
            int newMin = findLargestSmaller(min, matrix[level]);
            int newMax = findSmallestBigger(max, matrix[level]);
            return Math.min(helper(min, newMax, level+1, matrix), helper(newMin, max, level+1, matrix));
        }
        //存在有数字在班子中间
        else return helper(min, max, level+1, matrix);

    }

    private int findLargestSmaller(int min, int[] level){
        for(int i = level.length - 1; i>=0; i--){
            if(level[i] < min)
                return level[i];
        }
        throw new RuntimeException("something wrong");
    }

    private int findSmallestBigger(int max, int[] level){
        for(int num: level){
            if(num > max)
                return num;
        }
        throw new RuntimeException("Something wrong");
    }

    public static void main(String[] args)
    {
        int arr[][] = {
                { 4, 7, 9, 12, 15 },
                { 0, 8, 10, 14, 20 },
                { 5, 12, 18, 30, 50 }
        };
        FindMinDiff sol = new FindMinDiff();
        System.out.print(sol.findMinDiff(arr));
    }
}
