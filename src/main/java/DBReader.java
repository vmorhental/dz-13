import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBReader {
    private static final String URL = "jdbc:postgresql://localhost:4567/postgres";
    private final static String USER_NAME = "postgres";
    private final static String USER_PASSWORD = "CustompasswordHomework3";
    private final static String SELECT_ALL_QUERY = "select * from persons";
    private final static String SELECT_ENTITY_QUERY = "select * from persons where id=?";
    private final static String INSERT_QUERY = "insert into persons values (?,?,?,?)";
    private final static String UPDATE_QUERY = "update persons set years=? where id=?";
    private final static String DELETE_QUERY = "delete from persons where id=?";

    public static List<Entity> getAllEntitiesDB() {
        List<Entity> personsFromDB = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Entity person = new Entity(resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getInt("years"),
                        resultSet.getInt("rate"));
                personsFromDB.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Please check connection " +
                    " URL [%s], Name [%s], Pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }
        return personsFromDB;
    }
    public static List<Entity> getSingleEntityFromDB() {
        List<Entity> personsFromDB = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ENTITY_QUERY);
            preparedStatement.setInt(1,3);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Entity person = new Entity(resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getInt("years"),
                        resultSet.getInt("rate"));
                personsFromDB.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Please check connection " +
                    " URL [%s], Name [%s], Pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }
        return personsFromDB;
    }
    public static void insertPersonIntoDB() {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, 44);
            preparedStatement.setString(2,"InteliIDEA");
            preparedStatement.setInt(3, 99);
            preparedStatement.setInt(4, 121);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Please check connection " +
                    " URL [%s], Name [%s], Pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }
    }
    public static void updatePersonInDB() {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setInt(1, 100);
            preparedStatement.setInt(2, 2);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Please check connection " +
                    " URL [%s], Name [%s], Pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }
    }
    public static void deletePersonInDB() {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Please check connection " +
                    " URL [%s], Name [%s], Pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }
    }

    public static void main(String[] args) {
        getAllEntitiesDB();
        getSingleEntityFromDB();
        insertPersonIntoDB();
        updatePersonInDB();
        deletePersonInDB();
    }
}
