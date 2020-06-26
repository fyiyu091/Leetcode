package string;

public class L165 {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            return 0;
        }

        int len1 = version1.length();
        int len2 = version2.length();
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");

        int i = 0;
        while (i < strs1.length && i < strs2.length) {
            int n1 = Integer.valueOf(strs1[i]);
            int n2 = Integer.valueOf(strs2[i]);
            if (n1 < n2) {
                return -1;
            }
            if (n1 > n2) {
                return 1;
            }
            i++;
        }

        if (i < strs1.length) {
            for (int j = i; j < strs1.length; j++) {
                if (Integer.valueOf(strs1[j]) > 0) {
                    return 1;
                }
            }
        }
        if (i < strs2.length) {
            for (int j = i; j < strs2.length; j++) {
                if (Integer.valueOf(strs2[j]) > 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
