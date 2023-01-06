package controllers.users;

import Hashing.HashingPass;
import database.connectData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;

public class chatApplicationUserController {
    private static connectData DB = new connectData();

    public ResultSet showAllUser(){
        String query = "select * from Users";
        try {
            PreparedStatement statement = DB.getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                return rs;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public int Register(String user_name, String email,String password, int state, String establish){
        System.out.println(establish);
        String pass = HashingPass.getSecurePassword(password);
        String query = "insert into Users (user_id, user_name, email, password, state, establish) values(NEWID(),?,?,?,?,?)";
        try {
            PreparedStatement statement = DB.getConnection().prepareStatement(query);

            statement.setNString(1, user_name);
            statement.setString(2, email);
            statement.setString(3, pass);
            statement.setInt(4, state);
            statement.setString(5, establish);


            int check = statement.executeUpdate();
            statement.close();
            return check;
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public boolean Login (String Email, String password)
    {

        String pass = HashingPass.getSecurePassword(password);
        System.out.println(Email + pass);
        String query = "select * from Users users where users.email = ? and users.password = ?";
        try{
            PreparedStatement statement = DB.getConnection().prepareStatement(query);
            statement.setString(1, Email);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();

            if (rs.next()){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public ResultSet searchUser (String Email){
        String query = "select * from Users us where us.email = ?";
        PreparedStatement statement = null;
        System.out.println(Email);
        try {
            statement = DB.getConnection().prepareStatement(query);
            statement.setString(1, Email);

            ResultSet rs = statement.executeQuery();
            if (rs.next()){

                return rs;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public ResultSet searchUserById (String user_id) {
        String query = "select * from Users us where us.user_id = ?";
        PreparedStatement statement = null;

        try {
            statement = DB.getConnection().prepareStatement(query);
            statement.setString(1, user_id);

            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                return rs;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
