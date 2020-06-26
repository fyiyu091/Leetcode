package bitoperation;

public class L201 {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            int tmp1 = m >>> i;
            int tmp2 = n >>> i;
            if (tmp1 == tmp2) {
                res |= tmp1 << i;
            }
        }

        return res;
    }
}
