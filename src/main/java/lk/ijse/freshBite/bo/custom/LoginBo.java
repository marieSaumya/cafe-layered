package lk.ijse.freshBite.bo.custom;

import lk.ijse.freshBite.bo.SuperBo;
import lk.ijse.freshBite.dto.LoginDto;

import java.sql.SQLException;

public interface LoginBo extends SuperBo {
    LoginDto CheckUserNamePassword() throws SQLException;
}
