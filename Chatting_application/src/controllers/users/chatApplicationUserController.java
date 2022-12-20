package controllers.users;

import database.connectData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;

public class chatApplicationUserController {
    private static connectData DB = new connectData();;

    public int Register(String user_name, String email,String password, int state, String establish){

        String query = "insert into Users (user_id, user_name, email, password, state, establish) values(NEWID(),?,?,?,?,?)";
        try {
            PreparedStatement statement = DB.getConnection().prepareStatement(query);

            statement.setNString(1, user_name);
            statement.setString(2, email);
            statement.setString(3, password);
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

    public int Login (String username, String password)
    {
        String query = "select * from Users user where user.user_name = ? and user.password = ?";
        try{
            PreparedStatement statement = DB.getConnection().prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            rs.next();
            if (rs != null ){
                return 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }
}
