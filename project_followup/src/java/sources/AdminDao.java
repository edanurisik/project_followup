/**
 *
 * @author Edanur
 */
package sources;

import java.sql.*;
import sources.Admin;
import sources.AdminService;

public class AdminDao implements AdminService{
    public final Connection con;
    public String  query;
    public PreparedStatement pst;
    public ResultSet rs;

    public AdminDao(Connection con) {
        this.con = con;
    }
    
    @Override
    public Admin logAdmin(String email, String password) {
        Admin admin = null;
        try {
        query = "select * from admin where email=? and password=? ";
        pst = this.con.prepareStatement(query);
        pst.setString(1, email);
        pst.setString(2, password);
        rs = pst.executeQuery();
        if(rs.next()) {
            admin = new Admin(rs.getInt("admin_id"),"","", email,password);
            admin.setId(rs.getInt("admin_id"));
            admin.setName(rs.getString("name"));
            admin.setEmail(rs.getString("email"));
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return admin;
    }   
}
