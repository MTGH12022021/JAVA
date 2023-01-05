package controllers.users;

import Hashing.HashingPass;
import database.connectData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;

public class chatApplicationUserController {
    private static connectData DB = new connectData();;

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

    public boolean Login (String username, String password)
    {

        String pass = HashingPass.getSecurePassword(password);
        System.out.println(username + pass);
        String query = "select * from Users users where users.user_name = ? and users.password = ?";
        try{
            PreparedStatement statement = DB.getConnection().prepareStatement(query);
            statement.setString(1, username);
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
}
