package string;

import java.util.Arrays;

/*
   Find the next closest time by reusing the current digits
   19:34 -> 19:39

   scan find the next larger than it and replace the lowest digit
   Firstly, sort the digits
   1 3 4 9
   Try from right to left to find the smallest that is larger than current and within the range
   If no such element exist, just using the smallest to replace the current char
 */
public class L681 {
    public String nextClosestTime(String time) {
        if (time == null || time.length() == 0) {
            return "";
        }

        char[] arr = time.toCharArray();
        char[] digits = new char[] {arr[0], arr[1], arr[3], arr[4]};
        Arrays.sort(digits);

        // Try HH:M_
        arr[4] = findNext(arr[4], '9', digits);
        if (arr[4] > time.charAt(4)) return String.valueOf(arr);

        // Try HH:_M
        arr[3] = findNext(arr[3], '5', digits);
        if (arr[3] > time.charAt(3)) return String.valueOf(arr);

        // Try H_:MM, if arr[0] is 2, arr[1] can only be 0,1,2,3,4
        arr[1] = arr[0] == '2' ? findNext(arr[1], '4', digits) : findNext(arr[1], '9', digits);
        if (arr[1] > time.charAt(1)) return String.valueOf(arr);

        // Try _H:MM
        arr[0] = findNext(arr[0], '2', digits);
        return String.valueOf(arr);
    }

    private char findNext(char curr, char upperLimit, char[] digits) {
        if (curr == upperLimit) {
            return digits[0];
        }

        int targetIdx = 0;
        while (targetIdx < digits.length) {
            if (digits[targetIdx] > curr) {
                break;
            }
            targetIdx++;
        }
        if (targetIdx == digits.length || digits[targetIdx] > upperLimit) {
            return digits[0];
        }
        return digits[targetIdx];
    }
}
