package coursework.Superbowl;

import coursework.Superbowl.data.ReadFile;
import coursework.Superbowl.menu.Menu;

public class Superbowl {

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

    public Superbowl(
            int year,
            String date,
            String superbowlNumber,
            String winningTeam,
            int winningPoints,
            String losingTeam,
            int losingPoints,
            String mvp,
            String stadium,
            String city,
            String state
    ) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Superbowl{");
        sb.append("year=").append(year);
        sb.append(", date=").append(date);
        sb.append(", superbowlNumber=").append(superbowlNumber);
        sb.append(", winningTeam=").append(winningTeam);
        sb.append(", winningPoints=").append(winningPoints);
        sb.append(", losingTeam=").append(losingTeam);
        sb.append(", losingPoints=").append(losingPoints);
        sb.append(", mvp=").append(mvp);
        sb.append(", stadium=").append(stadium);
        sb.append(", city=").append(city);
        sb.append(", state=").append(state);
        sb.append('}');
        return sb.toString();
    }

}
