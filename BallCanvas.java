import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;

public class BallCanvas extends JPanel{
    private ArrayList<Ball> balls  = new ArrayList<>();
    private static final int HOLE_SIZE = 30;

    public void add(Ball b) {
        balls.add(b);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < balls.size(); i++) {
            Ball b = balls.get(i);
            b.draw(g2);
        }
        g2.fill(new Rectangle(0, 0, HOLE_SIZE, HOLE_SIZE));
        g2.fill(new Rectangle(0, getHeight() - HOLE_SIZE, HOLE_SIZE, HOLE_SIZE));
        g2.fill(new Rectangle(getWidth() - HOLE_SIZE, 0, HOLE_SIZE, HOLE_SIZE));
        g2.fill(new Rectangle(getWidth() - HOLE_SIZE, getHeight() - HOLE_SIZE, HOLE_SIZE, HOLE_SIZE));
    }

}
