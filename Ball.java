import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball {
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private static final int HOLE_SIZE = 25;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    private Component canvas;
    private boolean isInHole = false;
    private Color ballColor;
    private boolean isJoined;

    public Ball(Component c, Color color) {
        this.canvas = c;
        ballColor = color;
        if (Math.random() < 0.5) {
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        } else {
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
//        x = canvas.getWidth() / 2;
//        y = canvas.getHeight() / 2;
    }

    public void draw(Graphics2D g2) {
        if (isInHole == false) {
            g2.setColor(ballColor);
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

    public void set_isJoin(boolean joined) {
        isJoined = joined;
    }

    public boolean get_isJoined() {
        return isJoined;
    }

    public boolean getIsInHole() {
        return isInHole;
    }
}
