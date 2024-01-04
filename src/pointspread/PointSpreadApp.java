package pointspread;

import java.util.List;

/**
 *
 * @author jcb
 */
public class PointSpreadApp {
    
    private static DAO<FootballTeam> teamDAO = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        // TODO code application logic here
        // display a welcome message
        System.out.println("\n+-----------------------------------------------+");
        System.out.println("Welcome to the Team Manager\n");

        // set the class variables
        teamDAO = new TeamTextFile();
        
        displayMenu();
        
        String action = "";
        while (!action.equalsIgnoreCase("exit")) 
        {
            // get the input from the user
            action = Console.getString("Enter a command: ");
            System.out.println();

            if (action.equalsIgnoreCase("list")) 
            {
                displayAllTeams();
            } else if (action.equalsIgnoreCase("add")) 
            {
                addTeam();
            } else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("delete")) {
                deleteTeam();
            } else if (action.equalsIgnoreCase("upd") || action.equalsIgnoreCase("update")) {
                updateTeam();
            } else if (action.equalsIgnoreCase("game")) {
                addGame();
            } else if (action.equalsIgnoreCase("help") || action.equalsIgnoreCase("menu")) {
                displayMenu();
            } else if (action.equalsIgnoreCase("exit")) {
                System.out.println("Bye.\n");
            } else {
                System.out.println("Error! Not a valid command.\n");
            }
        }        
    }
    
    public static void displayMenu() {
        System.out.println("COMMAND MENU");
        System.out.println("list    - List all teams");
        System.out.println("add     - Add a team");
        System.out.println("del     - Delete a team");
        System.out.println("upd     - Update a team");
        System.out.println("game    - Add game info");
        System.out.println("help    - Show this menu");
        System.out.println("exit    - Exit this application\n");
    }
    
    public static void displayAllTeams() {
        System.out.println("TEAM LIST\n");

        List<FootballTeam> teams = teamDAO.getAll();
        FootballTeam t;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < teams.size(); i++) {
            t = teams.get(i);
            sb.append(StringUtils.padWithSpaces(
                    t.getTeamName(), 8));
            sb.append(t.getPassYardsFor()+"\t");
            sb.append(t.getPassYardsAgainst()+"\t");
            sb.append(t.getRushYardsFor()+"\t");
            sb.append(t.getRushYardsAgainst()+"\t");
            sb.append(t.getTotalPointsFor()+"\t");
            sb.append(t.getTotalPointsAgainst()+"\t");
            sb.append(t.getTurnoversCommitted()+"\t");
            sb.append(t.getTurnoversCaused()+"\t");
            sb.append(t.getGamesPlayed()+"\t");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    
    public static void addTeam() 
    {
        String teamName = Console.getLine("Enter team name: ");

        FootballTeam team = new FootballTeam();
        team.setTeamName(teamName);
    
        teamDAO.add(team);

        System.out.println();
        System.out.println(teamName + " has been added.\n");
    }

    public static void deleteTeam() {
        String team = Console.getString("Enter team to delete: ");

        FootballTeam c = teamDAO.get(team);

        System.out.println();
        if (c != null) {
            teamDAO.delete(c);
            System.out.println(c.getTeamName()
                    + " has been deleted.\n");
        } else {
            System.out.println("No team matches that name.\n");
        }
    }

    public static void updateTeam() {
        String team = Console.getString("Enter team to update: ");

        FootballTeam t = teamDAO.get(team);
        int pts = Console.getInt("Enter point total: ");
        
        if (t != null) {
            t.setTotalPointsFor(t.getTotalPointsFor() + pts);
            teamDAO.update(t);
        }
    }
    
    public static void addGame() {
        
        String home = Console.getString("Enter home team: ");
        String away = Console.getString("Enter away team: ");
        FootballTeam h = teamDAO.get(home);
        FootballTeam a = teamDAO.get(away);
        
        int homeScore = Console.getInt("Enter home score: ");
        int awayScore = Console.getInt("Enter away score: ");

        double homePassYds = Console.getDouble("Enter home pass yards: ");
        double awayPassYds = Console.getDouble("Enter away pass yards: ");
        double homeRushYds = Console.getDouble("Enter home rush yards: ");
        double awayRushYds = Console.getDouble("Enter away rush yards: ");
        int homeTrnOvr = Console.getInt("Enter home turnovers: ");
        int awayTrnOvr = Console.getInt("Enter away turnovers: ");

        //FootballGame game = new FootballGame(h, a, homeScore, awayScore, homePassYds, awayPassYds, homeRushYds, awayRushYds, homeTrnOvr, awayTrnOvr);
        if (h != null) {
            h.setTotalPointsFor(h.getTotalPointsFor() + homeScore);
            h.setTotalPointsAgainst(h.getTotalPointsAgainst() + awayScore);
            h.setPassYardsFor(h.getPassYardsFor() + homePassYds);
            h.setPassYardsAgainst(h.getPassYardsAgainst() + awayPassYds);
            h.setRushYardsFor(h.getRushYardsFor() + homeRushYds);
            h.setRushYardsAgainst(h.getRushYardsAgainst() + awayRushYds);
            h.setTurnoversCommitted(h.getTurnoversCommitted() + homeTrnOvr);
            h.setTurnoversCaused(h.getTurnoversCaused() + awayTrnOvr);
            h.setGamesPlayed(h.getGamesPlayed() + 1);
            teamDAO.update(h);
        }

        if (a != null) {
            a.setTotalPointsFor(a.getTotalPointsFor() + awayScore);
            a.setTotalPointsAgainst(a.getTotalPointsAgainst() + homeScore);
            a.setPassYardsFor(a.getPassYardsFor() + awayPassYds);
            a.setPassYardsAgainst(a.getPassYardsAgainst() + homePassYds);
            a.setRushYardsFor(a.getRushYardsFor() + awayRushYds);
            a.setRushYardsAgainst(a.getRushYardsAgainst() + homeRushYds);
            a.setTurnoversCommitted(a.getTurnoversCommitted() + awayTrnOvr);
            a.setTurnoversCaused(a.getTurnoversCaused() + homeTrnOvr);
            a.setGamesPlayed(a.getGamesPlayed() + 1);
            teamDAO.update(a);
        }
    }
}
