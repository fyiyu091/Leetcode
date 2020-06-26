package tree;

import java.util.List;

public class NaryTree {
    int val;
    List<NaryTree> childrenNodes;
    public NaryTree(int val) {
        this.val = val;
        this.childrenNodes = null;
    }
}
