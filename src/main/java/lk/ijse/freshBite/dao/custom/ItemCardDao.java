package lk.ijse.freshBite.dao.custom;

import lk.ijse.freshBite.dao.SuperDao;
import lk.ijse.freshBite.dto.AddMenuDto;
import lk.ijse.freshBite.entity.AddMenuEntity;

import java.sql.SQLException;

public interface ItemCardDao extends SuperDao {
    String getStatus(String name) throws SQLException;
    AddMenuEntity getItemDetails(String name) throws SQLException;
}
