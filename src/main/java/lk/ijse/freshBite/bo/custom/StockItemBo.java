package lk.ijse.freshBite.bo.custom;

import lk.ijse.freshBite.bo.SuperBo;
import lk.ijse.freshBite.dto.StockDto;

import java.sql.SQLException;
import java.util.List;

public interface StockItemBo extends SuperBo {
    boolean addItems(StockDto dto) throws SQLException;
    boolean updateItems( StockDto dto) throws SQLException;
    boolean deleteItem(String stockId) throws SQLException;
    List<StockDto> loadItems() throws SQLException;
    List<String> getSupIdList() throws SQLException;
    String getNextStockId() throws SQLException;
}
