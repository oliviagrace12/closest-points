package main.java.domain;

/**
 * Created by oliviachisman on 10/28/18
 */
public class Pair {
    private Point p1;
    private Point p2;
    private double distance;

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public double getDistance() {
        return distance;
    }

    public Pair(Point p1, Point p2, double distance) {
        this.p1 = p1;
        this.p2 = p2;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", distance=" + distance +
                '}';
    }
}
