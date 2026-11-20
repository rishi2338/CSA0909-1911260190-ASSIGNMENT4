/*
 * ASSIGNMENT 4 - TASK 4
 *
 * Original faulty example from the PDF (preserved for defect analysis):
 *
 * public class DrawPad extends Frame {
 *   int count = 0; Label status = new Label("Clicks: 0");
 *   public DrawPad() {
 *     add(status, BorderLayout.SOUTH);
 *     addMouseListener(new MouseAdapter() {
 *       public void mouseclicked(MouseEvent e) {
 *         count++;
 *         Graphics g = getGraphics(); g.fillOval(e.getX(), e.getY(), 6, 6);
 *       }
 *     });
 *     setSize(400, 300); setVisible(true);
 *   }
 * }
 *
 * The PDF's Complete the Code version provides a List<Point>, a status Label,
 * TODO 1 in mouseClicked(), TODO 2 in paint(), and a WindowAdapter.
 * The runnable implementation below completes those TODOs: it stores each
 * click, updates the label, requests repaint(), and redraws all points in paint().
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class task4 extends Frame {
    private final List<Point> points = new ArrayList<>();
    private final Label status = new Label("Clicks: 0");

    public task4() {
        super("Draw Pad");
        add(status, BorderLayout.SOUTH);
        addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked(MouseEvent e) {
                points.add(e.getPoint());
                status.setText("Clicks: " + points.size());
                repaint();
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override public void windowClosing(WindowEvent e) { dispose(); }
        });
        setSize(500, 360);
    }

    @Override public void paint(Graphics g) {
        super.paint(g);
        for (Point point : points)
            g.fillOval(point.x - 3, point.y - 3, 6, 6);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new task4().setVisible(true));
    }
}