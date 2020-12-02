import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Part1 {

    public static void main(String[] args) throws IOException {
        String path = "./01-Door/files/door1.input";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            ArrayList<Integer> list = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }

            boolean found = false;

            for (int i = 0; i < list.size(); i++) {
                if(found) break;
                for (int j = 0; j < list.size(); j++) {
                    if (i != j && (list.get(i) + list.get(j)) == 2020){
                        System.out.println(list.get(i) * list.get(j));
                        found = true;
                        break;
                    }
                }
            }
        }
    }

}
