package lk.ijse.freshBite.bo.custom.impl;

import lk.ijse.freshBite.bo.custom.LoginBo;
import lk.ijse.freshBite.dao.DaoFactory;
import lk.ijse.freshBite.dao.custom.LoginDao;
import lk.ijse.freshBite.dao.custom.impl.LoginDaoImpl;
import lk.ijse.freshBite.dto.LoginDto;
import lk.ijse.freshBite.entity.LoginEntity;

import java.sql.SQLException;

public class LoginBoImpl implements LoginBo {
    LoginDao loginDao = (LoginDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.LOGIN);
    public LoginDto CheckUserNamePassword() throws SQLException {
        LoginEntity entity = loginDao.CheckUserNamePassword();
        return new LoginDto(entity.getUserName(), entity.getPwd());

    }
}
