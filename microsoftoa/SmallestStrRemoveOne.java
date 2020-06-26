package microsoftoa;

import java.util.Stack;

public class SmallestStrRemoveOne {
    public static String smallestStr(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        // Using stack from left to right, if curr smaller than prev, remove prev
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count == 0 && sb.length() != 0 &&s.charAt(i) < sb.charAt(sb.length() - 1)) {
                count++;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(s.charAt(i));
        }

        return count == 0 ? sb.substring(0, sb.length() - 1) : sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "abcdfeee";
        System.out.println(smallestStr(s1));
        String s2 = "abzcdefg";
        System.out.println(smallestStr(s2));
    }
}
