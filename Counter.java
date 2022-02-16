import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int number = 0;
    private Object sync = new Object();
    private ReentrantLock locker = new ReentrantLock();

    public synchronized void inc() {
        number++;
    }

    public synchronized void dec() {
        number--;
    }

    public void incWithLock(){
        locker.lock();
        ++number;
        locker.unlock();
    }
    public void  decWithLock(){
        locker.lock();
        --number;
        locker.unlock();
    }


    public  void incBlock(){
        synchronized (sync)
        {
            ++number;
        }

    }
    public  void  decBlock(){
        synchronized (sync)
        {
            --number;
        }
    }

    public int getCounter() {
        return number;
    }
}
