package controllers.Message;


import database.connectData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class messageGroup {
     private connectData DB = new connectData();

      public ResultSet listGroup (String user_id){
        String query = "SELECT *\n" +
                "  FROM MemberGroup mg, Groups g\n" +
                "  where mg.group_id = g.group_id and mg.user_id = ?";
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

    public ResultSet listMemberGroup (String idGroup){
          String query = "SELECT *\n" +
                "  FROM MemberGroup mg\n" +
                "  where mg.group_id = ?";
        PreparedStatement statement = null;
        try {
            statement = DB.getConnection().prepareStatement(query);
            statement.setString(1, idGroup);

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

    public boolean checkInGroup(String idUser, String idGroup) {
        String query = "SELECT *\n" +
                "  FROM MemberGroup mg\n" +
                "  where mg.group_id = ? and mg.user_id = ?";
        PreparedStatement statement = null;
        try {
            statement = DB.getConnection().prepareStatement(query);
            statement.setString(1, idGroup);
            statement.setString(2, idUser);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void addMessage(String idUser, String idGroup, String mess) throws SQLException {
        ResultSet listMember = listMemberGroup(idGroup);

        if (listMember != null) {
            System.out.println("null ha");
            do {
                listMember.getString("user_id");
                String query = "insert into MessagesGroup (user_id, group_id, message_id, message_content, validate, times) " + "values (?,?, newid(), ?, ?,?)";

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date now = new Date();
                String date = formatter.format(now);
                PreparedStatement statement = null;
                try {
                    statement = DB.getConnection().prepareStatement(query);
                    statement.setString(1, listMember.getString("user_id"));
                    statement.setString(2, idGroup);
                    statement.setNString(3, mess);
                    statement.setString(5, date);
                    if(listMember.getString("user_id").equals(idUser)){
                        statement.setInt(4, 1);
                    }else{
                        statement.setInt(4, 0);
                    }
                    statement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } while (listMember.next());
        }
    }

    public ResultSet loadMessage(String idUser, String idGroup){
        String query = "select * from MessagesGroup mess where mess.user_id = ? and mess.group_id = ? ORDER BY times ASC; ";
        PreparedStatement statement = null;
        try {
            statement = DB.getConnection().prepareStatement(query);
            statement.setString(1,idUser);
            statement.setString(2,idGroup);

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

    public boolean deleteMessage(String idUser, String idGroup){
          System.out.println(idUser +"/////" + idGroup);
          String query = "DELETE mg FROM MessagesGroup mg WHERE mg.user_id = ? and mg.group_id = ?";
          PreparedStatement statement = null;
        try {
            statement = DB.getConnection().prepareStatement(query);
            statement.setString(1,idUser);
            statement.setString(2,idGroup);

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
