package pointspread;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDB implements DAO<FootballGame> {

    private static Connection getConnection() throws SQLException {
        String dbURL = "jdbc:sqlite:league.db";
        Connection connection = DriverManager.getConnection(dbURL);
        return connection;
    }

    @Override
    public FootballGame get(String code) {
        String t = Console.getString("Enter Team: ");
        String s = Console.getString("Enter Stat: ");
        String sql = "SELECT * " + " FROM " + t
                    + " WHERE " + s + " = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    String home = rs.getString("Home");
                    String away = rs.getString("Away");
                    double ptsFor = rs.getDouble("PtsFor");
                    double ptsAll = rs.getDouble("PtsAll");
                    double passYdsFor = rs.getDouble("PassYdsFor");
                    double passYdsAll = rs.getDouble("PassYdsAll");
                    double rushYdsFor = rs.getDouble("RushYdsFor");
                    double rushYdsAll = rs.getDouble("RushYdsAll");
                    double trnOvrCom = rs.getDouble("TrnOvrsCom");
                    double trnOvrCsd = rs.getDouble("TrnOvrsCsd");

                    FootballGame g = new FootballGame(home, away, ptsFor, ptsAll, passYdsFor, passYdsAll, rushYdsFor, rushYdsAll, trnOvrCom, trnOvrCsd);

                    rs.close();
                    return g;
                } else {
                    rs.close();
                    return null;
                }
             } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
    }

    @Override
    public List<FootballGame> getAll() {
        String t = Console.getString("Enter Team: ");
        String sql = "SELECT * FROM "+ t;
        List<FootballGame> games = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String home = rs.getString("Home");
                    String away = rs.getString("Away");
                    double ptsFor = rs.getDouble("PtsFor");
                    double ptsAll = rs.getDouble("PtsAll");
                    double passYdsFor = rs.getDouble("PassYdsFor");
                    double passYdsAll = rs.getDouble("PassYdsAll");
                    double rushYdsFor = rs.getDouble("RushYdsFor");
                    double rushYdsAll = rs.getDouble("RushYdsAll");
                    double trnOvrCom = rs.getDouble("TrnOvrsCom");
                    double trnOvrsCsd = rs.getDouble("TrnOvrsCsd");

                    FootballGame g = new FootballGame(home, away, ptsFor, ptsAll, passYdsFor, passYdsAll, rushYdsFor, rushYdsAll, trnOvrCom, trnOvrsCsd);
                    games.add(g);
                }
                return games;
             } catch (SQLException e) {
                System.err.println(e);
                return null;
             }
    }

    @Override
    public boolean add(FootballGame g) {
        String sql = "INSERT INTO Games (Home, Away, HomeScore, AwayScore, HomePassYds, AwayPassYds, "
                   + "HomeRushYds, AwayRushYds, HomeTrnOvr, AwayTrnOvr) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, g.getHome());
                ps.setString(2, g.getAway());
                ps.setDouble(3, g.getHomeScore());
                ps.setDouble(4, g.getAwayScore());
                ps.setDouble(5, g.getHomePassYds());
                ps.setDouble(6, g.getAwayPassYds());
                ps.setDouble(7, g.getHomeRushYds());
                ps.setDouble(8, g.getAwayRushYds());
                ps.setDouble(9, g.getHomeTrnOvr());
                ps.setDouble(10, g.getAwayTrnOvr());
                ps.executeUpdate();
                return true;
            } catch (SQLException e) {
                System.err.println(e);
                return false;
            }
    }

    @Override
    public boolean update(FootballGame t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(FootballGame t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
