package tree;

import java.util.BitSet;

public class AllocatorSegmentTree {
    private int MAXID;
    private BitSet bitSet;

    public AllocatorSegmentTree(int maxId) {
        this.MAXID = maxId;
        this.bitSet = new BitSet(maxId * 2 - 1);
    }

    public int allocate() {
        int index = 0;
        // Find the first bit that's not set by traverse through the tree
        while (index < MAXID - 1) {
            if (!bitSet.get(index * 2 + 1)) {
                index = index * 2 + 1;
            }
            else if (!bitSet.get(index * 2 + 2)) {
                index = index * 2 + 2;
            }
            else {
                return -1;
            }
        }

        bitSet.set(index);
        updateTree(index);

        // The transition from the real ID and the index of the bitSet is
        // ID + maxID - 1 = index in the bitSet
        return index - MAXID + 1;
    }

    public void updateTree(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (index % 2 == 1) { // left child
                if (bitSet.get(index) && bitSet.get(index + 1)) {
                    bitSet.set(parent);
                }
                else {
                    bitSet.clear(parent);
                }
            }
            else {
                if (bitSet.get(index) && bitSet.get(index - 1)) {
                    bitSet.set(parent);
                }
                else {
                    bitSet.clear(parent);
                }
            }
            index = parent;
        }
    }

    public void release(int id) {
        if (bitSet.get(id + MAXID - 1)) {
            bitSet.clear(id + MAXID - 1);
            updateTree(id + MAXID - 1);
        }
    }

    public boolean check(int id) {
        return !bitSet.get(id + MAXID - 1);
    }
}
