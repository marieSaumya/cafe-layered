package lk.ijse.freshBite.bo.custom.impl;

import lk.ijse.freshBite.bo.custom.ForgotPwBo;
import lk.ijse.freshBite.dao.DaoFactory;
import lk.ijse.freshBite.dao.custom.ForgetPasswordDao;
import lk.ijse.freshBite.dao.custom.impl.ForgotPasswordDaoImpl;
import lk.ijse.freshBite.dto.ForgotPassworddto;
import lk.ijse.freshBite.entity.ForgotPasswordEntity;

import java.sql.SQLException;

public class ForgotPwBoImpl implements ForgotPwBo {
    private ForgetPasswordDao forgetPasswordDao = (ForgetPasswordDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.PASSWORD);
    public ForgotPassworddto checkUserName() throws SQLException {

        ForgotPasswordEntity entity =forgetPasswordDao.checkUserName();
        return  new ForgotPassworddto(entity.getUserName());
    }

    public boolean setPassword(ForgotPassworddto dto) throws SQLException {
        return forgetPasswordDao.setPassword(new ForgotPasswordEntity(dto.getUserName(), dto.getPwd()));
    }
}
