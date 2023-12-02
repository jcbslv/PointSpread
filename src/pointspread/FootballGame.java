package pointspread;

public class FootballGame {
    private FootballTeam home;
    private FootballTeam away;
    private double audienceExcitementLevel;

    public FootballGame() {
        this(null, null, 0);
    }

    public FootballGame(FootballTeam home, FootballTeam away, double audienceExcitementLevel) {
        this.home = home;
        this.away = away;
        this.audienceExcitementLevel = audienceExcitementLevel;
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

    public double getAudienceExcitementLevel() {
        return audienceExcitementLevel;
    }

    public void setAudienceExcitementLevel(double audienceExcitementLevel) {
        this.audienceExcitementLevel = audienceExcitementLevel;
    }
    
}
