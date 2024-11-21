/**
 * 1.1.31 Random Connections
 * 
 * Write a program that takes as command-line arguments:
 *  - an integer N (number of points on a circle),
 *  - a double value p (between 0 and 1, representing the probability of a connection).
 * 
 * The program should:
 *  - Plot N equally spaced dots of size 0.05 on the circumference of a circle.
 *  - For each pair of points, draw a gray line connecting them with probability p.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Random;

public class RandomConnections extends JPanel {

    private final int n; // Number of points
    private final double p; // Probability of connection
    private final Point2D.Double[] points; // Points on the circle
    private final Random random; // Random generator

    public RandomConnections(int n, double p) {
        this.n = n;
        this.p = p;
        this.points = new Point2D.Double[n];
        this.random = new Random();
        calculatePoints();
    }

    // Calculate the coordinates of the points on the circle
    private void calculatePoints() {
        double centerX = 400; // Center X of the circle
        double centerY = 400; // Center Y of the circle
        double radius = 300;  // Radius of the circle

        for (int i = 0; i < n; i++) {
            double angle = 2 * Math.PI * i / n; // Calculate angle for each point
            double x = centerX + radius * Math.cos(angle); // X coordinate
            double y = centerY + radius * Math.sin(angle); // Y coordinate
            points[i] = new Point2D.Double(x, y); // Store point
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw points on the circle
        g2d.setColor(Color.BLUE);
        for (Point2D.Double point : points) {
            g2d.fillOval((int) point.x - 5, (int) point.y - 5, 10, 10); // Draw point as a small circle
        }

        // Draw random connections between points
        g2d.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (random.nextDouble() < p) { // Connect with probability p
                    g2d.draw(new Line2D.Double(points[i], points[j]));
                }
            }
        }
    }

    // Main method to set up the frame and run the program
    public static void main(String[] args) {
        int n = 5; // Number of points
        double p = 0.66; // Probability of connection

        JFrame frame = new JFrame("Random Connections");
        RandomConnections panel = new RandomConnections(n, p);

        frame.add(panel);
        frame.setSize(800, 800); // Frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
