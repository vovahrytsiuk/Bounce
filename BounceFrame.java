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
    public static final int BALLS_COUNT = 10;

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
                SpawnerThread spawner = new SpawnerThread(BALLS_COUNT, canvas);
                spawner.start();
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
