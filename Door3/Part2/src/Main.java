import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    /*
           VERY BAD RUNNTIME (3,5 Minutes)!
     */
    public static void main(String[] args) throws IOException {

        ArrayList<Queue<ManhattenCoordinates>> input = readInput("input1.txt");
        ArrayList<ArrayList<Coordinates>> coordinates = new ArrayList<>();

        for (Queue<ManhattenCoordinates> queue : input) {
            ArrayList<Coordinates> subCoordinate = new ArrayList<>();
            int prevx = 0;
            int prevy = 0;
            int steps = 0;
            for (ManhattenCoordinates manhattenCoordinates : queue) {
                if (manhattenCoordinates.getDirection() == Direction.RIGHT) {
                    for (int i = 0; i < manhattenCoordinates.getSteps(); i++) {
                        Coordinates tmpcords = new Coordinates((prevy), prevx + 1, ++steps);
                        prevx = tmpcords.getX();
                        prevy = tmpcords.getY();
                        subCoordinate.add(tmpcords);
                    }
                } else if (manhattenCoordinates.getDirection() == Direction.LEFT) {
                    for (int i = 0; i < manhattenCoordinates.getSteps(); i++) {
                        Coordinates tmpcords = new Coordinates((prevy), prevx - 1, ++steps);
                        prevx = tmpcords.getX();
                        prevy = tmpcords.getY();
                        subCoordinate.add(tmpcords);
                    }
                } else if (manhattenCoordinates.getDirection() == Direction.DOWN) {
                    for (int i = 0; i < manhattenCoordinates.getSteps(); i++) {
                        Coordinates tmpcords = new Coordinates((prevy - 1), prevx, ++steps);
                        prevx = tmpcords.getX();
                        prevy = tmpcords.getY();
                        subCoordinate.add(tmpcords);
                    }
                } else if (manhattenCoordinates.getDirection() == Direction.UP) {
                    for (int i = 0; i < manhattenCoordinates.getSteps(); i++) {
                        Coordinates tmpcords = new Coordinates((prevy + 1), prevx, ++steps);
                        prevx = tmpcords.getX();
                        prevy = tmpcords.getY();
                        subCoordinate.add(tmpcords);
                    }
                }
            }
            coordinates.add(subCoordinate);
        }
        
        int distance = 0;

        //97.000.000 iterations needed lol
        for (int i = 0; i < coordinates.get(0).size(); i++) {
            for (int j = 0; j < coordinates.get(1).size(); j++) {
                if ((coordinates.get(0).get(i).equals(coordinates.get(1).get(j)))
                        && ((coordinates.get(0).get(i).getX() != 0) && (coordinates.get(0).get(i).getY() != 0))
                        && ((coordinates.get(0).get(i).getX() != 0) && (coordinates.get(0).get(i).getY() != 0))) {

                    if (distance == 0) {
                        distance = (coordinates.get(1).get(j).getSteps() + coordinates.get(0).get(i).getSteps());
                    } else {
                        int tmpdist = (coordinates.get(1).get(j).getSteps() + coordinates.get(0).get(i).getSteps());
                        if (distance > tmpdist) {
                            distance = tmpdist;
                        }
                    }
                }
            }
        }

        System.out.println(distance);
    }

    private static ArrayList<Queue<ManhattenCoordinates>> readInput(String path) throws IOException {
        ArrayList<Queue<ManhattenCoordinates>> ret = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                Queue<ManhattenCoordinates> queue = new LinkedList<>();
                String[] split = line.split(",");
                for (String s : split) {
                    if (s.charAt(0) == 'R') {
                        ManhattenCoordinates cord = new ManhattenCoordinates(Direction.RIGHT, Integer.parseInt(s.substring(1)));
                        queue.add(cord);
                    } else if (s.charAt(0) == 'L') {
                        ManhattenCoordinates cord = new ManhattenCoordinates(Direction.LEFT, Integer.parseInt(s.substring(1)));
                        queue.add(cord);
                    } else if (s.charAt(0) == 'D') {
                        ManhattenCoordinates cord = new ManhattenCoordinates(Direction.DOWN, Integer.parseInt(s.substring(1)));
                        queue.add(cord);
                    } else if (s.charAt(0) == 'U') {
                        ManhattenCoordinates cord = new ManhattenCoordinates(Direction.UP, Integer.parseInt(s.substring(1)));
                        queue.add(cord);
                    }
                }
                ret.add(queue);
            }
        }
        return ret;
    }

}

