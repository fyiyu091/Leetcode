package microsoftoa;

public class StrWithout3Conse {
    public static String getString(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == str.charAt(i - 1)) {
                count++;
            }
            else {
                count = 1;
            }

            if (count < 3) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
