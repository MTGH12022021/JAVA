package controllers.Friend;

import database.connectData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class friendController {
    private static connectData DB = new connectData();
    public void addFriend(String user_id, String friend_id){
        String query = "insert into Friends (user_id, friend_id) values (?,?)"
        + "\n insert into Friends (user_id, friend_id) values (?,?)";
        PreparedStatement statement = null;
        try {
            statement = DB.getConnection().prepareStatement(query);
            statement.setString(1, user_id);
            statement.setString(2,friend_id);
            statement.setString(3, friend_id);
            statement.setString(4,user_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ResultSet searchFriend (String user_id){
        String query = "select * from Friends f where f.user_id = ?";
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
