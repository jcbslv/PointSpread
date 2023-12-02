package pointspread;

import java.util.List;

/**
 *
 * @author jcb
 */
public class PointSpread {
    
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
        System.out.println("help    - Show this menu");
        System.out.println("exit    - Exit this application\n");
    }
    
    public static void displayAllTeams() {
        System.out.println("TEAM LIST");

        List<FootballTeam> teams = teamDAO.getAll();
        FootballTeam t;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < teams.size(); i++) {
            t = teams.get(i);
            sb.append(StringUtils.padWithSpaces(
                    t.getTeamName(), 27));
            //sb.append(c.getEmail());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    
    public static void addTeam() 
    {
        String teamName = Console.getLine("Enter team name: ");
        //String lastName = Console.getString("Enter last name: ");
        //String email = Console.getString("Enter customer email: ");

        FootballTeam team = new FootballTeam();
        team.setTeamName(teamName);
        //customer.setLastName(lastName);
        //customer.setEmail(email);
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
    
}
