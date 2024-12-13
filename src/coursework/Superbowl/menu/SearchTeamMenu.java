package coursework.Superbowl.menu;

import coursework.Superbowl.data.ReadFile;

public class SearchTeamMenu {

    public void searchByTeam(String teamToSearch) {
        StringFormat sF = new StringFormat();
        ReadFile rF = new ReadFile();

        // Define table header strings
        String tableTeamString = "Team";
        String tableAppearancesString = "Appearances";
        String tableDetailsString = "Details";

        // Initialize column widths
        int teamColumnWidth = tableTeamString.length();
        int appearancesColumnWidth = tableAppearancesString.length();
        int detailsColumnWidth = tableDetailsString.length();

        // Get all game details for the given team
        String[] teamGames = rF.superbowlDataByTeam(teamToSearch);

        // If no games found, return immediately
        if (teamGames.length == 1 && teamGames[0].startsWith("No games found")) {
            System.out.println(teamGames[0]);
            return;
        }

        // Calculate the max width for the columns based on the data
        for (String game : teamGames) {
            String[] gameDetails = game.split(",");
            String yearInfo = gameDetails[0];  // Extract the year part
            String winnerOrRunnerUp = gameDetails[1];  // Winner/Runner-up part

            // Adjust column widths based on the details
            teamColumnWidth = Math.max(teamColumnWidth, teamToSearch.length());
            appearancesColumnWidth = Math.max(appearancesColumnWidth, "1".length()); // The appearance count is always 1 here
            detailsColumnWidth = Math.max(detailsColumnWidth, yearInfo.length() + winnerOrRunnerUp.length() + 3); // Adjust for spacing
        }

        // Add padding for aesthetics (extra 2 spaces for padding)
        teamColumnWidth += 2;
        appearancesColumnWidth += 2;
        detailsColumnWidth += 2;

        // Create a table split line dynamically
        String menuSplit = "+" +
                "-".repeat(teamColumnWidth) + "+" +
                "-".repeat(appearancesColumnWidth) + "+" +
                "-".repeat(detailsColumnWidth) + "+";

        // Print table header
        System.out.println(menuSplit);
        System.out.printf("| %s | %s | %s |%n",
                sF.formatWithPadding(tableTeamString, teamColumnWidth - 2),
                sF.formatWithPadding(tableAppearancesString, appearancesColumnWidth - 2),
                sF.formatWithPadding(tableDetailsString, detailsColumnWidth - 2));
        System.out.println(menuSplit);

        // Variable to track if we have already printed the team name
        boolean teamPrinted = false;

        // Print table rows for the given team
        for (String game : teamGames) {
            String[] gameDetails = game.split(",");
            String yearInfo = gameDetails[0];  // Extract the year part
            String winnerOrRunnerUp = gameDetails[1];  // Winner/Runner-up part

            // Print the first row with team, appearances, and details
            if (!teamPrinted) {
                System.out.printf("| %s | %s | %s |%n",
                        sF.formatWithPadding(teamToSearch, teamColumnWidth - 2),
                        sF.formatWithPadding("1", appearancesColumnWidth - 2),  // Show 1 appearance
                        sF.formatWithPadding(yearInfo + ", " + winnerOrRunnerUp, detailsColumnWidth - 2));
                teamPrinted = true;
            } else {
                // For subsequent rows, only print appearances and details, leaving
                // team empty
                System.out.printf("| %s | %s | %s |%n",
                        sF.formatWithPadding("", teamColumnWidth - 2), // Empty team field
                        sF.formatWithPadding("1", appearancesColumnWidth - 2), // Always 1 appearance
                        sF.formatWithPadding(yearInfo + ", " + winnerOrRunnerUp, detailsColumnWidth - 2));
            }
        }

        // Print final table split
        System.out.println(menuSplit);
        System.out.println();
    }
}