import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Part1 {
    public static void main(String[] args) throws IOException {
        String path = "./06-Door/files/door6.input";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            StringBuilder group = new StringBuilder();
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if(line.equals("")){
                    HashSet<Character> unique = new HashSet<>();
                    for (Character cha : group.toString().toCharArray()) {
                        unique.add(cha);
                    }
                    count += unique.size();
                    group = new StringBuilder();
                } else {
                    group.append(line);
                }
            }
            HashSet<Character> unique = new HashSet<>();
            for (Character cha : group.toString().toCharArray()) {
                unique.add(cha);
            }
            count += unique.size();
            group = new StringBuilder();
            System.out.println(count);
        }
    }
}
