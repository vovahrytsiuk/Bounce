import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class BallCanvas extends JPanel{
    private ArrayList<Ball> balls  = new ArrayList<>();
    private static final int HOLE_SIZE = 30;
    private int ballsCountInHole = 0;
    private JLabel ballsCountInHoleLabel = new JLabel("Score: 0");
    private static final boolean isHoleShowed = true;


    public void add(Ball b) {
        balls.add(b);
    }

    public void joinBalls() {
        for (int i = 0; i < balls.size(); i++) {
            Ball b = balls.get(i);
            b.set_isJoin(true);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < balls.size(); i++) {
            Ball b = balls.get(i);
            if (b.getIsInHole()) {
                balls.remove(i);
                ballsCountInHole += 1;
            } else {
                b.draw(g2);
            }
        }
        ballsCountInHoleLabel.setText("Score: " + String.valueOf(ballsCountInHole));
        add(ballsCountInHoleLabel);
        if (isHoleShowed) {
            g2.setColor(Color.darkGray);
            g2.fill(new Rectangle(0, 0, HOLE_SIZE, HOLE_SIZE));
            g2.fill(new Rectangle(0, getHeight() - HOLE_SIZE, HOLE_SIZE, HOLE_SIZE));
            g2.fill(new Rectangle(getWidth() - HOLE_SIZE, 0, HOLE_SIZE, HOLE_SIZE));
            g2.fill(new Rectangle(getWidth() - HOLE_SIZE, getHeight() - HOLE_SIZE, HOLE_SIZE, HOLE_SIZE));
        }
    }

}
