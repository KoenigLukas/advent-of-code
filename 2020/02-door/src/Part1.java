import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Part1 {

    public static void main(String[] args) throws IOException {
        String path = "./02-Door/files/door2.input";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            ArrayList<String> list = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }

            int valid = 0;

            for (String elem : list) {
                String[] split = elem.split(" ");
                String[] policies = split[0].split("-");
                int min = Integer.parseInt(policies[0]);
                int max = Integer.parseInt(policies[1]);
                char c = split[1].charAt(0);

                int count = 0;

                for (int i = 0; i < split[2].length(); i++) {
                    if(split[2].charAt(i) == c) count++;
                }
                if(count >= min && count <= max) valid++;
            }
            System.out.println(valid);
        }
    }
}
