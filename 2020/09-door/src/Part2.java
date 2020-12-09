import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

public class Part2 {
    public static void main(String[] args) throws IOException {
        String path = "./09-Door/files/door9.input";
        ArrayList<Long> input = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                input.add(Long.parseLong(line));
            }
            
            final long tofind = 104054607;

            for (int i = 0; i < input.size()-1; i++) {
                long sum = input.get(i);
                for (int j = i+1; j < input.size(); j++) {
                    sum += input.get(j);
                    if(sum == tofind){
                        TreeSet<Long> tmp = new TreeSet<>();
                        for (int k = i; k <= j; k++) {
                            tmp.add(input.get(k));
                        }
                        System.out.println(tmp.first()+tmp.last());
                        return;
                    }
                }
            }
            
        }
    }
}
