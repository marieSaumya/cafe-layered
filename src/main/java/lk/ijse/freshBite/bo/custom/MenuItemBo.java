package lk.ijse.freshBite.bo.custom;

import lk.ijse.freshBite.bo.SuperBo;
import lk.ijse.freshBite.dto.AddMenuDto;
import lk.ijse.freshBite.dto.MenuItemDto;

import java.sql.SQLException;
import java.util.List;

public interface MenuItemBo extends SuperBo {
    String getMembership(String id) throws SQLException;
    boolean placeOrder(MenuItemDto dto) throws SQLException;
    List<AddMenuDto> getAllMenuItems() throws SQLException;
    List<String> getAllCustId() throws SQLException;
    String getName(String id) throws SQLException;
    String generateOrderId() throws SQLException;
}
