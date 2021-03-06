import java.util.ArrayList;

public class Main {

    public final static String input = "1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,10,19,1,19,5,23,2,23,9,27,1,5,27,31,1,9,31,35,1,35,10,39,2,13,39,43,1,43,9,47,1,47,9,51,1,6,51,55,1,13,55,59,1,59,13,63,1,13,63,67,1,6,67,71,1,71,13,75,2,10,75,79,1,13,79,83,1,83,10,87,2,9,87,91,1,6,91,95,1,9,95,99,2,99,10,103,1,103,5,107,2,6,107,111,1,111,6,115,1,9,115,119,1,9,119,123,2,10,123,127,1,127,5,131,2,6,131,135,1,135,5,139,1,9,139,143,2,143,13,147,1,9,147,151,1,151,2,155,1,9,155,0,99,2,0,14,0";


    public static void main(String[] args) {

        ArrayList<Integer> formattedInput;
        for (int j = 0; j < 100; j++) {
            for (int k = 0; k < 100; k++) {
                formattedInput = splitInput(input);
                formattedInput.set(1,j);
                formattedInput.set(2,k);
                int i = 0;
                while (i <= formattedInput.size()) {
                    if(formattedInput.get(i)==99){
                        break;
                    }
                    else if(formattedInput.get(i) == 1){
                        int result = formattedInput.get(formattedInput.get((i+1))) + formattedInput.get(formattedInput.get((i+2)));
                        formattedInput.set(formattedInput.get((i+3)),result);
                        i+=4;

                    }
                    else if(formattedInput.get(i) == 2){
                        int result = formattedInput.get(formattedInput.get((i+1))) * formattedInput.get(formattedInput.get((i+2)));
                        formattedInput.set(formattedInput.get((i+3)),result);
                        i+=4;
                    }
                    else{
                        i++;
                    }
                }
                if(formattedInput.get(0)==19690720){
                    j=100;
                    k=100;
                    System.out.println(100 * formattedInput.get(1)+formattedInput.get(2));
                }
            }
        }


    }

    private static ArrayList<Integer> splitInput(String input){
        ArrayList<Integer> ret = new ArrayList<>();
        String[] tmp = input.split(",");
        for (String s : tmp) {
            ret.add(Integer.parseInt(s));
        }
        return ret;
    }
}
