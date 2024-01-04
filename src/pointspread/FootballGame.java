package pointspread;

 public class FootballGame {

    private FootballTeam home;
    private FootballTeam away;
    private int homeScore;
    private int awayScore;
    private double homePassYds;
    private double awayPassYds;
    private double homeRushYds;
    private double awayRushYds;
    private int homeTrnOvr;
    private int awayTrnOvr;
   
    public FootballGame(FootballTeam home, FootballTeam away) {
        this.home = home;
        this.away = away;
    }

    public FootballGame(FootballTeam home, FootballTeam away, int homeScore, int awayScore, double homePassYds,
            double awayPassYds, double homeRushYds, double awayRushYds, int homeTrnOvr, int awayTrnOvr) {
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

    public FootballTeam getHome() {
        return home;
    }
    public void setHome(FootballTeam home) {
        this.home = home;
    }
    public FootballTeam getAway() {
        return away;
    }
    public void setAway(FootballTeam away) {
        this.away = away;
    }
    public int getHomeScore() {
        return homeScore;
    }
    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }
    public int getAwayScore() {
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
    public int getHomeTrnOvr() {
        return homeTrnOvr;
    }
    public void setHomeTrnOvr(int homeTrnOvr) {
        this.homeTrnOvr = homeTrnOvr;
    }
    public int getAwayTrnOvr() {
        return awayTrnOvr;
    }
    public void setAwayTrnOvr(int awayTrnOvr) {
        this.awayTrnOvr = awayTrnOvr;
    }
   
}
