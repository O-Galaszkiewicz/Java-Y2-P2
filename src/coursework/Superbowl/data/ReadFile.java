package coursework.Superbowl.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    private String[][] superbowlData; // Array to store the Superbowl data

    public ReadFile() {
        superbowlData = new String[58][11]; // Initialize the array
        load(); // Call the load method
    }

    public String[][] getSuperbowlData() {
        return superbowlData;
    }

    private void load() {
        // Define the file path
        String fPath = System.getProperty("user.dir") + File.separator + "superbowls.txt";
        File fObj = new File(fPath);

        try (Scanner sc = new Scanner(fObj)) {
            int index = 0; // Row index for the array

            // Read each line from the file
            while (sc.hasNextLine() && index < superbowlData.length) {
                String line = sc.nextLine().trim(); // Get the line and trim whitespace

                // Split the line into parts using "|"
                String[] parts = line.split("\\|");

                // Separate the year and date
                String[] yearAndDate = parts[0].split("\\(");
                String year = yearAndDate[0].trim();
                String date = yearAndDate[1].replace(")", "").trim();

                // Populate the array with the extracted data
                superbowlData[index][0] = year; // Year
                // System.out.println(superbowlData[index][0]);
                superbowlData[index][1] = date; // Date
                // System.out.println(superbowlData[index][1]);
                superbowlData[index][2] = parts[1].trim(); // Superbowl Number
                // System.out.println(superbowlData[index][2]);
                superbowlData[index][3] = parts[2].trim(); // Winning Team
                // System.out.println(superbowlData[index][3]);
                superbowlData[index][4] = parts[3].trim(); // Winning Points
                // System.out.println(superbowlData[index][4]);
                superbowlData[index][5] = parts[4].trim(); // Losing Team
                // System.out.println(superbowlData[index][5]);
                superbowlData[index][6] = parts[5].trim(); // Losing Points
                // System.out.println(superbowlData[index][6]);
                superbowlData[index][7] = parts[6].trim(); // MVP
                // System.out.println(superbowlData[index][7]);
                superbowlData[index][8] = parts[7].trim(); // Stadium
                // System.out.println(superbowlData[index][8]);
                superbowlData[index][9] = parts[8].trim(); // City
                // System.out.println(superbowlData[index][9]);
                superbowlData[index][10] = parts[9].trim(); // State
                // System.out.println(superbowlData[index][10]);

                index++; // Move to the next row
            }

        } catch (FileNotFoundException e) {
            System.out.println("File could not be found. Exiting.");
            System.exit(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Data in the file is not in the expected format.");
            System.exit(0);
        }
    }

    public String superbowlDataByYear(String year, int index) {
        for (int i = 0; i < superbowlData.length; i++) {
            if (superbowlData[i][0] != null && superbowlData[i][0].equals(year)) {
                return superbowlData[i][index];
            }
        }
        return "X";
    }

    // Method to get details of a team's game at a specific index
    public String getTeamGameDetails(int index, String team) {
        String gameDetails = "";
        
        if (superbowlData[index][3] != null && superbowlData[index][3].equals(team)) { // Winning Team
            gameDetails = superbowlData[index][0] + " (" + superbowlData[index][2] + "), Winner";
        } else if (superbowlData[index][5] != null && superbowlData[index][5].equals(team)) { // Losing Team
            gameDetails = superbowlData[index][0] + " (" + superbowlData[index][2] + "), Runner-up";
        }
        
        return gameDetails;
    }

    // Method to get all game details for a team
    public String[] superbowlDataByTeam(String team) {
        List<String> teamGames = new ArrayList<>();

        for (int i = 0; i < superbowlData.length; i++) {
            String gameDetails = getTeamGameDetails(i, team);
            if (!gameDetails.isEmpty()) {  // If the team has participated in this game
                teamGames.add(gameDetails);
            }
        }

        // If no games found, return a default message
        if (teamGames.isEmpty()) {
            return new String[] {"No games found for " + team};
        }
        
        // Convert the list of game details to a string array and return
        return teamGames.toArray(new String[0]);
    }  

    // Method to print the results of all games by a specific team
    public void printSuperbowlDataByTeam(String team) {
        String[] results = superbowlDataByTeam(team);
        
        for (String result : results) {
            System.out.println(result);  // Print each game result on a new line
        }
    }

    // Method to get details of a state's game at a specific index
    public String getStateGameDetails(int index, String state) {
        String gameDetails = "";
        
        if (superbowlData[index][10] != null && superbowlData[index][10].equals(state)) { // Check if state matches
            // Format the string as "Superbowl Number (Year)|City, Stadium"
            gameDetails = superbowlData[index][2] + " (" + superbowlData[index][0] + ")|" 
                          + superbowlData[index][9] + ", " + superbowlData[index][8];
        }
        
        return gameDetails;
    }

    // Method to get all game details for a state
    public String[][] superbowlDataByState(String state) {
        List<String[]> stateGames = new ArrayList<>();
        
        for (int i = 0; i < superbowlData.length; i++) {
            String gameDetails = getStateGameDetails(i, state);
            if (!gameDetails.isEmpty()) {
                // Split the gameDetails into two parts
                String[] splitDetails = gameDetails.split("\\|");
                stateGames.add(splitDetails);  // Add the split details to the list
            }
        }

        // If no games found, return a default message
        if (stateGames.isEmpty()) {
            return new String[][] {{"No games found in " + state}};
        }

        // Convert the list of game details to a 2D array and return
        return stateGames.toArray(new String[0][0]);
    }

    // Method to print the results of all games in a specific state
    public void printSuperbowlDataByState(String state) {
        String[][] results = superbowlDataByState(state);

        // Print the results in the specified format
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i][0] + results[i][1]);
        }
    }

}
