import java.awt.*;

public class SpawnerThread extends Thread{
    private int ballsCount;
    private BallCanvas canvas;

    public SpawnerThread(int ballsNumber, BallCanvas can) {
        ballsCount = ballsNumber;
        canvas = can;
    }

    public void run() {
        for (int i = 0; i < ballsCount; i++) {
            Ball b = new Ball(canvas, Color.red);
            canvas.add(b);
            BallThread thread = new BallThread(b);
            thread.start();
            System.out.println("Waiting for join: " + thread.getName());
            try {
                thread.join();
            }
            catch (InterruptedException ex) {
                System.out.println("Interrupted : Thread name = " + thread.getName());
            }
            System.out.println("Joined: " + thread.getName());
        }
    }
}
