package controllers.admin;

import Hashing.HashingPass;
import database.connectData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminController {
    private static connectData DB = new connectData();
    public boolean loginAdmin (String email, String password){
        String query = "select * from Admin where Admin.email = ? and Admin.password = ?";
        System.out.println(email + password);
        try {
            PreparedStatement statement = DB.getConnection().prepareStatement(query);
            statement.setString(1,email);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                System.out.println(rs.getString(1));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
