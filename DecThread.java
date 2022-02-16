public class DecThread extends Thread{
    private Counter counter;

    public DecThread(Counter newCounter) {
        counter = newCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter.decWithLock();
        }
    }
}
