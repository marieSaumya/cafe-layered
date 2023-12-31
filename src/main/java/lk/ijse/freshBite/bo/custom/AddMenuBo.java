package lk.ijse.freshBite.bo.custom;

import javafx.scene.image.Image;
import lk.ijse.freshBite.bo.SuperBo;
import lk.ijse.freshBite.dto.AddMenuDto;
import lk.ijse.freshBite.dto.StockItemDto;
import lk.ijse.freshBite.dto.tm.ItemCardTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface AddMenuBo extends SuperBo {
    boolean addMenu(AddMenuDto dto) throws SQLException, IOException;
    boolean updateMenu(AddMenuDto dto) throws SQLException;
    boolean deleteItem(String menuId) throws SQLException;
    List<AddMenuDto> loadMenuItems() throws SQLException;
    List<String> getStockId() throws SQLException;
    Image getImgPath(String itemId) throws SQLException;
    StockItemDto getItemDetail(String id) throws SQLException;
    boolean updateStatus(String itemId) throws SQLException;
    boolean updateStatusAvailable(String itemId) throws SQLException;
}
