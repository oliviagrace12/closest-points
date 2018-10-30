package main.java.sort;

import main.java.domain.Point;

/**
 * Created by oliviachisman on 10/29/18
 */
public class SortByY extends MergeSort {
    @Override
    protected boolean compare(Point p1, Point p2) {
        return p1.y() < p2.y();
    }
}
