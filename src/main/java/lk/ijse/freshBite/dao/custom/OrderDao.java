package lk.ijse.freshBite.dao.custom;

import lk.ijse.freshBite.dao.CrudDao;
import lk.ijse.freshBite.entity.OrderEntity;

import java.sql.SQLException;

public interface OrderDao extends CrudDao<OrderEntity> {
    Double getTotalRevenue() throws SQLException;
}
