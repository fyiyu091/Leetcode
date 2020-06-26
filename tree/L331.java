package tree;

/* Verify preorder serialization of a binary tree
*  Number of # = Number of Node + 1
*
* */
public class L331 {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }

        // delta means number of node - number of #
        // give normal node 1
        int delta = 1;
        String[] strs = preorder.split(",");
        for (String str : strs) {
            // haven't ending, we have already reached a complete tree
            if (delta == 0) {
                return false;
            }
            if (str.equals("#")) {
                delta -= 1;
            }
            else {
                delta += 1;
            }
        }

        return delta == 0;
    }
}
