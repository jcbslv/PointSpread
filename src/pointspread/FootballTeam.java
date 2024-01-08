package pointspread;

import java.text.NumberFormat;

/**
 *
 * @author jcb
 */
public class FootballTeam {
    private String teamName;
    private double totalPointsFor;
    private double totalPointsAgainst;
    private double passYardsFor;
    private double passYardsAgainst;
    private double rushYardsFor;
    private double rushYardsAgainst;
    private double turnoversCommitted;
    private double turnoversCaused;  
    private int gamesPlayed;  
    

    public FootballTeam() {
        this("", 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public FootballTeam(String teamName, double totalPointsFor,
                        double totalPointsAgainst, double passYardsFor, 
                        double passYardsAgainst, double rushYardsFor,
                        double rushYardsAgainst, double turnoversCommitted, 
                        double turnoversCaused, int gamesPlayed) {
        this.teamName = teamName;
        this.totalPointsFor = totalPointsFor;
        this.totalPointsAgainst = totalPointsAgainst;
        this.passYardsFor = passYardsFor;
        this.passYardsAgainst = passYardsAgainst;
        this.rushYardsFor = rushYardsFor;
        this.rushYardsAgainst = rushYardsAgainst;
        this.turnoversCommitted = turnoversCommitted;
        this.turnoversCaused = turnoversCaused;
        this.gamesPlayed = gamesPlayed;
    }

    public String getFormattedNum(double d) {
        NumberFormat num = NumberFormat.getNumberInstance();
        return num.format(d);
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
    public double getTotalPointsFor() {
        return totalPointsFor;
    }

    /**
     * @param d the totalPointsFor to set
     */
    public void setTotalPointsFor(double d) {
        this.totalPointsFor = d;
    }

    /**
     * @return the totalPointsAgainst
     */
    public double getTotalPointsAgainst() {
        return totalPointsAgainst;
    }

    /**
     * @param totalPointsAgainst the totalPointsAgainst to set
     */
    public void setTotalPointsAgainst(double totalPointsAgainst) {
        this.totalPointsAgainst = totalPointsAgainst;
    }

    /**
     * @return turnoversCaused
     */
    public double getTurnoversCaused() {
        return turnoversCaused;
    }

    /**
     * @param turnoversCaused
     */
    public void setTurnoversCaused(double turnoversCaused) {
        this.turnoversCaused = turnoversCaused;
    }

    /**
     * @return getTurnoversCommitted
     */
    public double getTurnoversCommitted() {
        return turnoversCommitted;
    }

    /**
     * @param turnoversCommitted
     */
    public void setTurnoversCommitted(double turnoversCommitted) {
        this.turnoversCommitted = turnoversCommitted;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

}
