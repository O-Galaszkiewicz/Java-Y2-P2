package coursework.Superbowl;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import coursework.Superbowl.menu.ListMenu;
import coursework.Superbowl.menu.SearchMenu;
import coursework.Superbowl.menu.SearchStateMenu;
import coursework.Superbowl.menu.SearchTeamMenu;
import coursework.Superbowl.menu.SelectMenu;
import coursework.Superbowl.menu.SuperbowlsMenu;

public class Superbowl {

    public static void main(String[] args) throws FileNotFoundException {
        SuperbowlsMenu superbowlsMenu = new SuperbowlsMenu();
        try (Scanner input = new Scanner(System.in)) {
            int menuChoice;
            do {
                superbowlsMenu.superbowlMenu(); // Display the menu
                System.out.print("Choose an option: ");

                // Validate if the input is an integer
                while (true) {
                    try {
                        menuChoice = input.nextInt(); // Get the menu choice
                        if (menuChoice >= 0 && menuChoice <= 3) {
                            break; // Valid input
                        } else {
                            System.out.print("Invalid choice. Please select a valid option (0-3):");
                        }
                    } catch (InputMismatchException e) {
                        System.out.print("Invalid input. Please enter a valid option (0-3):");
                        input.next(); // Consume the invalid input
                    }
                }

                System.out.println();
                menuInput(menuChoice, input); // Pass menuChoice to handle user action

            } while (menuChoice != 0); // Loop until the user chooses to quit
        } catch (FileNotFoundException e) {
            System.out.println("Error: The required file could not be found.");
        }
    }

    public static void menuInput(int menuInput, Scanner input) throws FileNotFoundException {
        ListMenu listMenu = new ListMenu();
        SelectMenu selectMenu = new SelectMenu();

        switch (menuInput) {
            case 1:
                // Handle List Menu
                handleListMenu(listMenu, input);
                break;

            case 2:
                // Handle Select Menu
                handleSelectMenu(selectMenu, input);
                break;

            case 3:
                // Handle Search Menu
                handleSearchMenu(input);
                break;

            case 0:
                System.out.println("Closing Program...");
                break;

            default:
                System.out.println("Invalid choice. Please select a valid option.");
                break;
        }
    }

    private static void handleListMenu(ListMenu listMenu, Scanner input) throws FileNotFoundException {
        System.out.print("Enter start year: ");
        int startYear = input.nextInt();
        System.out.print("Enter end year: ");
        int endYear = input.nextInt();
        listMenu.listMenu(startYear, endYear);
    }

    private static void handleSelectMenu(SelectMenu selectMenu, Scanner input) throws FileNotFoundException {
        int year;
        do {
            year = getValidYearFromUser(input); // Get valid year from user input
            selectMenu.printSelectMenu(year);
        } while (year < 1967 || year > 2024); // Repeat if year is out of range
    }

    public static int getValidYearFromUser(Scanner input) {
        int year;
        while (true) {
            System.out.print("Enter championship year (1967-2024): ");
            try {
                year = input.nextInt(); // Try reading an integer year
                if (year >= 1967 && year <= 2024) {
                    return year; // Valid year
                } else {
                    System.out.println("Invalid year. Please enter a year between 1967 and 2024.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid year (1967-2024).");
                input.next(); // Consume the invalid input
            }
        }
    }

    private static void handleSearchMenu(Scanner input) throws FileNotFoundException {
        SearchMenu searchMenu = new SearchMenu();
        SearchStateMenu searchStateMenu = new SearchStateMenu();
        SearchTeamMenu searchTeamMenu = new SearchTeamMenu();
        int searchChoice;

        do {
            searchMenu.searchMenu(); // Display the Search Menu
            System.out.print("Choose a search option (or 0 to go back): ");

            // Validate if the input is an integer
            while (true) {
                try {
                    searchChoice = input.nextInt(); // Get the search choice
                    if (searchChoice >= 0 && searchChoice <= 2) {
                        break; // Valid input
                    } else {
                        System.out.print("Invalid choice. Please select a valid option:");
                    }
                } catch (InputMismatchException e) {
                    System.out.print("Invalid input. Please enter a valid option (0-2): ");
                    input.next(); // Consume the invalid input
                }
            }

            System.out.println();

            // Handle search actions
            switch (searchChoice) {
                case 1:
                    System.out.print("Enter team name: ");
                    clearBuffer(input); // Clear the input buffer
                    String team = input.nextLine(); // Capture the full team name
                    if (team.trim().isEmpty()) {
                        System.out.println("Team name cannot be empty. Please try again.");
                    } else {
                        System.out.println("Searching for team: " + team); // Debug print
                        searchTeamMenu.searchByTeam(team);
                    }
                    break;

                case 2:
                    System.out.print("Enter state name: ");
                    clearBuffer(input); // Clear the input buffer
                    String state = input.nextLine(); // Capture the full state name
                    if (state.trim().isEmpty()) {
                        System.out.println("State name cannot be empty. Please try again.");
                    } else {
                        System.out.println("Searching for state: " + state); // Debug print
                        searchStateMenu.searchByState(state);
                    }
                    break;
            }

        } while (searchChoice != 0); // Loop until the user chooses to go back
    }

    private static void clearBuffer(Scanner input) {
        input.nextLine(); // Consume any leftover newline characters
    }

}