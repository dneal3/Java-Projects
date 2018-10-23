import java.awt.*;

public class Points {
    protected int x;
    protected int y;
    protected Color c;
    protected int s;
    public Points(Point thisPoint, Color c, int s) {
        this.x = (int) thisPoint.getX();
        this.y = (int) thisPoint.getY();
        this.c = c;
        this.s = s;
    }

    public Color getC() {
        return c;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public int getS() {
        return s;
    }
}

