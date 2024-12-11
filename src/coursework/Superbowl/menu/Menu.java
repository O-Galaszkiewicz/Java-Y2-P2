package coursework.Superbowl.menu;

// Main menu loading class
public class Menu {

    static String menuStartSplit = "+-----------------------------------+%n";
    static String menuMiddleSplit = "+-----------------------------------+%n";
    static String menuEndSplit = "+-----------------------------------+%n";
    
    static String menuSearch = "|              Search               |%n";
    static String menuSuperbowl = "|        NFL Superbowls Menu        |%n";
    
    static String list = "| List .......................... 1 |%n";
    static String select = "| Select ........................ 2 |%n";
    static String search = "| Search ........................ 3 |%n";
    static String menuExit = "| Exit .......................... 0 |%n";
    static String team = "| Team ............................ |%n";
    static String state = "| State ........................... |%n";
    static String mainMenu = "| Main Menu ....................... |%n";
    
    static String menuChoice = "Enter choice: ";

    public static void superbowlMenu() {
        System.out.printf(menuStartSplit);
        System.out.printf(menuSuperbowl);
        System.out.printf(menuMiddleSplit);
        System.out.printf(list);
        System.out.printf(select);
        System.out.printf(search);
        System.out.printf(menuExit);
        System.out.printf(menuEndSplit);
        System.out.printf(menuChoice);
    }
    
    public static void searchMenu() {
        System.out.printf(menuStartSplit);
        System.out.printf(menuSearch);
        System.out.printf(menuMiddleSplit);
        System.out.printf(team);
        System.out.printf(state);
        System.out.printf(mainMenu);
        System.out.printf(menuEndSplit);
        System.out.printf(menuChoice);
    }

}