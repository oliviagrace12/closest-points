package main.java;

import main.java.domain.Pair;
import main.java.domain.Point;
import main.java.sort.SortByX;
import main.java.sort.SortByY;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliviachisman on 10/25/18
 */
public class ClosestPairAlgorithm {


    public Pair findClosestPair(List<Point> points) {
        List<Point> pointsByX = new SortByX().sort(points);
        int half = pointsByX.size() / 2;
        List<Point> left = pointsByX.subList(0, half);
        List<Point> right = pointsByX.subList(half, points.size());

        Pair closestPairLeft = findClosest(left);
        Pair closestPairRight = findClosest(right);

        Pair closestOverall = closestPairLeft.getDistance() < closestPairRight.getDistance() ?
                closestPairLeft : closestPairRight;

        double dividingLineX = getDividingLineX(pointsByX);
        List<Point> pointsInRange = findPointsInXRange(closestOverall.getDistance(), points, dividingLineX);

        pointsInRange = new SortByY().sort(pointsInRange);

        for (Point p : pointsInRange) {
            int numPts = pointsInRange.size();
            int index = pointsInRange.indexOf(p);
            if (index < numPts) {
                for (int i = index + 1; i < index + 8; i++) {
                    if (i < numPts) {
                        double distance = distanceBetween(p, pointsInRange.get(i));
                        if (distance < closestOverall.getDistance()) {
                            return new Pair(p, pointsInRange.get(i), distance);
                        }
                    }
                }
            }
        }

        return closestOverall;
    }

    private double getDividingLineX(List<Point> pointsByX) {
        int half = pointsByX.size() / 2;
        double distBetweenMiddle = (pointsByX.get(half).x() - pointsByX.get(half - 1).x());
        double halfDistBetweenMiddle = distBetweenMiddle / 2.0;
        return pointsByX.get(half - 1).x() + halfDistBetweenMiddle;
    }

    private List<Point> findPointsInXRange(double distance, List<Point> points, double dividingLineX) {
        double rangeStart = dividingLineX - distance;
        double rangeEnd = dividingLineX + distance;

        List<Point> inRange = new ArrayList<>();
        for (Point p : points) {
            if (p.x() >= rangeStart && p.x() <= rangeEnd) {
                inRange.add(p);
            }
        }
        return inRange;
    }

    public Pair findClosest(List<Point> points) {
        double min = Double.MAX_VALUE;
        Point minPairP1 = null;
        Point minPairP2 = null;
        for (Point p1 : points) {
            for (Point p2 : points) {
                if (p1 != p2) {
                    double dist = distanceBetween(p1, p2);
                    if (dist < min) {
                        min = dist;
                        minPairP1 = p1;
                        minPairP2 = p2;
                    }
                }
            }
        }
        return new Pair(minPairP1, minPairP2, min);
    }

    private double distanceBetween(Point p1, Point p2) {
        return Math.sqrt(square(p1.x() - p2.x()) + square(p1.y() - p2.y()));
    }

    private double square(double x) {
        return x * x;
    }
}
