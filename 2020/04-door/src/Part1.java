import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Part1 {

    public static void main(String[] args) throws IOException {
        String path = "./04-Door/files/door4.input";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            ArrayList<String> input = new ArrayList<>();
            String line;
            String tmp = null;
            while ((line = reader.readLine()) != null) {
                if (line.equals("")) {
                    input.add(tmp);
                    tmp = null;
                } else if (tmp != null) {
                    tmp = tmp.concat(" " + line);
                } else {
                    tmp = line;
                }
            }
            input.add(tmp);

            int valid = 0;

            for (String value : input) {
                String[] split = value.split(" ");
                if ((split.length == 7 && !value.matches(".*cid.*")) || split.length == 8) valid++;
            }
            System.out.println(valid);
        }
    }
}
