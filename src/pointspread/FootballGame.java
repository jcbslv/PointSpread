package pointspread;

import java.text.NumberFormat;

public class FootballGame {

    private String home;
    private String away;
    private double homeScore;
    private double awayScore;
    private double homePassYds;
    private double awayPassYds;
    private double homeRushYds;
    private double awayRushYds;
    private double homeTrnOvr;
    private double awayTrnOvr;
    
    
    public FootballGame(String home, String away) {
        this.home = home;
        this.away = away;
    }

    public FootballGame(String home, String away, double homeScore, double awayScore, double homePassYds,
            double awayPassYds, double homeRushYds, double awayRushYds, double homeTrnOvr, double awayTrnOvr) {
        this.home = home;
        this.away = away;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.homePassYds = homePassYds;
        this.awayPassYds = awayPassYds;
        this.homeRushYds = homeRushYds;
        this.awayRushYds = awayRushYds;
        this.homeTrnOvr = homeTrnOvr;
        this.awayTrnOvr = awayTrnOvr;
    }

    public String getFormattedNum(double d) {
        NumberFormat num = NumberFormat.getNumberInstance();
        return num.format(d);
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public double getHomeScore() {
        return homeScore;
    }
    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }
    public double getAwayScore() {
        return awayScore;
    }
    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }
    public double getHomePassYds() {
        return homePassYds;
    }
    public void setHomePassYds(double homePassYds) {
        this.homePassYds = homePassYds;
    }
    public double getAwayPassYds() {
        return awayPassYds;
    }
    public void setAwayPassYds(double awayPassYds) {
        this.awayPassYds = awayPassYds;
    }
    public double getHomeRushYds() {
        return homeRushYds;
    }
    public void setHomeRushYds(double homeRushYds) {
        this.homeRushYds = homeRushYds;
    }
    public double getAwayRushYds() {
        return awayRushYds;
    }
    public void setAwayRushYds(double awayRushYds) {
        this.awayRushYds = awayRushYds;
    }
    public double getHomeTrnOvr() {
        return homeTrnOvr;
    }
    public void setHomeTrnOvr(int homeTrnOvr) {
        this.homeTrnOvr = homeTrnOvr;
    }
    public double getAwayTrnOvr() {
        return awayTrnOvr;
    }
    public void setAwayTrnOvr(int awayTrnOvr) {
        this.awayTrnOvr = awayTrnOvr;
    }
   
}
