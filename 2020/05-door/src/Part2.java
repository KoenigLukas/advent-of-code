import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Part2 {

    public static void main(String[] args) throws IOException {
        String path = "./05-Door/files/door5.input";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            ArrayList<Integer> seatIDs = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String row = line.substring(0, 7);
                String seat = line.substring(7, 10);
                row = row.replace("F", "0");
                row = row.replace("B", "1");
                seat = seat.replace("L", "0");
                seat = seat.replace("R", "1");

                int rowNum = Integer.parseInt(row, 2);
                int seatNum = Integer.parseInt(seat, 2);

                int seatID = rowNum * 8 + seatNum;

                seatIDs.add(seatID);
            }
            Collections.sort(seatIDs);

            for (int i = 1; i < seatIDs.size() - 1; i++) {
                if ((seatIDs.get(i) - 1 > seatIDs.get(i - 1))) {
                    System.out.println(seatIDs.get(i) - 1);
                }
            }

        }
    }
}
