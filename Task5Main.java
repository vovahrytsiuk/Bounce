public class Task5Main {
    static public final int COUNT = 100000;
    static public void main(String args[]) {
        Sync sync = new Sync(COUNT);
        Thread th1 =  new Thread(new SyncPrint('-', true, sync));
        Thread th2 =  new Thread(new SyncPrint('|', false, sync));
        th1.start();
        th2.start();
    }
}
