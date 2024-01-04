package pointspread;

/**
 *
 * @author jcb
 */
import java.util.*;
import java.io.*;
import java.nio.file.*;

public final class TeamTextFile implements DAO<FootballTeam> {

    private List<FootballTeam> teams = null;
    private Path teamsPath = null;
    private File teamsFile = null;

    private final String FIELD_SEP = "\t";

    public TeamTextFile() {
        // initialize the class variables
        teamsPath = Paths.get("teams.txt");
        teamsFile = teamsPath.toFile();
        teams = this.getAll();
    }

    @Override
    public List<FootballTeam> getAll() {
        // if the customers file has already been read, don't read it again
        if (teams != null) {
            return teams;
        }
        // create array list of Customers
        teams = new ArrayList<>();

        
        // check if the file exists
        if (Files.exists(teamsPath)) {
            // if file exists, use a try-with-resources statement to open
            // the input stream
            try (BufferedReader in = new BufferedReader(
                                     new FileReader(teamsFile))) {
                // read in each record
                String line = in.readLine();
                while (line != null) {
                    // split each record's fields into an array
                    String[] fields = line.split(FIELD_SEP);
                    String teamName = fields[0];
                    String passYardsFor = fields[1];
                    String passYardsAgainst = fields[2];
                    String rushYardsFor = fields[3];
                    String rushYardsAgainst = fields[4];
                    String totalPointsFor = fields[5];
                    String totalPointsAgainst = fields[6];
                    String turnoversCommitted = fields[7];
                    String turnoversCaused = fields[8];
                    String gamesPlayed = fields[9];
                    
                    // load the array list with Customer objects created from
                    // the data in the file
                    FootballTeam t = new FootballTeam(
                            teamName, 
                            Double.parseDouble(passYardsFor), 
                            Double.parseDouble(passYardsAgainst),
                            Double.parseDouble(rushYardsFor), 
                            Double.parseDouble(rushYardsAgainst), 
                            Double.parseDouble(totalPointsFor), 
                            Double.parseDouble(totalPointsAgainst), 
                            Double.parseDouble(turnoversCommitted),
                            Double.parseDouble(turnoversCaused),
                            Integer.parseInt(gamesPlayed));
                    teams.add(t);
                    line = in.readLine();
                }
            // if an IOException occures when the input stream is opened,
            // print the exception to the console and return null to the 
            // calling method
            } catch (IOException e) {
                System.out.println(e);
                return null;
            }
        // if file doesn't exist, print message to screen and return null
        } else {
            System.out.println(
                    teamsPath.toAbsolutePath() + " doesn't exist.");
            return null;
        }
        return teams;
    }

    @Override
    public FootballTeam get(String name) {
        for (FootballTeam t : teams) {
            if (t.getTeamName().equals(name)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public boolean add(FootballTeam t) {
        teams.add(t);
        return this.saveAll();
    }

    @Override
    public boolean delete(FootballTeam t) {
        teams.remove(t);
        return this.saveAll();
    }

    @Override
    public boolean update(FootballTeam newTeam) {
        // get the old team and remove it
        FootballTeam oldTeam = this.get(newTeam.getTeamName());
        int i = teams.indexOf(oldTeam);
        teams.remove(i);

        // add the updated customer
        teams.add(i, newTeam);

        return this.saveAll();
    }

    private boolean saveAll() {
        // save the Customer objects in the array list to the file
        // use a try-with-resources statement to open the output stream
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(teamsFile)))) {
            // write data in each Customer object in the customer list to a
            // record in the customer file
            for (FootballTeam t : teams) {
                // be sure to delimit the fields and records with the 
                // appropriate character
                out.print(t.getTeamName() + FIELD_SEP );
                out.print(t.getPassYardsFor() + FIELD_SEP );
                out.print(t.getPassYardsAgainst() + FIELD_SEP );
                out.print(t.getRushYardsFor() + FIELD_SEP );
                out.print(t.getRushYardsAgainst() + FIELD_SEP );
                out.print(t.getTotalPointsFor() + FIELD_SEP );
                out.print(t.getTotalPointsAgainst() + FIELD_SEP );
                out.print(t.getTurnoversCommitted() + FIELD_SEP );
                out.print(t.getTurnoversCaused() + FIELD_SEP );
                out.println(t.getGamesPlayed());
            }
        // if an IOException occurs when the output stream is opened, print
        // the exception to the console and return false to the calling method
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
}
