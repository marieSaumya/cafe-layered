package lk.ijse.freshBite.dao.custom.impl;

import lk.ijse.freshBite.dao.custom.ForgetPasswordDao;
import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.entity.ForgotPasswordEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ForgotPasswordDaoImpl implements ForgetPasswordDao {


    public ForgotPasswordEntity checkUserName() throws SQLException {
        ForgotPasswordEntity entity = null;
        String sql = "SELECT username FROM users";
        ResultSet resultSet = SQLUtil.execute(sql);
        while ((resultSet.next())){
          String userName =  resultSet.getString(1);
            entity = new ForgotPasswordEntity(userName);


        }
        return  entity;
    }

    public boolean setPassword(ForgotPasswordEntity entity) throws SQLException {
        String sql = "UPDATE users SET password = ? WHERE username=?";
       return  SQLUtil.execute(sql, entity.getPwd(),entity.getUserName());
    }
}
