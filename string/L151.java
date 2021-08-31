package string;

/* Reverse words in a String */

public class L151 {
//    public String reverseWords(String s) {
//        if (s == null || s.length() == 0) {
//            return null;
//        }
//
//        // \\s+ match one or more whitespace
//        String[] strs = s.trim().split("\\s+");
//        int left = 0;
//        int right = strs.length - 1;
//        while (left < right) {
//            String tmp = strs[left];
//            strs[left] = strs[right];
//            strs[right] = tmp;
//            left++;
//            right--;
//        }
//        return String.join(" ", strs);
//    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        char[] arr = s.toCharArray();
        int len = s.length();
        // Reverse the entire char array
        reverse(arr, 0, len - 1);

        // Reverse each word
        int i = 0;
        int j = 0;
        while (i < len) {
            // Move the start pointer to the end pointer
            i = j;
            // Find the starting pointer of a word
            while (i < len && arr[i] == ' ') i++;
            // Move the end pointer to the starting pointer
            j = i;
            // Find the end of the word
            while (j < len && arr[j] != ' ') j++;
            reverse(arr, i, j - 1);
        }
        // Trim leading and tailing spaces and leave only one space

        i = 0;
        j = 0;
        while (i < len) {
            // Move i to the beginning of the word
            while (i < len && arr[i] == ' ') i++; // If don't i < len, then the next arr[i] could be index out of array exception
            // Write the word
            while (i < len && arr[i] != ' ') arr[j++] = arr[i++];
            // Skip all the space after the word
            while (i < len && arr[i] == ' ') i++;
            // if we have word following means we would need to add space after pointer j
            if (i < len) arr[j++] = ' '; // If i reaches a valid number or character
        }

        return new String(arr).substring(0, j); // only need to get the partial of the arr because we did remove spaces

    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }
    }

    public static void main(String[] args) {
        L151 l151 = new L151();
        String four = "               yes  nice    ";
        System.out.println(l151.reverseWords(four));
    }
}
