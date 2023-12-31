package lk.ijse.freshBite.dao.custom;

import lk.ijse.freshBite.dao.CrudDao;
import lk.ijse.freshBite.entity.OrderItemEntity;

import java.sql.SQLException;

public interface OrderItemDao extends CrudDao<OrderItemEntity> {
    String getItemId(String itemName) throws SQLException;

}
