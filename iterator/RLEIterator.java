package iterator;

class RLEIterator {
    private int idx;
    private int[] encoded;

    public RLEIterator(int[] encoding) {
        this.idx = 0;
        this.encoded = encoding;
    }

    public int next(int n) {
        // This case also covers when n <= encoded[idx]
        while (idx < encoded.length && n > encoded[idx]) {
            n -= encoded[idx];
            idx += 2;
        }
        if (idx >= encoded.length) {
            return -1;
        }
        encoded[idx] -= n;
        return encoded[idx + 1];
    }
}