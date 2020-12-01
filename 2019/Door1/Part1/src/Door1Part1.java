import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Door1Part1 {


    public static void main(String[] args) throws IOException {
        int sum = 0;
        ArrayList<Integer> input = readInput("input.txt");

        for (Integer integer : input) {
            sum += (integer/3-2);
        }
        System.out.println(sum);
    }

    private static ArrayList<Integer> readInput(String path) throws IOException {
        ArrayList<Integer> ret = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while((line = br.readLine()) != null){
                ret.add(Integer.parseInt(line));
            }
        }
        return ret;
    }

}
