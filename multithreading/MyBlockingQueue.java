package multithreading;

//public class MyBlockingQueue extends Queue {
//    private int itemCount;
//    private int maxItems;
//
//    MyBlockingQueue(int maxItems) {
//        this.itemCount = 0;
//        this.maxItems = maxItems;
//    }
//
//    // Offer
//    synchronized void offer(int item) {
//        while (itemCount == maxItems) {
//            try {
//                wait();
//            }
//            catch (InterruptedException e) {}
//        }
//        super.offer(item);
//        itemCount++;
//        notifyAll();
//    }
//
//    // Poll
//    synchronized int poll() {
//        while (itemCount == 0) {
//            try {
//                wait();
//            }
//            catch (InterruptedException e) {}
//        }
//        int res = super.poll();
//        itemCount--;
//        notifyAll();
//        return res;
//    }
//}
