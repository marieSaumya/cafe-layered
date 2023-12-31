package lk.ijse.freshBite.dao.custom;

import lk.ijse.freshBite.dao.CrudDao;
import lk.ijse.freshBite.entity.CustomerEntity;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDetailDao extends CrudDao<CustomerEntity> {
    List<String> loadCustomerId() throws SQLException;
    String getMembership(String id) throws SQLException;
    List<String> getCustomerEmails() throws SQLException;

}
