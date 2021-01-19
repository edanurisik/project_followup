package sources;

import java.sql.*;

public class ConnectionDB {
    public static Connection con;
    
    public static Connection getCon () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project_followup?zeroDateTimeBehavior=convertToNull", "root", "12345");
           
    } catch (ClassNotFoundException | SQLException ex) {
        System.out.println(ex);
        ex.printStackTrace();
    }
        return con;
}
}