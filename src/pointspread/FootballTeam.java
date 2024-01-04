package pointspread;

/**
 *
 * @author jcb
 */
public class FootballTeam {
    private String teamName;
    private double passYardsFor;
    private double passYardsAgainst;
    private double rushYardsFor;
    private double rushYardsAgainst;
    private int totalPointsFor;
    private int totalPointsAgainst;
    private int turnoversCommitted;
    private int turnoversCaused;  
    private int gamesPlayed;  
    

    public FootballTeam() {
        this("", 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public FootballTeam(String teamName, double passYardsFor, 
                        double passYardsAgainst, double rushYardsFor,
                        double rushYardsAgainst, int totalPointsFor,
                        int totalPointsAgainst, int turnoversCommitted, 
                        int turnoversCaused, int gamesPlayed) {
        this.teamName = teamName;
        this.passYardsFor = passYardsFor;
        this.passYardsAgainst = passYardsAgainst;
        this.rushYardsFor = rushYardsFor;
        this.rushYardsAgainst = rushYardsAgainst;
        this.totalPointsFor = totalPointsFor;
        this.totalPointsAgainst = totalPointsAgainst;
        this.turnoversCommitted = turnoversCommitted;
        this.turnoversCaused = turnoversCaused;
        this.gamesPlayed = gamesPlayed;
    }

    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * @return the passYardsFor
     */
    public double getPassYardsFor() {
        return passYardsFor;
    }

    /**
     * @param passYardsFor the passYardsFor to set
     */
    public void setPassYardsFor(double passYardsFor) {
        this.passYardsFor = passYardsFor;
    }

    /**
     * @return the passYardsAgainst
     */
    public double getPassYardsAgainst() {
        return passYardsAgainst;
    }

    /**
     * @param passYardsAgainst the passYardsAgainst to set
     */
    public void setPassYardsAgainst(double passYardsAgainst) {
        this.passYardsAgainst = passYardsAgainst;
    }

    /**
     * @return the rushYardsFor
     */
    public double getRushYardsFor() {
        return rushYardsFor;
    }

    /**
     * @param rushYardsFor the rushYardsFor to set
     */
    public void setRushYardsFor(double rushYardsFor) {
        this.rushYardsFor = rushYardsFor;
    }

    /**
     * @return the rushYardsAgainst
     */
    public double getRushYardsAgainst() {
        return rushYardsAgainst;
    }

    /**
     * @param rushYardsAgainst the rushYardsAgainst to set
     */
    public void setRushYardsAgainst(double rushYardsAgainst) {
        this.rushYardsAgainst = rushYardsAgainst;
    }

    /**
     * @return the totalPointsFor
     */
    public int getTotalPointsFor() {
        return totalPointsFor;
    }

    /**
     * @param totalPointsFor the totalPointsFor to set
     */
    public void setTotalPointsFor(int totalPointsFor) {
        this.totalPointsFor = totalPointsFor;
    }

    /**
     * @return the totalPointsAgainst
     */
    public int getTotalPointsAgainst() {
        return totalPointsAgainst;
    }

    /**
     * @param totalPointsAgainst the totalPointsAgainst to set
     */
    public void setTotalPointsAgainst(int totalPointsAgainst) {
        this.totalPointsAgainst = totalPointsAgainst;
    }

    /**
     * @return turnoversCaused
     */
    public int getTurnoversCaused() {
        return turnoversCaused;
    }

    /**
     * @param turnoversCaused
     */
    public void setTurnoversCaused(int turnoversCaused) {
        this.turnoversCaused = turnoversCaused;
    }

    /**
     * @return getTurnoversCommitted
     */
    public int getTurnoversCommitted() {
        return turnoversCommitted;
    }

    /**
     * @param turnoversCommitted
     */
    public void setTurnoversCommitted(int turnoversCommitted) {
        this.turnoversCommitted = turnoversCommitted;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

}
