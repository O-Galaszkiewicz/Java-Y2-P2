package coursework.Superbowl.menu;

public class SuperbowlsMenu {

    public void superbowlMenu() {

        StringFormat sF = new StringFormat();

        String superbowlMenu = "NFL Superbowls Menu";
        String listString = "List ............. 1";
        String selectString = "Select ........... 2";
        String searchString = "Search ........... 3";
        String menuExitString = "Exit ............. 0";

        int maxLength = sF.calculateMaxLength(
                superbowlMenu,
                listString,
                selectString,
                searchString,
                menuExitString);

        String menuSplit = sF.generateMenuSplit(maxLength);

        System.out.println(menuSplit);
        System.out.printf("| %s |%n", sF.formatWithPadding(superbowlMenu, maxLength));
        System.out.println(menuSplit);
        System.out.printf("| %s |%n", sF.formatWithPadding(listString, maxLength));
        System.out.printf("| %s |%n", sF.formatWithPadding(selectString, maxLength));
        System.out.printf("| %s |%n", sF.formatWithPadding(searchString, maxLength));
        System.out.printf("| %s |%n", sF.formatWithPadding(menuExitString, maxLength));
        System.out.println(menuSplit);
        System.out.print("Enter Choice: ");

    }

}
