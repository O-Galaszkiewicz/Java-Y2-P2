package coursework;

// Superbowl Class
public class Coursework2a {

    // Data
    private final int year;
    private final String date;
    private final String superbowlNumber;
    private final String winningTeam;
    private final int winningPoints;
    private final String losingTeam;
    private final int losingPoints;
    private final String mvp;
    private final String stadium;
    private final String city;
    private final String state;

    // Constructor
    public Coursework2a(int year, String date, String superbowlNumber,
            String winningTeam, int winningPoints, String losingTeam,
            int losingPoints, String mvp, String stadium, String city,
            String state) {
        this.year = year;
        this.date = date;
        this.superbowlNumber = superbowlNumber;
        this.winningTeam = winningTeam;
        this.winningPoints = winningPoints;
        this.losingTeam = losingTeam;
        this.losingPoints = losingPoints;
        this.mvp = mvp;
        this.stadium = stadium;
        this.city = city;
        this.state = state;
    }

    // toString
    @Override
    public String toString() {
        return "Coursework2a{" + "year=" + year + ", date=" + date
                + ", superbowlNumber=" + superbowlNumber + ", winningTeam="
                + winningTeam + ", winningPoints=" + winningPoints
                + ", losingTeam=" + losingTeam + ", losingPoints="
                + losingPoints + ", mvp=" + mvp + ", stadium=" + stadium
                + ", city=" + city + ", state=" + state + '}';
    }

    // main
    public static void main(String[] args) {
        menu();
    }
    /* Console-based Menu:
    Menu should have:
    
    List option - User enters range of years (start -> end)
    to list details
    
    Select option - Details of a given year
    
    Search option - New menu to allow users to inspect specific data and
    their occurences by team or state
    
    Exit option - Closes the program
     */
    public static void menu() {
        String menuStartSplit =     "╔═════════════════════════════════════════╗%n";
        String menuMiddleSplit =    "╠═════════════════════════════════════════╣%n";
        String menuEndSplit =       "╚═════════════════════════════════════════╝%n";
        String menuSuperbowl =      "║        NFL Superbowls Menu        ║%n";
        String menuList =           "║ List .......................... 1 ║%n";
        String menuSelect =         "║ Select ........................ 2 ║%n";
        String menuSearch =         "║ Search ........................ 3 ║%n";
        String menuExit =           "║ Exit .......................... 0 ║%n";
        String menuChoice =         "Enter choice: ";
           //═╚╝╠╣║╔╗
        System.out.printf(menuStartSplit);
        System.out.printf(menuSuperbowl);
        System.out.printf(menuMiddleSplit);
        System.out.printf(menuList);
        System.out.printf(menuSelect);
        System.out.printf(menuSearch);
        System.out.printf(menuExit);
        System.out.printf(menuEndSplit);
        System.out.printf(menuChoice);
    }

    /* Get file data from the txt file
    Store the data in a 2d array: 
    1st dimension for each line of data in the txt file
    2nd dimension to store each field of data (its all already sorted right)
    in their respected indices:
        Year [0]
        Date [1]
        Superbowl Number [2]
        Winning Team [3]
        Winning Points [4]
        Losing Team [5]
        Losing Points [6]
        MVP [7]
        Stadium [8]
        City [9]
        State [10]
    
    Ranges of the dimensions are:
        1st = Number of txt file rows (~1000)
        2nd = 11 (0 -> 10)
     */
 /* List:
    Should return data under one menu as such for each column:
        Year
        Superbowl Number
        Champions
        Runner-ups
    
    Total number of:
        Rows = 2
        Columns = 4
     */
 /* Select:
    Returns the details of a given year as such for each row:
        Superbowl Number
        Stadium
        Who beat who (Winner beat Loser)
        MVP
    
    Total number of:
        Rows = 4
        Columns = 1
     */
 /* Search:
    New menu to show three new options:
        Team
        State
        Main Menu
     */
 /* Team:
    Return team related details as such for each column:
            Team
            Appearances
            Details (Year, Superbowl Number, Winner/Loser)
    
    Total number of:
        Rows = 2
        Columns = 3
     */
 /* State:
    Return state related details as such for each column:
            State
            Superbowl Number
            City & Stadium
    
    Total number of:
        Rows = 2
        Columns = 3
     */
 /* Main Menu:
    Returns to previous menu
     */
 /* Exit:
    Closes the program using exit code 0
     */
}
