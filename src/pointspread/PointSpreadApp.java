package pointspread;

import java.sql.*;
//import java.util.List;
import java.text.NumberFormat;

/**
 *
 * @author jcb
 */
public class PointSpreadApp {
    
    //private static DAO<FootballTeam> teamDAO = null;
    private static DAO<FootballGame> gameDB = null;
    private static Connection connection;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {

        try {
            String dbUrl = "jdbc:sqlite:league.db";
            connection = DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            System.err.println(e);
            return;
        }
        
        // display a welcome message
        System.out.println("\n+-----------------------------------------------+");
        System.out.println("Welcome to the Team Manager\n");

        // set the class variables
        //teamDAO = new TeamTextFile();
        gameDB = new GameDB();
        
        displayMenu();

        
        
        String action = "";
        while (!action.equalsIgnoreCase("exit")) 
        {
            // get the input from the user
            action = Console.getString("Enter a command: ");
            System.out.println();

            if (action.equalsIgnoreCase("db")) {
                displayDB();
            } else if (action.equalsIgnoreCase("team")) {
                displayTeamDB();
            } else if (action.equalsIgnoreCase("gdb")) {
                addGameDB(gameDB);
            } else if (action.equalsIgnoreCase("avg")) {
                getAvgStats();
            } else if (action.equalsIgnoreCase("help") || action.equalsIgnoreCase("menu")) {
                displayMenu();
            } else if (action.equalsIgnoreCase("exit")) {
                System.out.println("Bye.\n");
            } else {
                System.out.println("Error! Not a valid command.\n");
            }
        }
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }

    }
    
    public static void displayMenu() {
        System.out.println("COMMAND MENU");
        System.out.println("db      - List all games");
        System.out.println("team    - List a team");
        System.out.println("gdb     - Add a game");
        //System.out.println("upd     - Update a team");
        //System.out.println("game    - Add game info");
        System.out.println("help    - Show this menu");
        System.out.println("exit    - Exit this application\n");
    }    

    public static void displayDB() {
        try (Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Games")) {
            FootballGame g;

            System.out.println("Team list:");
            while (rs.next()) {
                String home = rs.getString("Home");
                String away = rs.getString("Away");
                double homeScr = rs.getDouble("HomeScore");
                double awayScr = rs.getDouble("AwayScore");
                double homePassYds = rs.getDouble("HomePassYds");
                double awayPassYds = rs.getDouble("AwayPassYds");
                double homeRushYds = rs.getDouble("HomeRushYds");
                double awayRushYds = rs.getDouble("AwayRushYds");
                double homeTrnOvr = rs.getDouble("HomeTrnOvr");
                double awayTrnOvr = rs.getDouble("AwayTrnOvr");
                //int gamesPlayed = rs.getInt("Games Played");

                g = new FootballGame(home, away, homeScr, awayScr, homePassYds, awayPassYds, homeRushYds, awayRushYds, homeTrnOvr, awayTrnOvr);

                printGame(g);
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void displayTeamDB() {

        String home = Console.getString("Enter team: ");
        //String away = Console.getString("Enter away team: ");
        try (Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM " + home)) {
            
            
            System.out.println(home + " Games:");
            String title
                = StringUtils.padWithSpaces("PF", 8) 
                + StringUtils.padWithSpaces("PA", 8)
                + StringUtils.padWithSpaces("PYF", 8)
                + StringUtils.padWithSpaces("PYA", 8)
                + StringUtils.padWithSpaces("RYF", 8)
                + StringUtils.padWithSpaces("RYA", 8)
                + StringUtils.padWithSpaces("TO", 8)
                + StringUtils.padWithSpaces("TOC", 8);
            System.out.println(title);
            while (rs.next()) {
                //String name = rs.getString("Team Name");
                double ptsFor = rs.getDouble("PtsFor");
                double ptsAll = rs.getDouble("PtsAll");
                double passYdsFor = rs.getDouble("PassYdsFor");
                double passYdsAll = rs.getDouble("PassYdsAll");
                double rushYdsFor = rs.getDouble("RushYdsFor");
                double rushYdsAll = rs.getDouble("RushYdsAll");
                double trnovrCom = rs.getDouble("TrnOvrsCom");
                double trnovrCsd = rs.getDouble("TrnOvrsCsd");
                //int gamesPlayed = rs.getInt("Games Played");
                FootballTeam t;
                t = new FootballTeam(home, ptsFor, ptsAll, passYdsFor, passYdsAll, rushYdsFor, rushYdsAll, trnovrCom, trnovrCsd, 0);

                printTeam(t);
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static FootballGame addGameDB(DAO<FootballGame> db) {

        String home = Console.getString("Enter home team: ");
        String away = Console.getString("Enter away team: ");

        double homeScore = Console.getDouble("Enter home score: ");
        double awayScore = Console.getDouble("Enter away score: ");

        double homePassYds = Console.getDouble("Enter home pass yards: ");
        double awayPassYds = Console.getDouble("Enter away pass yards: ");
        double homeRushYds = Console.getDouble("Enter home rush yards: ");
        double awayRushYds = Console.getDouble("Enter away rush yards: ");
        double homeTrnOvr = Console.getDouble("Enter home turnovers: ");
        double awayTrnOvr = Console.getDouble("Enter away turnovers: ");

        FootballGame g = new FootballGame(home, away, homeScore, awayScore, homePassYds, awayPassYds, homeRushYds, awayRushYds, homeTrnOvr, awayTrnOvr);
        
// add game to league db

        boolean success = db.add(g);
        if (success) {
            System.out.println("Game Added\n");
        } else {
            System.out.println("Error! Unable to add game\n");
        }
        
// add home team stats to team's db

        String addHome = "INSERT INTO " + home + "(PtsFor, PtsAll, PassYdsFor, PassYdsAll, RushYdsFor, RushYdsAll, TrnOvrsCOm, TrnOvrsCsd) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(addHome)) {
            ps.setDouble(1, homeScore);
            ps.setDouble(2, awayScore);
            ps.setDouble(3, homePassYds);
            ps.setDouble(4, awayPassYds);
            ps.setDouble(5, homeRushYds);
            ps.setDouble(6, awayRushYds);
            ps.setDouble(7, homeTrnOvr);
            ps.setDouble(8, awayTrnOvr);
            ps.executeUpdate();
            
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e);
        }

// add away team stats to team's db

        String addAway = "INSERT INTO " + away + "(PtsFor, PtsAll, PassYdsFor, PassYdsAll, RushYdsFor, RushYdsAll, TrnOvrsCOm, TrnOvrsCsd) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(addAway)) {
            ps.setDouble(1, awayScore);
            ps.setDouble(2, homeScore);
            ps.setDouble(3, awayPassYds);
            ps.setDouble(4, homePassYds);
            ps.setDouble(5, awayRushYds);
            ps.setDouble(6, homeRushYds);
            ps.setDouble(7, awayTrnOvr);
            ps.setDouble(8, homeTrnOvr);
            ps.executeUpdate();
            
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e);
        }
  
        return g;
    }

    public static void getAvgStats() {
        String home = Console.getString("Enter team: ");
        System.out.println(home + " AVG Stats:");
        String title
                = StringUtils.padWithSpaces("PF", 8) 
                + StringUtils.padWithSpaces("PA", 8)
                + StringUtils.padWithSpaces("PYF", 8)
                + StringUtils.padWithSpaces("PYA", 8)
                + StringUtils.padWithSpaces("RYF", 8)
                + StringUtils.padWithSpaces("RYA", 8)
                + StringUtils.padWithSpaces("TO", 8)
                + StringUtils.padWithSpaces("TOC", 8);
        System.out.println(title);
        NumberFormat num = NumberFormat.getNumberInstance();
        num.setMaximumFractionDigits(1);
        
//------------------------- possibly replace this section with lambda statement ------------------------
        try (Statement statement = connection.createStatement();
            ResultSet pf = statement.executeQuery("SELECT Avg(PtsFor) FROM " + home)) {
                while (pf.next()) {
                    double ptsFor = pf.getDouble(1);
                    System.out.print(StringUtils.padWithSpaces(num.format(ptsFor), 8));
                }
        } catch (SQLException e) {
            System.out.println(e);
        }
        try (Statement statement = connection.createStatement();
            ResultSet pa = statement.executeQuery("SELECT avg(PtsAll) FROM " + home)) {
                while (pa.next()) {
                    double ptsAll = pa.getDouble(1);            
                    System.out.print(StringUtils.padWithSpaces(num.format(ptsAll), 8));
                }
        } catch (SQLException e) {
            System.out.println(e);
        }
        try (Statement statement = connection.createStatement();
            ResultSet pyf = statement.executeQuery("SELECT avg(PassYdsFor) FROM " + home)) {
                while (pyf.next()) {
                    double passYdsFor = pyf.getDouble(1);           
                    System.out.print(StringUtils.padWithSpaces(num.format(passYdsFor), 8));
                }
        } catch (SQLException e) {
            System.out.println(e);
        }
        try (Statement statement = connection.createStatement();
            ResultSet pya = statement.executeQuery("SELECT avg(PassYdsAll) FROM " + home)) {
                while (pya.next()) {
                    double passYdsAll = pya.getDouble(1);           
                    System.out.print(StringUtils.padWithSpaces(num.format(passYdsAll), 8));
                }
        } catch (SQLException e) {
            System.out.println(e);
        }
        try (Statement statement = connection.createStatement();
            ResultSet ryf = statement.executeQuery("SELECT avg(RushYdsFor) FROM " + home)) {
                while (ryf.next()) {
                    double rushYdsFor = ryf.getDouble(1);           
                    System.out.print(StringUtils.padWithSpaces(num.format(rushYdsFor), 8));
                }
        } catch (SQLException e) {
            System.out.println(e);
        }
        try (Statement statement = connection.createStatement();
            ResultSet rya = statement.executeQuery("SELECT avg(RushYdsAll) FROM " + home)) {
                while (rya.next()) {
                    double rushYdsAll = rya.getDouble(1);           
                    System.out.print(StringUtils.padWithSpaces(num.format(rushYdsAll), 8));
                }
        } catch (SQLException e) {
            System.out.println(e);
        }
        try (Statement statement = connection.createStatement();
            ResultSet to = statement.executeQuery("SELECT avg(TrnOvrsCom) FROM " + home)) {
                while (to.next()) {
                    double trnOvrCom = to.getDouble(1);           
                    System.out.print(StringUtils.padWithSpaces(num.format(trnOvrCom), 8));
                }
        } catch (SQLException e) {
            System.out.println(e);
        }
        try (Statement statement = connection.createStatement();
            ResultSet toc = statement.executeQuery("SELECT avg(TrnOvrsCsd) FROM " + home)) {
                while (toc.next()) {
                    double trnOvrCsd = toc.getDouble(1);           
                    System.out.println(StringUtils.padWithSpaces(num.format(trnOvrCsd), 8));
                }
        } catch (SQLException e) {
            System.out.println(e);
        }
// -----------------------------------------------------------------------------------------
        System.out.println();      
    }

    private static void printTeam(FootballTeam p) {
        String productString
                = //StringUtils.padWithSpaces(p.getTeamName(), 8)
                StringUtils.padWithSpaces(p.getFormattedNum(p.getTotalPointsFor()), 8)
                + StringUtils.padWithSpaces(p.getFormattedNum(p.getTotalPointsAgainst()), 8)
                + StringUtils.padWithSpaces(p.getFormattedNum(p.getPassYardsFor()), 8)
                + StringUtils.padWithSpaces(p.getFormattedNum(p.getPassYardsAgainst()), 8)
                + StringUtils.padWithSpaces(p.getFormattedNum(p.getRushYardsFor()), 8)
                + StringUtils.padWithSpaces(p.getFormattedNum(p.getRushYardsAgainst()), 8)
                + StringUtils.padWithSpaces(p.getFormattedNum(p.getTurnoversCommitted()), 8)
                + StringUtils.padWithSpaces(p.getFormattedNum(p.getTurnoversCaused()), 8)
                ;

        System.out.println(productString);
    }

    private static void printGame(FootballGame p) {
        String productString
                = StringUtils.padWithSpaces(p.getHome(), 8)
                + StringUtils.padWithSpaces(p.getAway(), 8)
                + StringUtils.padWithSpaces(p.getFormattedNum(p.getHomeScore()), 8)
                + StringUtils.padWithSpaces(p.getFormattedNum(p.getAwayScore()), 8)
                + StringUtils.padWithSpaces(p.getFormattedNum(p.getHomePassYds()), 8)
                + StringUtils.padWithSpaces(p.getFormattedNum(p.getAwayPassYds()), 8)
                + StringUtils.padWithSpaces(p.getFormattedNum(p.getHomeRushYds()), 8)
                + StringUtils.padWithSpaces(p.getFormattedNum(p.getAwayRushYds()), 8)
                + StringUtils.padWithSpaces(p.getFormattedNum(p.getHomeTrnOvr()), 8)
                + StringUtils.padWithSpaces(p.getFormattedNum(p.getAwayTrnOvr()), 8)
                ;

        System.out.println(productString);
    }

}
