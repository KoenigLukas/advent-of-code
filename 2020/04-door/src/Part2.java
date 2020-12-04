import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Part2 {
    public static void main(String[] args) throws IOException {
        String path = "./04-Door/files/door4.input";
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            ArrayList<String> input = new ArrayList<>();
            String line;
            String tmp = null;
            while ((line = reader.readLine()) != null) {
                if (line.equals("")) {
                    input.add(tmp);
                    tmp = null;
                } else if (tmp != null) {
                    tmp = tmp.concat(" " + line);
                } else {
                    tmp = line;
                }
            }
            input.add(tmp);

            int valid = 0;

            for (String value : input) {
                boolean valueValid = true;
                String[] split = value.split(" ");

                if (!((split.length == 7 && !value.matches(".*cid.*")) || split.length == 8)) {
                    valueValid = false;
                    continue;
                }

                for (String s : split) {
                    String[] toCheck = s.trim().split(":");
                    System.out.println(Arrays.toString(toCheck));

                    if (toCheck[0].equals("byr")) {
                        if (!toCheck[1].matches("19[2-9][0-9]|200[0-2]")) {
                            valueValid = false;
                            break;
                        }
                    } else if (toCheck[0].equals("iyr")) {
                        if (!toCheck[1].matches("201[0-9]|2020")) {
                            valueValid = false;
                            break;
                        }
                    } else if (toCheck[0].equals("eyr")) {
                        if (!toCheck[1].matches("202[0-9]|2030")) {
                            valueValid = false;
                            break;
                        }
                    } else if (toCheck[0].equals("hgt")) {
                        if (!toCheck[1].matches("((1[5-8][0-9]|19[0-3])cm)|((59|6[0-9]|7[0-6])in)")) {
                            valueValid = false;
                            break;
                        }
                    } else if (toCheck[0].equals("hcl")) {
                        if (!toCheck[1].matches("#[0-9a-f]{6}")) {
                            valueValid = false;
                            break;
                        }
                    } else if (toCheck[0].equals("ecl")) {
                        if (!toCheck[1].matches("^(amb|blu|brn|gry|grn|hzl|oth|abg)$")) {
                            valueValid = false;
                            break;
                        }
                    } else if (toCheck[0].equals("pid")) {
                        if (!toCheck[1].matches("^[0-9]{9}$")) {
                            valueValid = false;
                            break;
                        }
                    }

                }

                if (valueValid) valid++;


            }
            System.out.println(valid);
        }
    }
}
