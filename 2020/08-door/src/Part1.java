import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Part1 {

    private static ArrayList<String> input = new ArrayList<>();
    private static ArrayList<Integer> checked = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String path = "./08-Door/files/door8.input";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                input.add(line);
            }
            int acc = 0;

            for (int i = 0; i < input.size(); i++) {
                String[] split = input.get(i).split(" ");

                if(!checked.contains(i)) {
                    checked.add(i);
                    if (split[0].equals("nop")) {
                    } else if (split[0].equals("acc")) {
                        acc += Integer.parseInt(split[1]);
                    } else if (split[0].equals("jmp")) {
                        i += Integer.parseInt(split[1])-1;
                    }
                } else{
                    System.out.println(acc);
                    break;
                }

            }

        }
    }
}
