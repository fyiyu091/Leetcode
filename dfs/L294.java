package dfs;

public class L294 {
    public boolean canWin(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        char[] arr = s.toCharArray();
        return dfs(arr);
    }

    private boolean dfs(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '+' && arr[i + 1] == '+') {
                arr[i] = '-';
                arr[i + 1] = '-';
                boolean res = dfs(arr);
                arr[i] = '+';
                arr[i + 1] = '+';
                if (!res) {
                    return true;
                }
            }
        }
        return false;
    }
}
