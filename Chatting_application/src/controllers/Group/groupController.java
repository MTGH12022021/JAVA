package controllers.Group;

import database.connectData;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class groupController {
    private static connectData DB = new connectData();
    private static int count = 1;
    public void createGroup (){
        String query = "insert into Groups (name,group_id,establish) values (?,newid(),?)";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date now = new Date();
        String date = formatter.format(now);
        try {
            PreparedStatement statement = DB.getConnection().prepareStatement(query);
            statement.setString(1,"Group " + Integer.toString(count));
            statement.setString(2, date);
            statement.executeUpdate();
            count++;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getIdGroup (){
        String query = "select * from Groups";
        String idGroup = null;
        try {
            PreparedStatement statement = DB.getConnection().prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                idGroup = rs.getString(2);
            }
            return idGroup;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addMemberGroup (String user_id,String group_id){
        String query = "insert into MemberGroup (user_id,group_id) values (?,?)";
        try {
            PreparedStatement statement = DB.getConnection().prepareStatement(query);
            statement.setString(1, user_id);
            statement.setString(2, group_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
