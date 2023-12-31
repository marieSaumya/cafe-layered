package lk.ijse.freshBite.dao.custom;

import lk.ijse.freshBite.dao.SuperDao;
import lk.ijse.freshBite.dto.LoginDto;
import lk.ijse.freshBite.entity.LoginEntity;

import java.sql.SQLException;

public interface LoginDao extends SuperDao {
    LoginEntity CheckUserNamePassword() throws SQLException;
}
