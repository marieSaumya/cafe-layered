package lk.ijse.freshBite.dao.custom;

import lk.ijse.freshBite.dao.CrudDao;
import lk.ijse.freshBite.entity.AddMenuEntity;
import lk.ijse.freshBite.entity.MenuItemEntity;

import java.sql.SQLException;
import java.util.List;

public interface MenuItemDao extends CrudDao<AddMenuEntity> {
    List<String> getAllCustId() throws SQLException;
    String getName(String id) throws SQLException;

}
