public class CounterMain {
    static public void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        IncThread incThread = new IncThread(counter);
        DecThread decThread = new DecThread(counter);
        incThread.start();
        decThread.start();
        incThread.join();
        decThread.join();
        System.out.println(counter.getCounter());
    }
}
