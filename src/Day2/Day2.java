import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

package Day2;

public class Day2 {
    public static void main(String args[]) throws FileNotFoundException {
        String[] array = new String[1000];

        URL url = One.class.getResource("input2.1");
        File text = new File(url.getPath());

        Scanner scanner = new Scanner(text);
        int i = 0;
        while (scanner.hasNextLine()) {
            array[i++] = scanner.nextLine();
        }


    }

}
