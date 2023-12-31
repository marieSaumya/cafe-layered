package lk.ijse.freshBite.dao.custom.impl;

import lk.ijse.freshBite.dao.custom.LoginDao;
import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.entity.LoginEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {

    public LoginDaoImpl() {

    }

    public LoginEntity CheckUserNamePassword() throws SQLException {
        LoginEntity entity = null;
        String sql = "SELECT username,password FROM users";
        ResultSet resultSet = SQLUtil.execute(sql);
        while(resultSet.next()){
            String userName = resultSet.getString(1);
            String pw = resultSet.getString(2);

            entity = new LoginEntity(userName,pw);


        }
        return entity;

    }
}
