package coursework.Superbowl.menu;

import coursework.Superbowl.data.ReadFile;

public class SearchStateMenu {

    public void searchByState(String stateToSearch) {
        StringFormat sF = new StringFormat();
        ReadFile rF = new ReadFile();

        // Define table header strings
        String tableStateString = "State";
        String tableSuperbowlString = "Superbowl";
        String tableCityStadiumString = "City & Stadium";

        // Initialize column widths
        int stateColumnWidth = tableStateString.length();
        int superbowlColumnWidth = tableSuperbowlString.length();
        int cityStadiumColumnWidth = tableCityStadiumString.length();

        // Get all game details for the given state
        String[][] stateGames = rF.superbowlDataByState(stateToSearch);

        // If no games found, return immediately
        if (stateGames.length == 1 && stateGames[0][0].startsWith("No games found")) {
            System.out.println(stateGames[0][0]);
            return;
        }

        // Calculate the max width for the columns based on the data
        for (String[] game : stateGames) {
            String superbowlInfo = game[0]; // "Superbowl Number (Year)"
            String cityStadiumInfo = game[1]; // "City, Stadium"

            stateColumnWidth = Math.max(stateColumnWidth, stateToSearch.length());
            superbowlColumnWidth = Math.max(superbowlColumnWidth, superbowlInfo.length());
            cityStadiumColumnWidth = Math.max(cityStadiumColumnWidth, cityStadiumInfo.length());
        }

        // Add padding for aesthetics (extra 2 spaces for padding)
        stateColumnWidth += 2;
        superbowlColumnWidth += 2;
        cityStadiumColumnWidth += 2;

        // Create a table split line dynamically
        String menuSplit = "+" +
                "-".repeat(stateColumnWidth) + "+" +
                "-".repeat(superbowlColumnWidth) + "+" +
                "-".repeat(cityStadiumColumnWidth) + "+";

        // Print table header
        System.out.println(menuSplit);
        System.out.printf("| %s | %s | %s |%n",
                sF.formatWithPadding(tableStateString, stateColumnWidth - 2),
                sF.formatWithPadding(tableSuperbowlString, superbowlColumnWidth - 2),
                sF.formatWithPadding(tableCityStadiumString, cityStadiumColumnWidth - 2));
        System.out.println(menuSplit);

        // Variable to track if we have already printed the state name
        boolean statePrinted = false;

        // Print table rows for the given state
        for (String[] game : stateGames) {
            String superbowlInfo = game[0]; // "Superbowl Number (Year)"
            String cityStadiumInfo = game[1]; // "City, Stadium"

            // Print the first row with state, Super Bowl info, and city/stadium
            if (!statePrinted) {
                System.out.printf("| %s | %s | %s |%n",
                        sF.formatWithPadding(stateToSearch, stateColumnWidth - 2),
                        sF.formatWithPadding(superbowlInfo, superbowlColumnWidth - 2),
                        sF.formatWithPadding(cityStadiumInfo, cityStadiumColumnWidth - 2));
                statePrinted = true;
            } else {
                // For subsequent rows, only print Super Bowl info and city/stadium, leaving
                // state empty
                System.out.printf("| %s | %s | %s |%n",
                        sF.formatWithPadding("", stateColumnWidth - 2), // Empty state field
                        sF.formatWithPadding(superbowlInfo, superbowlColumnWidth - 2),
                        sF.formatWithPadding(cityStadiumInfo, cityStadiumColumnWidth - 2));
            }
        }

        // Print final table split
        System.out.println(menuSplit);
        System.out.println();
    }
}