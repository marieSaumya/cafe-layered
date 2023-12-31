package lk.ijse.freshBite.dao.custom;

import lk.ijse.freshBite.dao.CrudDao;
import lk.ijse.freshBite.entity.SupplierEntity;

import java.sql.SQLException;
import java.util.List;

public interface SupplierDao extends CrudDao<SupplierEntity> {
    List<String> getSupIdList() throws SQLException;
}
