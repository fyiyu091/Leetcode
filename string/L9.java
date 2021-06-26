package string;

public class L9 {
    //    public boolean isPalindrome(int x) {
//        if (x < 0) {
//            return false;
//        }
//
//        String str = String.valueOf(x);
//        int i = 0;
//        int j = str.length() - 1;
//        while (i < j) {
//            if (str.charAt(i) != str.charAt(j)) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }

    // 121 > 0 -> res = 1 -> x = 12 -> 12 > 0 -> res = 10 + 2 -> x = 1 -> 1 > 0 -> res = 121 -> x = 0
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int tmp = x;
        int res = 0;
        while (tmp > 0) {
            res = res * 10 + tmp % 10;
            tmp = tmp / 10;
        }

        return res == x;
    }
}
