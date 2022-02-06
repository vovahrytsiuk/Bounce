public class BallThread extends Thread{
    private Ball b;
    public static int finishedThreadCount = 0;

    public BallThread(Ball ball) {
        b = ball;
    }

    @Override
    public void run() {
        System.out.println("Started Thread name : " + Thread.currentThread().getName());
        try {
            while(b.getIsInHole() == false) {
                b.move();
                Thread.sleep(5);
            }
        }
        catch (InterruptedException ex) {
            System.out.println("Interrupted Thread name : " + Thread.currentThread().getName());
        }
        System.out.println("Finished Thread name : " + Thread.currentThread().getName());
        finishedThreadCount += 1;
    }
}
