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

    public void deleteFriend (String user_id){
        String query = "delete from Friends where friend_id = ?" + "\ndelete from Friends where user_id = ?";

        System.out.println(user_id);
        try {
            PreparedStatement statement = DB.getConnection().prepareStatement(query);
            statement.setString(1, user_id);
            statement.setString(2,user_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteMessagesFriend (String user_id) {
        String query = "delete from MessagesFriend where user_id = ?" + "\ndelete from MessagesFriend where friend_id = ?";
        try {
            PreparedStatement statement = DB.getConnection().prepareStatement(query);
            statement.setString(1,user_id);
            statement.setString(2,user_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
