package main.java.sort;

import main.java.domain.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliviachisman on 10/1/18
 */
public abstract class MergeSort {

    public List<Point> sort(List<Point> points) {
        if (points.size() <= 1) {
            return points;
        }
        int midpoint = points.size()/2;
        List<Point> leftList = sort(points.subList(0, midpoint));
        List<Point> rightList = sort(points.subList(midpoint, points.size()));

        return merge(leftList, rightList);
    }

    private List<Point> merge(List<Point> leftList, List<Point> rightList) {
        List<Point> sorted = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (rightIndex < rightList.size() || leftIndex < leftList.size()) {
            if (leftIndex == leftList.size()) {
                sorted.add(rightList.get(rightIndex++));
            } else if (rightIndex == rightList.size()) {
                sorted.add(leftList.get(leftIndex++));
            } else {
                Point pL = leftList.get(leftIndex);
                Point pR = rightList.get(rightIndex);
                if (compare(pL, pR)) {
                    sorted.add(pL);
                    leftIndex++;
                } else {
                    sorted.add(pR);
                    rightIndex++;
                }
            }
        }
        return sorted;
    }

    protected abstract boolean compare(Point p1, Point p2);

}
