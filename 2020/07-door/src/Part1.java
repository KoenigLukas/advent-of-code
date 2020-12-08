import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Part1 {

    private static ArrayList<String> input = new ArrayList<>();
    private static ArrayList<String> checked = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String path = "./07-Door/files/door7.input";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                input.add(line);
            }

            System.out.println(containsColor("shiny gold").size());

        }
    }

    private static HashSet<String> containsColor(String color){

        HashSet<String> ret = new HashSet<>();
        if(!checked.contains(color)){
            checked.add(color);
            HashSet<String> tmp = new HashSet<>();
            for (String s : input) {
                if (s.substring(s.indexOf("contain ")).contains(color)){
                    ret.add(s.substring(0,s.indexOf(" bags")));
                }
            }
            for (String s : ret) {
                tmp.addAll(containsColor(s));
            }
            ret.addAll(tmp);
        }

        return ret;
    }
}
