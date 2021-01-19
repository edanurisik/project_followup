/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import sources.User;
import sources.UserService;

/**
 *
 * @author nurbanu
 */
public class UserLoginDao implements UserService
{
    public final Connection con;
    public String  query;
    public PreparedStatement pst;
    public ResultSet rs;
    
    public UserLoginDao(Connection con) {
        this.con = con;
    }
    
    public User logUser(String email, String password) {
        User user = null;
        try {
        query = "select * from user where email=? and password=? ";
        pst = this.con.prepareStatement(query);
        pst.setString(1, email);
        pst.setString(2, password);
        rs = pst.executeQuery();
        if(rs.next()) {
            user = new User(rs.getInt("user_id"),"","", email,password);
            user.setId(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }   
}
