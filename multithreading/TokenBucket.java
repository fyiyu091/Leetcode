package multithreading;

public class TokenBucket {
    private final long maxBucketSize;
    private final long refillRate;

    private double currentBucketSize;
    private long lastRefillTimeStamp;

    public TokenBucket(long maxBucketSize, long refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;

        currentBucketSize = maxBucketSize;
        lastRefillTimeStamp = System.nanoTime();
    }

    // Make sure only one request can gets to this method
    public synchronized boolean allowRequest(int tokens) {
        refill();

        if (tokens <= this.currentBucketSize) {
            currentBucketSize -= tokens;
            return true;
        }

        return false;
    }

    private void refill() {
        long now = System.nanoTime();

        double tokenAdded = (now - lastRefillTimeStamp) / 1e9 * refillRate;
        currentBucketSize = Math.min(currentBucketSize + tokenAdded, maxBucketSize);
        lastRefillTimeStamp = now;
    }
}
