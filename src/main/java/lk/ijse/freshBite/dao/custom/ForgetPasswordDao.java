package lk.ijse.freshBite.dao.custom;

import lk.ijse.freshBite.dao.SuperDao;
import lk.ijse.freshBite.dto.ForgotPassworddto;
import lk.ijse.freshBite.entity.ForgotPasswordEntity;

import java.sql.SQLException;

public interface ForgetPasswordDao extends SuperDao {
    ForgotPasswordEntity checkUserName() throws SQLException;

    boolean setPassword(ForgotPasswordEntity entity) throws SQLException;
}
