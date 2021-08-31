package bitoperation;

import java.util.BitSet;

public class Allocator {
    private int MAX_ID;
    private BitSet bitset;
    private int nextAvailable;

    public Allocator(int maxId) {
        this.MAX_ID = maxId;
        this.bitset = new BitSet(maxId);
        this.nextAvailable = 0;
    }

    public int allocate() {
        if (nextAvailable == MAX_ID) {
            return -1;
        }
        int num = nextAvailable;
        bitset.set(num); // Set the index to be true
        nextAvailable = bitset.nextClearBit(num); // Find the next available true bit
        return num;
    }

    public void release(int id) {
        if (id < 0 || id >= MAX_ID) {
            return;
        }
        if (bitset.get(id)) {
            bitset.clear(id); // Set the index to be false
            nextAvailable = Math.min(nextAvailable, id);
        }
    }

    public boolean check(int id) {
        if (id < 0 || id >= MAX_ID) {
            return false;
        }
        return !bitset.get(id);
    }
}
