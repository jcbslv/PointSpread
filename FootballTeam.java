/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    private int turnovers;
    
    public FootballTeam() {
        this("", 0, 0, 0, 0, 0, 0, 0);
    }

    public FootballTeam(String teamName, double passYardsFor, 
                        double passYardsAgainst, double rushYardsFor,
                        double rushYardsAgainst, int totalPointsFor,
                        int totalPointsAgainst, int turnovers) {
        this.teamName = teamName;
        this.passYardsFor = passYardsFor;
        this.passYardsAgainst = passYardsAgainst;
        this.rushYardsFor = rushYardsFor;
        this.rushYardsAgainst = rushYardsAgainst;
        this.totalPointsFor = totalPointsFor;
        this.totalPointsAgainst = totalPointsAgainst;
        this.turnovers = turnovers;
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
     * @return the turnovers
     */
    public int getTurnovers() {
        return turnovers;
    }

    /**
     * @param turnovers the turnovers to set
     */
    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }
}
