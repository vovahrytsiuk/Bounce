public class BallThread extends Thread{
    private Ball b;
    public static int finishedThreadCount = 0;

    public BallThread(Ball ball) {
        b = ball;
    }

    @Override
    public void run() {
        try {
            while(b.getIsInHole() == false) {
                b.move();
                System.out.println("Thread Name = " + Thread.currentThread().getName());
                Thread.sleep(5);
            }
        }
        catch (InterruptedException ex) {

        }
        finishedThreadCount += 1;
        System.out.println("Another ball hit a hole. Total count of balls in the hole: " + finishedThreadCount);
    }
}
