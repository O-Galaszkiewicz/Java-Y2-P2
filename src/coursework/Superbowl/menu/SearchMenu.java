package coursework.Superbowl.menu;

public class SearchMenu {

    public void searchMenu() {

        StringFormat sF = new StringFormat();

        String searchMenu = "Search Superbowls by";
        String teamString = "Team ............. 1";
        String stateString = "State ............ 2";
        String mainMenuString = "Main Menu ........ 0";

        int maxLength = sF.calculateMaxLength(
                searchMenu,
                teamString,
                stateString,
                mainMenuString);

        String menuSplit = sF.generateMenuSplit(maxLength);

        System.out.println(menuSplit);
        System.out.printf("| %s |%n", sF.formatWithPadding(searchMenu, maxLength));
        System.out.println(menuSplit);
        System.out.printf("| %s |%n", sF.formatWithPadding(teamString, maxLength));
        System.out.printf("| %s |%n", sF.formatWithPadding(stateString, maxLength));
        System.out.printf("| %s |%n", sF.formatWithPadding(mainMenuString, maxLength));
        System.out.println(menuSplit);
        System.out.print("Enter Choice: ");

    }

}