import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.*;
public class MainCanvas extends JPanel {
    protected static ArrayList<Points> points;

    public MainCanvas() {
        points = new ArrayList<>();
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(500, 500));
        MouseMotionListener adapter = new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent event) {
                Point thisPoint = (event.getPoint());
                Points currentPoint = new Points(thisPoint, MainWindow.getC(), MainWindow.getS());
                    points.add(currentPoint);
                    repaint();
                    System.out.println("x: " + currentPoint.getX() + "  y: " + currentPoint.getY());
            }
        };
        addMouseMotionListener(adapter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Points point : points) {
            g.setColor(point.getC());
            g.fillOval((int) point.getX(), (int) point.getY(), point.getS(), point.getS());
        }
    }
    public void clear() {
        points = new ArrayList<>();
        repaint();

    }
}


