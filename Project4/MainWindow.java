import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainWindow extends JFrame {

    protected static Color c = Color.BLACK;
    protected static int s = 5;
    protected static MainCanvas canvas = new MainCanvas();

    public MainWindow() {
        setLayout(new FlowLayout());
        this.setSize(600,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(700,700));
        this.setTitle("Mock MSPaint");
        JButton button1c = new JButton("Red");
        button1c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = Color.RED;
                System.out.println(MainWindow.getC());

            }
            });

        JButton button2c = new JButton("Blue");
        button2c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = Color.BLUE;
                System.out.println(MainWindow.getC());

            }
        });


        JButton button3c = new JButton("Green");
        button3c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = Color.GREEN;
                System.out.println(MainWindow.getC());

            }
        });

        JButton button4c = new JButton("Black");
        button4c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = Color.BLACK;
                System.out.println(MainWindow.getC());

            }

        });

        JButton button1s = new JButton("Fine");
        button1s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = 2;
                System.out.println(MainWindow.getS());

            }

        });

        JButton button2s = new JButton("Normal");
        button2s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = 5;
                System.out.println(MainWindow.getS());

            }

        });

        JButton button3s = new JButton("Thick");
        button3s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s = 15;
                System.out.println(MainWindow.getS());

            }

        });

        JButton buttonC = new JButton("Clear");
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Clear".equals(e.getActionCommand()))
                    canvas.clear();

                System.out.println("Clear?");

            }

        });
        this.add(button1c);
        this.add(button2c);
        this.add(button3c);
        this.add(button4c);
        this.add(button1s);
        this.add(button2s);
        this.add(button3s);
        this.add(buttonC);
        this.add(canvas, BorderLayout.CENTER);
        this.setSize(601,601);

    }
    public static Color getC() {
        return c;
    }

    public static int getS() {
        return s;
    }
}
