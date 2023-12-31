package lk.ijse.freshBite.dao.custom;

import lk.ijse.freshBite.dao.CrudDao;
import lk.ijse.freshBite.entity.StaffDetailEntity;

import java.sql.SQLException;

public interface StaffDetailDao extends CrudDao<StaffDetailEntity> {
    String getBarcodePath(String text) throws SQLException;

}
