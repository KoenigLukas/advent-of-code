import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Part1 {
    public static void main(String[] args) throws IOException {
        String path = "./09-Door/files/door9.input";
        ArrayList<Long> input = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                input.add(Long.parseLong(line));
            }

            for (int i = 26; i < input.size(); i++) {
                boolean pairfound = false;
                for (int j = i - 25; j < input.size(); j++) {
                    for (int k = j + 1; k < input.size(); k++) {
                        if ((input.get(j) + input.get(k)) == input.get(i)) {
                            pairfound = true;
                            break;
                        }
                    }
                    if (pairfound) break;
                }
                if (!pairfound) {
                    System.out.println(input.get(i));
                    break;
                }
            }

        }
    }
}
