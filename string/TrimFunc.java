package string;

public class TrimFunc {
    /*
       __a__b_c_ -> a_b_c_
     */
    public static String trimBeforeChar(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int len = str.length();
        while (i < len) {
            // First of, the char at i has to be '_', looking i - 1, consider i == 0 before do i - 1
            // when i == 0, we want to skip it
            if (str.charAt(i) == '_' && (i == 0 || str.charAt(i - 1) == '_')) {
                i++;
            }
            else {
                sb.append(str.charAt(i++));
            }
        }
        return sb.toString();
    }
    /*
       __a__b_c_ -> _a_b_c
     */
    public static String trimAfterChar(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int len = str.length();
        while (i < len) {
            if (str.charAt(i) == '_' && (i == len - 1 || str.charAt(i + 1) == '_')) {
                i++;
            }
            else {
                sb.append(str.charAt(i++));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "_a";
        String str1 = "a_";
        String str2 = "_a_";
        String str3 = "_a__bn_c___d__";
        System.out.println(TrimFunc.trimAfterChar(str));
        System.out.println(TrimFunc.trimBeforeChar(str));
        System.out.println(TrimFunc.trimAfterChar(str1));
        System.out.println(TrimFunc.trimBeforeChar(str1));
        System.out.println(TrimFunc.trimAfterChar(str2));
        System.out.println(TrimFunc.trimBeforeChar(str2));
        System.out.println(TrimFunc.trimAfterChar(str3));
        System.out.println(TrimFunc.trimBeforeChar(str3));
    }


}
