package controllers.users;

import Hashing.HashingPass;
import database.connectData;

import javax.swing.*;
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
    public int Register(String user_name, String email,String password, int state, int lockout,String establish, String dateofbirth,String gioitinh){
        System.out.println(establish);
        String pass = HashingPass.getSecurePassword(password);
        String query = "insert into Users (user_id, user_name, email, password, state, lockout,establish,ngaysinh,gioitinh) values(NEWID(),?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = DB.getConnection().prepareStatement(query);

            statement.setNString(1, user_name);
            statement.setString(2, email);
            statement.setString(3, pass);
            statement.setInt(4, state);
            statement.setInt(5, lockout);
            statement.setString(6,establish);
            statement.setString(7,dateofbirth);
            statement.setString(8,gioitinh);
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
                if  (rs.getInt(6) == 1) {
                    return true;
                }
                else {
                    return false;
                }
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

    public ResultSet searchUserByUsername (String user_name) {
        String query = "select * from Users where lower(user_name) = ?";
        PreparedStatement statement = null;
        user_name.toLowerCase();
        try {
            statement = DB.getConnection().prepareStatement(query);
            statement.setString(1, user_name);

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

    public ResultSet filterUserByEstablishAsc () {
        String query = "select * from Users ORDER BY establish asc";
        PreparedStatement statement = null;
        try {
            statement = DB.getConnection().prepareStatement(query);

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

    public ResultSet filterUserByEstablishDesc () {
        String query = "select * from Users ORDER BY establish desc";
        PreparedStatement statement = null;
        try {
            statement = DB.getConnection().prepareStatement(query);

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
    public void deleteUser (String Email){
        String query = "delete from Users where email = ?";
        try {
            PreparedStatement statement = DB.getConnection().prepareStatement(query);
            statement.setString(1, Email);
            statement.executeUpdate();
            System.out.println("Xoa thanh cong");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void lockAccount (String user_id){
        String query = "update Users set lockout = 0 where user_id = ?";
        try {
            PreparedStatement statement = DB.getConnection().prepareStatement(query);
            statement.setString(1,user_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void openAccount (String user_id){
        String query = "update Users set lockout = 1 where user_id = ?";
        try {
            PreparedStatement statement = DB.getConnection().prepareStatement(query);
            statement.setString(1,user_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePassword (String user_id,String Newpassword){
        String pass = HashingPass.getSecurePassword(Newpassword);
        String query = "update Users set password = ? where user_id = ?";

        try {
            PreparedStatement statement = DB.getConnection().prepareStatement(query);
            statement.setString(1,pass);
            statement.setString(2, user_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser (String user_id, String username, String email,String ngaysinh,String gioitinh ){
        ResultSet rs = searchUserById(user_id);
        String query = "update Users set user_name = ?, email = ?, ngaysinh = ?, gioitinh = ? where user_id = ?";
        try {
            if (username.equals("")) {
                username = rs.getString(2);
            }
            if (email.equals("")) {
                email = rs.getString(3);
            }
            if (ngaysinh.equals("")) {
                ngaysinh = rs.getString(8);
            }
            if (gioitinh.equals("")) {
                gioitinh= rs.getString(9);
            }

            PreparedStatement statement = DB.getConnection().prepareStatement(query);
            statement.setString(1,username);
            statement.setString(2,email);
            statement.setString(3,ngaysinh);
            statement.setString(4,gioitinh);
            statement.setString(5, user_id);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
