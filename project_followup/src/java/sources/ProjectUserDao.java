
package sources;  

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ProjectUserDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/project_followup?zeroDateTimeBehavior=convertToNull";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345";

    private static final String INSERT_PROJECTUSERS_SQL = "INSERT INTO project_relationship" + "  (project_id,user_id) VALUES " +
        " (?, ?);";

    private static final String SELECT_PROJECTUSER_BY_ID = "select id, project_id, user_id from project_relationship where id = ? ";
    private static final String SELECT_ALL_PROJECTUSERS = "select * from project_relationship";
    private static final String DELETE_PROJECTUSERS_SQL = "delete from project_relationship where id = ?;";
    private static final String UPDATE_PROJECTUSERS_SQL = "update project_relationship set user_id = ?, project_id = ? where id = ?;";

    public ProjectUserDao() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertProjectUser(ProjectRelationship projectuser) throws SQLException {
        System.out.println(INSERT_PROJECTUSERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECTUSERS_SQL)) {
            preparedStatement.setInt(1, projectuser.getUserId());
            preparedStatement.setInt(2, projectuser.getProjectId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public ProjectRelationship selectProjectUser(int id) {
        ProjectRelationship projectuser = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROJECTUSER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                int project_id = rs.getInt("project_id");  
                projectuser = new ProjectRelationship(id, user_id, project_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return projectuser;
    }

    public List <ProjectRelationship> selectAllProjectUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List <ProjectRelationship> projectusers = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROJECTUSERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                int project_id = rs.getInt("project_id");
                projectusers.add(new ProjectRelationship(id, user_id, project_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return projectusers;
    }

    public boolean deleteProjectUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PROJECTUSERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateProjectUser(ProjectRelationship projectUser) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PROJECTUSERS_SQL);) {
            statement.setInt(1, projectUser.getProjectId());
            statement.setInt(2, projectUser.getUserId());
            statement.setInt(3, projectUser.getId());
            
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    }


