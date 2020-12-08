import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Part2 {


    public static void main(String[] args) throws IOException {
        String path = "./08-Door/files/door8.input";
        ArrayList<String> input = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                input.add(line);
            }
            for (int i = 0; i < input.size(); i++) {
                if(input.get(i).matches("nop.*")){
                    input.set(i,input.get(i).replace("nop","jmp"));
                    if(!runCode(input)) input.set(i,input.get(i).replace("jmp","nop"));
                    else break;
                } else if(input.get(i).matches("jmp.*")){
                    input.set(i,input.get(i).replace("jmp","nop"));
                    if(!runCode(input)) input.set(i,input.get(i).replace("nop","jmp"));
                    else break;
                }
            }

        }
    }

    private static boolean runCode(ArrayList<String> input){
        ArrayList<Integer> checked = new ArrayList<>();
        int acc = 0;

        for (int i = 0; i <= input.size(); i++) {
            if(i == input.size()) {
                System.out.println(acc);
            } else{
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
                    return false;
                }
            }
        }
        return true;
    }
}
