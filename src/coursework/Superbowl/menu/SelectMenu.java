package coursework.Superbowl.menu;

import coursework.Superbowl.data.ReadFile;

public class SelectMenu {

        public void printSelectMenu(int year) {
                ReadFile rF = new ReadFile();

                String strYear = String.valueOf(year);

                String superbowlNumber = rF.superbowlDataByYear(strYear, 2);
                String stadium = rF.superbowlDataByYear(strYear, 9);
                String state = rF.superbowlDataByYear(strYear, 10);
                String winningTeam = rF.superbowlDataByYear(strYear, 3);
                String winningPoints = rF.superbowlDataByYear(strYear, 4);
                String losingTeam = rF.superbowlDataByYear(strYear, 5);
                String losingPoints = rF.superbowlDataByYear(strYear, 6);
                String mvp = rF.superbowlDataByYear(strYear, 7);

                if (superbowlNumber != "X") {

                        StringFormat sF = new StringFormat();

                        int maxLength = sF.calculateMaxLength(
                                        "Superbowl " + superbowlNumber,
                                        "Venue: " + stadium + ", " + state,
                                        winningTeam + " (" + winningPoints + ") beat " + losingTeam + " ("
                                                        + losingPoints + ")",
                                        mvp + " was the MVP of the Game");

                        String menuSplit = sF.generateMenuSplit(maxLength);

                        System.out.println(menuSplit);
                        System.out.printf("| %s |%n", sF.formatWithPadding(
                                        "Superbowl " + superbowlNumber, maxLength));
                        System.out.printf("| %s |%n", sF.formatWithPadding(
                                        "Venue: " + stadium + ", " + state, maxLength));
                        System.out.printf("| %s |%n", sF.formatWithPadding(
                                        winningTeam + " (" + winningPoints + ") beat " + losingTeam + " ("
                                                        + losingPoints + ")",
                                        maxLength));
                        System.out.printf("| %s |%n", sF.formatWithPadding(
                                        mvp + " was the MVP of the Game", maxLength));
                        System.out.println(menuSplit);
                        System.out.println();

                } else {

                        System.out.println("Invalid input.");

                }

        }

}