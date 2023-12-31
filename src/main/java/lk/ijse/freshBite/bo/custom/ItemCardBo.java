package lk.ijse.freshBite.bo.custom;

import lk.ijse.freshBite.bo.SuperBo;
import lk.ijse.freshBite.dto.AddMenuDto;

import java.sql.SQLException;

public interface ItemCardBo extends SuperBo {
    String getStatus(String name) throws SQLException;
    AddMenuDto getItemDetails(String name) throws SQLException;
}
