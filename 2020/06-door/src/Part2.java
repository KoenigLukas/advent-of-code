import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Part2 {
    public static void main(String[] args) throws IOException {
        String path = "./06-Door/files/door6.input";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            int count = 0;
            ArrayList<String> group = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (line.equals("")) {
                    HashMap<Character, Integer> chars = new HashMap<>();
                    for (String s : group) {
                        for (char c : s.toCharArray()) {
                            if (chars.containsKey(c)) {
                                chars.put(c, chars.get(c) + 1);
                            } else {
                                chars.put(c, 1);
                            }
                        }
                    }

                    for (Integer value : chars.values()) {
                        if (value == group.size()) count += 1;
                    }
                    group = new ArrayList<>();
                } else {
                    group.add(line);
                }
            }
            HashMap<Character, Integer> chars = new HashMap<>();
            for (String s : group) {
                for (char c : s.toCharArray()) {
                    if (chars.containsKey(c)) {
                        chars.put(c, chars.get(c) + 1);
                    } else {
                        chars.put(c, 1);
                    }
                }
            }

            for (Integer value : chars.values()) {
                if (value == group.size()) count += 1;
            }
            System.out.println(count);
        }
    }

}
