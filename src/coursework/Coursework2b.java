package coursework;

// Cruiseship Stuff
public class Coursework2b {
    
}

/* Class Model:
Port <- isTo - Excursion
Excursion <- offers - Cruise
Excursion <- joins - Passenger
Cruise <- isOn - Passenger
Cruise <- uses - Ship
Passenger <- residesIn - Cabin
Ship <- has - Cabin
Cabin <-- Suite
Cabin <-- StandardCabin
*/

/* System domain:
A small cruise company has ten ships which operate one-week Mediterranean 
cruises over the Summer.

Each cruise uses a single ship, and every ship has a unique name. Each ship has
two different kinds of cabins:
    Suites (each of which can accommodate up to four passengers and may or may
    not have a balcony), and Standard cabins (each of which can accommodate up
    to six passengers and may or may not have a sea view).

Each cabin has a unique number to identify it.

For any given week, each cruise offers day-long excursions to a Mediterranean 
port on three days of that week.

Each excursion on a particular cruise is on a different day and to a different 
port, but a port can be used for excursions by several different cruises.

Each excursion has a limit on the number of passengers from that cruise who may
join it.

For each excursion, the passengers on the cruise may opt to join the excursion
(so long as the excursion’s limit is not exceeded).
*/

/* Use cases:
1 - Display Cruise Information:
The User identifies a cruise by selecting from a list of cruise ship names that
are presented to the User. The console displays each ship name alongside an
integer index such that the User enters the integer index value to make the
selection. After the User has selected a cruise ship, the system displays the
name of the ship, the number of passengers registered on the cruise, along with
the excursions for that cruise. For each excursion, the system displays the
excursion destination port, the day of the week of that excursion, and the
number of spaces that are still available on that excursion or indicates if the
excursion is fully booked. The program then returns to the main menu.

2 - Display Excursion Information:
The User identifies a cruise by selecting from a list of cruise ship names that
are presented to the User. The console displays each ship name alongside an
integer index such that the User enters the integer index value to make the
selection. After the User has selected a cruise ship, the system lists the
three excursions available for that cruise for the week by displaying the name
of the port alongside an integer index for User selection. On selection of one
of the listed excursions, the system displays the day of the week of the
excursion and lists all passengers currently booked on that excursion in
alphabetical order by name. The program then returns to the main menu.

3 - Display Passenger Information:
The User identifies a cruise by selecting from a list of cruise ship names that
are presented to the User. The console displays each ship name alongside an
integer index such that the User enters the integer index value to make the
selection. After the User has selected a cruise ship, the system lists all
passengers on that cruise by displaying their name (in alphabetical order)
alongside an integer index for User selection. On selection of one of the
listed passengers, the system displays the name of the passenger, the cabin
number and type which they are residing in for the cruise, a list of any other
passengers they are sharing the cabin with (in alphabetical order) or indicates
if they are not sharing their cabin, and a list of any excursions booked for
that passenger (or an appropriate message if they are not currently booked on
an excursion). The program then returns to the main menu.

4 - Book Excursion:
The User identifies a cruise by selecting from a list of cruise ship names that
are presented to the User. The console displays each ship name alongside an
integer index such that the User enters the integer index value to make the
selection. After the User has selected a cruise ship, the system lists all
passengers on that cruise by displaying their name (in alphabetical order)
alongside an integer index for User selection. On selection of one of the
listed passengers, the system lists the excursions available to that passenger 
(i.e., not already booked), indicating the name of the excursion port, the day
of the week the excursion takes place, and how many spaces are available for
that excursion. The User is prompted to either select one of the excursions 
which has availability or cancel (making the booking). If an excursion was 
selected the booking is recorded and an appropriate message is displayed to
confirm the booking. The program then returns to the main menu.

5 - Change Passenger Cabin:
The User identifies a cruise by selecting from a list of cruise ship names that
are presented to the User. The console displays each ship name alongside an
integer index such that the User enters the integer index value to make the
selection. After the User has selected a cruise ship, the system lists all
cabins that are currently vacant (i.e., have no assigned passengers) for that
cruise. If there are none available and appropriate message is displayed and
the program returns to the main menu. If there are vacant cabins available, the
User is prompted to continue to change a passenger cabin or cancel. On choosing
to continue, the User is prompted to select a passenger on that cruise and
specify which of the vacant cabins to transfer them to. The system records the
change for the selected passenger and all other passengers that are sharing a
cabin with that passenger. The program then returns to the main menu.
*/
