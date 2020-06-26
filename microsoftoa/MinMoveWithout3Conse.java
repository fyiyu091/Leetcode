package microsoftoa;

public class MinMoveWithout3Conse {
    public static int minMoves(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int move = 0;
        int i = 0;
        while (i < s.length()) {
            int next = i + 1;
            while (next < s.length() && s.charAt(i) == s.charAt(next)) {
                next++;
            }
            int diff = next - i;
            if (diff >= 3) {
                // aaaaa need to turns to aabaa
                while (diff > 5) {
                    move++;
                    diff -= 3;
                }
                if (diff <= 5) {
                    move++;
                }
            }
            i = next;
        }
        return move;
    }

    public static void main(String[] args) {
        System.out.println(minMoves("ab"));
        System.out.println(minMoves("baaabbaabbba"));
        System.out.println(minMoves("baabab"));
    }
}
