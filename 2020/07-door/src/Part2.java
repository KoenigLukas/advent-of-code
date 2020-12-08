import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    private static ArrayList<String> input = new ArrayList<>();
    private static ArrayList<String> checked = new ArrayList<>();
//    private final static Pattern p = Pattern.compile("(\\d) \\D*");

    public static void main(String[] args) throws IOException {
        String path = "./07-Door/files/door7.input";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                input.add(line);
            }

            System.out.println(count(containsColor("shiny gold"),1));




        }
    }

    private static int count(HashSet<String> bags, int count){
        checked.clear();
        for (String bag : bags) {
            String str = "(\\d) \\D*";
            Pattern p = Pattern.compile(str);
            Matcher m = p.matcher(bag);
            System.out.println(m.group(1));
            while (m.find()) {
                System.out.println(bag);
                System.out.println(m.group(1));
                count += Integer.parseInt(m.group(1));
                count += Integer.parseInt(m.group(1)) * count(containsColor(bag.substring(0, bag.indexOf(" bags"))),count);
            }
        }

        return count;
    }

    private static HashSet<String> containsColor(String color) {

        HashSet<String> ret = new HashSet<>();
        if (!checked.contains(color)) {
            checked.add(color);
            HashSet<String> tmp = new HashSet<>();
            for (String s : input) {
                if (s.substring(s.indexOf("contain ")).contains(color)) {
                    ret.add(s);
                }
            }
            for (String s : ret) {
                tmp.addAll(containsColor(s.substring(0, s.indexOf(" bags"))));
            }
            ret.addAll(tmp);
        }

        return ret;
    }
}
