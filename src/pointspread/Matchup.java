package pointspread;

public class Matchup {
    private FootballTeam home;
    private FootballTeam away;
    
    public Matchup(FootballTeam home, FootballTeam away) {
        this.home = home;
        this.away = away;
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
    
}
