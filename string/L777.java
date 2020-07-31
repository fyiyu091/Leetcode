package string;

/*
    Given the string contains only 'L', 'R', 'X'
    One move is from "XL" to "LX" or "RX" to "XR"
    Check whether we can transform from start to end

    The key is that L and R's position can not be swapped
    RXXXXLX can not be LXXXRXX
 */
public class L777 {
    public boolean canTransform(String start, String end) {
        if (start == null || end == null || start.length() != end.length()) {
            return false;
        }
        if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false;
        }

        int idx1 = 0;
        int idx2 = 0;
        int len1 = start.length();
        int len2 = end.length();

        while (idx1 < len1 && idx2 < len2) {
            while (idx1 < len1 && start.charAt(idx1) == 'X') {
                idx1++;
            }
            while (idx2 < len2 && end.charAt(idx2) == 'X') {
                idx2++;
            }
            if (idx1 == len1 && idx2 == len2) {
                return true;
            }
            if (idx1 == len1 || idx2 == len2 || start.charAt(idx1) != end.charAt(idx2)) {
                return false;
            }
            if (start.charAt(idx1) == 'L' && idx1 < idx2 || start.charAt(idx1) == 'R' && idx1 > idx2) {
                return false;
            }
            idx1++;
            idx2++;
        }

        return true;
    }
}
