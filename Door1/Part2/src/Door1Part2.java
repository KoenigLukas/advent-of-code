import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Door1Part2 {

    public static int finalResult;

    public static void main(String[] args) throws IOException {
        int sum = 0;
        ArrayList<Integer> input = readInput("input.txt");


        for (Integer integer : input) {
            calcFuel(integer);
        }
        System.out.println(finalResult);
    }

    private static void calcFuel(int mass) {
        int tmp = (mass / 3 - 2);
        if (tmp > 0) {
            finalResult += tmp;
            calcFuel(tmp);
        }
    }

    private static ArrayList<Integer> readInput(String path) throws IOException {
        ArrayList<Integer> ret = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                ret.add(Integer.parseInt(line));
            }
        }
        return ret;
    }
}
