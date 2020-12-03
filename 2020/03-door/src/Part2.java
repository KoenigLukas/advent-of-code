import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Part2 {

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

            int ret = countTrees(input,lineCount,lineLength,1,1) * countTrees(input,lineCount,lineLength,1,3) * countTrees(input,lineCount,lineLength,1,5) * countTrees(input,lineCount,lineLength,1,7) * countTrees(input,lineCount,lineLength,2,1);

            System.out.println(ret);

        }
    }

    private static int countTrees(char[][] input, int lineCount, int lineLength, int offsetY, int offsetX) {
        int index = 0;
        int pos = 0;
        int trees = 0;

        while (index < (lineCount - 1)) {
            index += offsetY;
            pos += offsetX;

            if (pos >= lineLength) pos = pos - lineLength;

            if (input[index][pos] == '#') trees++;
        }
        return trees;
    }

    private static Integer getLineCount() throws IOException {
        List<String> fileStream = Files.readAllLines(Path.of("./03-Door/files/door3.input"));
        return fileStream.size();
    }
}
