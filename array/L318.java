package array;

/* Maximum product of word lengths
   Using int to represent String, each bit of the int
   representing if the String has this letter, doable because 32 > 26
 */
public class L318 {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;

        int len = words.length;
        int[] arr = new int[len];
        int res = 0;

        for (int i = 0; i < len; i++) {
            int n = 0;
            for (int j = 0; j < words[i].length(); j++) {
                n |= (1 << words[i].charAt(j) - 'a');
            }
            arr[i] = n;
        }

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((arr[i] & arr[j]) == 0) {  //Need to add parentheses to be evaluated as bitwise AND
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }

        return res;
    }
}
