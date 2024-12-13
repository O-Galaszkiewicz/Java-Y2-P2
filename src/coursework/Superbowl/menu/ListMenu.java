package coursework.Superbowl.menu;

import coursework.Superbowl.data.ReadFile;

public class ListMenu {

    public void listMenu(int startYear, int endYear) {
        StringFormat sF = new StringFormat();
        ReadFile rF = new ReadFile();

        // Define table header strings
        String tableYearString = "Year";
        String tableSuperbowlNumberString = "Superbowl No.";
        String tableWinnerString = "Champions";
        String tableRunnerUpString = "Runner-ups";

        // Collect all data first to calculate maximum lengths
        int yearColumnWidth = tableYearString.length();
        int superbowlNumberColumnWidth = tableSuperbowlNumberString.length();
        int winnerColumnWidth = tableWinnerString.length();
        int runnerUpColumnWidth = tableRunnerUpString.length();

        // Fetch the data from the ReadFile object
        for (int year = startYear; year <= endYear; year++) {
            String superbowlNumber = rF.superbowlDataByYear(String.valueOf(year), 2);
            String winningTeam = rF.superbowlDataByYear(String.valueOf(year), 3);
            String losingTeam = rF.superbowlDataByYear(String.valueOf(year), 5);

            // Calculate the maximum column widths dynamically
            superbowlNumberColumnWidth = Math.max(superbowlNumberColumnWidth, superbowlNumber.length());
            winnerColumnWidth = Math.max(winnerColumnWidth, winningTeam.length());
            runnerUpColumnWidth = Math.max(runnerUpColumnWidth, losingTeam.length());
        }

        // Add padding for aesthetics
        yearColumnWidth += 2;
        superbowlNumberColumnWidth += 2;
        winnerColumnWidth += 2;
        runnerUpColumnWidth += 2;

        // Create a table split line dynamically
        String menuSplit = "+" +
                "-".repeat(yearColumnWidth) + "+" +
                "-".repeat(superbowlNumberColumnWidth) + "+" +
                "-".repeat(winnerColumnWidth) + "+" +
                "-".repeat(runnerUpColumnWidth) + "+";

        // Print table header
        System.out.println(menuSplit);
        System.out.printf("| %s | %s | %s | %s |%n",
                sF.formatWithPadding(tableYearString, yearColumnWidth - 2),
                sF.formatWithPadding(tableSuperbowlNumberString, superbowlNumberColumnWidth - 2),
                sF.formatWithPadding(tableWinnerString, winnerColumnWidth - 2),
                sF.formatWithPadding(tableRunnerUpString, runnerUpColumnWidth - 2));
        System.out.println(menuSplit);

        // Print table rows for each year in the given range
        for (int year = startYear; year <= endYear; year++) {
            String superbowlNumber = rF.superbowlDataByYear(String.valueOf(year), 2);
            String winningTeam = rF.superbowlDataByYear(String.valueOf(year), 3);
            String losingTeam = rF.superbowlDataByYear(String.valueOf(year), 5);

            System.out.printf("| %s | %s | %s | %s |%n",
                    sF.formatWithPadding(String.valueOf(year), yearColumnWidth - 2),
                    sF.formatWithPadding(superbowlNumber, superbowlNumberColumnWidth - 2),
                    sF.formatWithPadding(winningTeam, winnerColumnWidth - 2),
                    sF.formatWithPadding(losingTeam, runnerUpColumnWidth - 2));
        }

        // Print final table split
        System.out.println(menuSplit);
        System.out.println();
    }
}
