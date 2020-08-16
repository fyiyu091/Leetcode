package string;

/*
    This is a rabbit -> rabbit a is This
    No trailing or leading space, words delimited by single space
 */
public class ReverseWords {
    public static String reverseWords(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        char[] charArr = str.toCharArray();
        reverse(charArr, 0, str.length() - 1);
        int start = 0, end = 0;
        int len = str.length();
        while (start < len && end < len) {
            while (end < len && charArr[end] != ' ') {
                end++;
            }
            reverse(charArr, start, end - 1);
            start = end;
            while (start < len && charArr[start] == ' ') {
                start++;
            }
            end = start;
        }

        return String.valueOf(charArr);
    }

    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
