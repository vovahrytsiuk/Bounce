import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BounceFrame extends JFrame{
    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;
    public static final int BLUE_BALLS_COUNT = 10;
    public static final int RED_BALLS_COUNT = 1;
    private static final int RED_BALL_PRIORITY = Thread.MAX_PRIORITY;
    private static final int BLUE_BALL_PRIORITY = Thread.MIN_PRIORITY;

    public BounceFrame() {
        setSize(WIDTH, HEIGHT);
        setTitle("Bounce program");

        canvas = new BallCanvas();
        System.out.println("In Frame Thread Name = " + Thread.currentThread().getName());

        Container content = getContentPane();
        content.add(canvas, BorderLayout.CENTER);

        JPanel buttonPatel = new JPanel();
        buttonPatel.setBackground(Color.lightGray);

        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < BLUE_BALLS_COUNT; i++) {
                    Ball b = new Ball(canvas, Color.blue);
                    canvas.add(b);
                    BallThread thread = new BallThread(b);
                    thread.setPriority(BLUE_BALL_PRIORITY);
                    thread.start();
                    System.out.println("Blue : Thread name = " + thread.getName());
                }
                for (int i = 0; i < RED_BALLS_COUNT; i++) {
                    Ball b = new Ball(canvas, Color.red);
                    canvas.add(b);
                    BallThread thread = new BallThread(b);
                    thread.setPriority(RED_BALL_PRIORITY);
                    thread.start();
                    System.out.println("Red : Thread name = " + thread.getName());
                }
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        buttonPatel.add(buttonStart);
        buttonPatel.add(buttonStop);

        content.add(buttonPatel, BorderLayout.SOUTH);
    }
}
