package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;



public class Day2 {
    public static void main(String args[]) throws FileNotFoundException {
        String[] inputText = new String[1000];

        File text = new File("C:\\Users\\malte\\AdventOfCode\\src\\Day2\\input2.1");

        Scanner scanner = new Scanner(text);
        int i = 0;
        while (scanner.hasNextLine()) {
            inputText[i++] = scanner.nextLine();
        }

        String tempString = null;
        String[] arrayNoSpaces = new String[inputText.length];

        int valid = 0;
        int newValid = 0;

        for(int j = 0; j < inputText.length; j++){
            int count = 0;
            tempString = inputText[j];

            char c = getTheLetter(tempString);
            arrayNoSpaces[0] = deleteSpacesFromString(tempString);
            int[] numberRange = getNumbers(arrayNoSpaces);
            String[] letters = getLetters(arrayNoSpaces);

            for(int k = 0; k < letters[0].length(); k++){
                if(letters[0].charAt(k) == c){
                    count++;
                }
            }
            if(numberRange[0] <= count && numberRange[1] >= count){
                valid++;
            }

            int index1 = numberRange[0] - 1;
            int index2 = numberRange[1] - 1;


            if((letters[0].charAt(index1) == c  && letters[0].charAt(index2) != c) || (letters[0]. charAt(index1) != c && letters[0].charAt(index2) == c)){
                newValid++;
            }



        }
        System.out.println("Number of Valid passwords in part 1 are: " + valid);
        System.out.println("Number of Valid passwords in part 2 are: " + newValid);
    }

    public static String deleteSpacesFromString(String temp){
        String noSpaces = temp.replaceAll("\\s","");
        return noSpaces;
    }

    public static int[] getNumbers(String[] array){
        int[] numberRange = new int[2];
        String workingString = array[0];
        String [] firstSplittedString = workingString.split("-");
        numberRange[0] = Integer.parseInt(firstSplittedString[0]);

        String [] secondSplittedRing = firstSplittedString[1].split(":");

        if(secondSplittedRing[0].length() == 3){
            numberRange[1] = Integer.parseInt(secondSplittedRing[0].substring(0,2));
        }else{
            numberRange[1] = Integer.parseInt(secondSplittedRing[0].substring(0,1));
        }
        return numberRange;
    }

    public static String[] getLetters(String[] array){
        String[] letters = new String[1];
        String workingString = array[0];
        String [] splittedString = workingString.split(":");
        letters[0] = splittedString[1];
        return letters;
    }

    public static char getTheLetter(String st){
        char c;
        String tempArray[] = st.split(" ");
        c = tempArray[1].charAt(0);
        return c;
    }
}
