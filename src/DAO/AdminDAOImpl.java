package DAO;


import Connection.DbConnection;
import exception.AuthenticationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO{

    @Override
    public boolean authenticate(String username, String password) throws AuthenticationException {
        String query = "SELECT * FROM admins WHERE username = ? AND password = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1,username);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return true;
            }
            else {
                throw new AuthenticationException("Invalid admin username or password");
            }
        }
        catch (SQLException|ClassNotFoundException e){
            System.out.println(e.getMessage());
            throw new AuthenticationException("Database error during admin login");
        }
    }


    @Override
    public void addAdmin(String username, String password) {
        String query = "INSERT INTO admins (username, password) VALUES (?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();

        } catch (SQLException| ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
