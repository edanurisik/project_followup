
package sources;  

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ProjectDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/project_followup?zeroDateTimeBehavior=convertToNull";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345";

    private static final String INSERT_PROJECTS_SQL = "INSERT INTO project" + "  (subject,description, start_date, end_date) VALUES " +
        " (?, ?, ?, ?);";

    private static final String SELECT_PROJECT_BY_ID = "select project_id,subject,description, start_date, end_date from project where project_id = ? ";
    private static final String SELECT_ALL_PROJECTS = "select * from project";
    private static final String DELETE_PROJECTS_SQL = "delete from project where project_id = ?;";
    private static final String UPDATE_PROJECTS_SQL = "update project set subject = ?, description = ?, start_date = ?, end_date = ? where project_id = ?;";

    public ProjectDao() {}

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

    public void insertProject(Project project) throws SQLException {
        System.out.println(INSERT_PROJECTS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECTS_SQL)) {
            preparedStatement.setString(1, project.getSubject());
            preparedStatement.setString(2, project.getDescription());
            preparedStatement.setDate(3, project.getStart_date());
            preparedStatement.setDate(4, project.getEnd_date());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Project selectProject(int id) {
        Project project = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROJECT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String subject = rs.getString("subject");
                String description = rs.getString("description");  
                Date start_date = rs.getDate("start_date");
                Date end_date = rs.getDate("end_date");
                project = new Project(id, subject, description, start_date, end_date);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return project;
    }

    public List <Project> selectAllProjects() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List <Project> projects = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PROJECTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("project_id");
                String subject = rs.getString("subject");
                String description = rs.getString("description");  
                Date start_date = rs.getDate("start_date");
                Date end_date = rs.getDate("end_date");
                projects.add(new Project(id, subject, description, start_date, end_date));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return projects;
    }

    public boolean deleteProject(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PROJECTS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateProject(Project project) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PROJECTS_SQL);) {
            statement.setString(1, project.getSubject());
            statement.setString(2, project.getDescription());
            statement.setDate(3, project.getStart_date());
            statement.setDate(4, project.getEnd_date());
            statement.setInt(5, project.getId());
            
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


