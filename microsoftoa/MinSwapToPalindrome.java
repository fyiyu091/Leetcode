package microsoftoa;

public class MinSwapToPalindrome {
    public int minSwap(String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException();
        }

        int left = 0;
        int right = s.length() - 1;
        int swap = 0;

        char[] arr = s.toCharArray();

        if (!checkPalindrome(arr)) {
            return -1;
        }
        while (left < right) {
            if (arr[left] == arr[right]) {
                left++;
                right--;
            }
            else {
                int curr = right;
                while (curr > left && arr[curr] != arr[left]) {
                    curr--;
                }

                // The element at left will be the one at center
                if (curr == left) {
                    swap(arr, left, left + 1);
                    swap++;
                }
                else {
                    while (curr < right) {
                        swap(arr, curr, curr + 1);
                        swap++;
                        curr++;
                    }
                    left++;
                    right--;
                }
            }
        }
        return swap;
    }

    private void swap(char[] arr, int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        return;
    }

    private boolean checkPalindrome(char[] arr) {
        int[] count = new int[26];
        for (char ch : arr) {
            count[ch - 'a']++;
        }
        int oddChar = 0;
        for (int n : count) {
            if (n % 2 != 0) {
                oddChar++;
            }
        }
        return oddChar < 2;
    }

    public static void main(String[] args) {
        MinSwapToPalindrome test = new MinSwapToPalindrome();
        String a = "mamad";
        String b = "asflkj";
        String c = "aabb";
        String d = "aba";
        System.out.println(test.minSwap(a));
        System.out.println(test.minSwap(b));
        System.out.println(test.minSwap(c));
        System.out.println(test.minSwap(d));
    }
}
