package controllers.Message;


import database.connectData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class messageFriend {
    private connectData DB = new connectData();

    public void addMessage(String idUser, String idFriend, String mess){
        String query = "insert into MessagesFriend (user_id, friend_id, message_id, message_content, validate, times) " + "values (?,?, newid(), ?, 0,?)"
        + "\n insert into MessagesFriend (user_id, friend_id, message_id, message_content, validate, times) " + "values (?,?, newid(), ?, 1,?) ";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date now = new Date();
        String date = formatter.format(now);
        PreparedStatement statement = null;
        try {
            statement = DB.getConnection().prepareStatement(query);
            statement.setString(1, idUser);
            statement.setString(2,idFriend);
            statement.setNString(3, mess);
            statement.setString(4, date);

            statement.setString(5, idFriend);
            statement.setString(6,idUser);
            statement.setNString(7, mess);
            statement.setString(8, date);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet loadMessage(String idUser, String idFriend){
        String query = "select * from MessagesFriend mess where mess.user_id = ? and mess.friend_id = ? ORDER BY times ASC; ";
        PreparedStatement statement = null;
        try {
            statement = DB.getConnection().prepareStatement(query);
            statement.setString(1,idUser);
            statement.setString(2,idFriend);

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
