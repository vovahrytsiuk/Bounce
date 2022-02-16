public class IncThread extends Thread{
    private Counter counter;

    IncThread(Counter newCounter) {
        counter = newCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            counter.incWithLock();
        }
    }
}
