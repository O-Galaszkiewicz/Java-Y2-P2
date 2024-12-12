package coursework.Superbowl.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Main file handler
public class ReadFile {

    private void load() throws FileNotFoundException {

        String fPath = System.getProperty("user.dir")
                + File.separator + "superbowls.txt";

        File fObj = new File(fPath);

        Scanner input = null;

        try {

            input = new Scanner(fObj);

            int idx = 0;

            /*
             * Read the contents of the superbowls.txt file,
             * and split them into:
             * 
             * The array should be [x][y] where:
             * x is how many lines of data there is in the superbowls.txt file
             * y is the data in each of the lines
             * 
             * Data Structure:
             * year = integer
             * date = string
             * superbowlNumber = string
             * winningTeam = string
             * winningPoints = integer
             * losingTeam = string
             * losingPoints = integer
             * mvp = string
             * stadium = string
             * city = string
             * state = string
             * 
             * Example Data (all in one text file line):
             * 1967(Jan 15)|I|Green Bay Packers|35|Kansas City Chiefs|10|Bart Starr|Memorial
             * Coliseum|Los Angeles|California
             * 
             * Main text is split with "|" but to get the date you would have to split "("
             * and ")" from the first piece
             * 
             * How the array is supposed to store it
             * For year: example_array[0] = 1967
             * For date: example_array[1] = Jan 15
             * For superbowlNumber: example_array[2] = I
             * For winningTeam: example_array[3] = Green Bay Packers
             * For winning points: example_array[4] = 35
             * For losingTeam: example_array[5] = Kansas City Chiefs
             * For losingPoints: example_array[6] = 10
             * For mvp: example_array[7] = Bart Starr
             * For stadium: example_array[8] = Memorial Coliseum
             * For city: example_array[9] = Los Angeles
             * For state: example_array[10] = California
             * 
             * Would have to convert the data from a string into their actual data type
             * 
             */

        } catch (FileNotFoundException e) {
            System.out.println("File could not be found, sorry!");
            System.exit(0);
        }
    }

}
