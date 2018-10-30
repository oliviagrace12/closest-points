package main.java;

import main.java.domain.Pair;
import main.java.domain.Point;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oliviachisman on 10/25/18
 */
public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("ERROR: Please specify the test case file location in program arguments");
            return;
        }
        String fileName = args[0];

        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));

        String line;
        List<Point> points = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            String[] array = line.trim().split(" ");
            points.add(new Point(Integer.valueOf(array[0]), Integer.valueOf(array[1])));
        }

        ClosestPairAlgorithm algo = new ClosestPairAlgorithm();

        Pair pair = algo.findClosestPair(points);

        System.out.println("Closest pair: " + pair);
    }

}
