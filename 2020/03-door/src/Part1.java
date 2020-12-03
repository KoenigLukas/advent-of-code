import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Part1 {

    public static void main(String[] args) throws IOException {
        String path = "./03-Door/files/door3.input";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line;
            int index = 0;

            line = reader.readLine();

            int lineCount = getLineCount();
            int lineLength = line.length();

            char[][] input = new char[lineCount][lineLength];

            for (int i = 0; i < line.length(); i++) {
                input[index][i] = line.charAt(i);
            }
            index++;

            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    input[index][i] = line.charAt(i);
                }
                index++;
            }

            index = 0;
            int pos = 0;
            int trees = 0;

            while (index < (lineCount-1)) {
                index ++;
                pos += 3;

                if(pos >= lineLength) pos = pos-lineLength;

                if(input[index][pos] == '#') trees++;
            }

            System.out.println(trees);

        }
    }

    private static Integer getLineCount() throws IOException {
        List<String> fileStream = Files.readAllLines(Path.of("./03-Door/files/door3.input"));
        return fileStream.size();
    }
}
