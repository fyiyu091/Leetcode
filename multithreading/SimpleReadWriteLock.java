package multithreading;

public class SimpleReadWriteLock {
    private int readers = 0;
    private int writers = 0;
    private int writeRequests = 0;

    public synchronized void lockRead() throws InterruptedException {
        while (writers > 0 || writeRequests > 0) { // means there are writing or have writing request
            wait();
        }

        readers++;
    }

    public synchronized void unlockRead() {
        readers--;
        /*
            Why do we need notifyAll()
            If we just do notify()
            If we awaken a read thread and there is write waiting()
            Nothing would happened
         */
        notifyAll();
    }

    public synchronized void lockWrite() throws InterruptedException {
        /*
            Like if there are many reads waiting, and one write finishes
            We would prioritize write over read
         */
        writeRequests++;
        while (readers > 0 || writers > 0) {
            wait();
        }

        writeRequests--;
        writers++;
    }

    public synchronized void unlockWrite() throws InterruptedException {
        writers--;
        notifyAll();
    }
}
