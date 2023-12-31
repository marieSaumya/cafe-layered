package lk.ijse.freshBite.bo.custom.impl;

import lk.ijse.freshBite.bo.custom.MailBo;
import lk.ijse.freshBite.dao.DaoFactory;
import lk.ijse.freshBite.dao.custom.CustomerDetailDao;
import lk.ijse.freshBite.dao.custom.impl.CustomerDetailDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class MailBoImpl implements MailBo {
private CustomerDetailDao customerDetailDao = (CustomerDetailDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.CUSTOMER);
    @Override
    public List<String> getCustomerEmails() throws SQLException {
        return customerDetailDao.getCustomerEmails();
    }
}
