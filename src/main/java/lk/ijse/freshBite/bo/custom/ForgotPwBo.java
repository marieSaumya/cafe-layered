package lk.ijse.freshBite.bo.custom;

import lk.ijse.freshBite.bo.SuperBo;
import lk.ijse.freshBite.dto.ForgotPassworddto;

import java.sql.SQLException;

public interface ForgotPwBo extends SuperBo {
    ForgotPassworddto checkUserName() throws SQLException;

    boolean setPassword(ForgotPassworddto dto) throws SQLException;
}
