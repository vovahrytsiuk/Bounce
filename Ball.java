import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball {
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private static final int HOLE_SIZE = 10;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    private Component canvas;
    private boolean isInHole = false;

    public Ball(Component c) {
        this.canvas = c;
        if (Math.random() < 0.5) {
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        } else {
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }

    public void draw(Graphics2D g2) {
        if (isInHole == false) {
            g2.setColor(Color.darkGray);
            g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
        }
    }

    public void move() {
        x += dx;
        y += dy;
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (x + XSIZE >= canvas.getWidth()) {
            x = canvas.getWidth() - XSIZE;
            dx = -dx;
        }
        if (y + YSIZE >= canvas.getHeight()) {
            y = canvas.getHeight() - YSIZE;
            dy = -dy;
        }
        isInHole = isHole();
        this.canvas.repaint();
    }

    private boolean isHole() {
        return (x < HOLE_SIZE && y < HOLE_SIZE) ||
                (x < HOLE_SIZE && y > canvas.getHeight() - HOLE_SIZE) ||
                (x > canvas.getWidth() - HOLE_SIZE && y < HOLE_SIZE) ||
                (x > canvas.getWidth() - HOLE_SIZE && y > canvas.getHeight() - HOLE_SIZE);
    }

    public boolean getIsInHole() {
        return isInHole;
    }
}
