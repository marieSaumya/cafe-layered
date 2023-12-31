package lk.ijse.freshBite.dao.custom.impl;

import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.dao.custom.StockItemDao;
import lk.ijse.freshBite.entity.StockItemEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StockItemDaoImpl implements StockItemDao {
    public boolean save(StockItemEntity entity) throws SQLException {
            String sql = "INSERT INTO stock_item VALUES (?,?,?,?)";
            boolean isSaved = SQLUtil.execute(sql,entity.getStockId(),entity.getName(),entity.getPrice(),entity.getQuantity());

         return  isSaved;
    }

    public boolean update( StockItemEntity entity) throws SQLException {
            String sql = "UPDATE stock_item SET name=?,cost_price=?,quantity =? WHERE stock_id=?";

        return SQLUtil.execute(sql,entity.getName(),entity.getPrice(),entity.getQuantity(),entity.getStockId());
    }

    public boolean delete(String stockId) throws SQLException {
        String sql = "DELETE FROM stock_item WHERE stock_id=?";
        return  SQLUtil.execute(sql,stockId);
    }

    @Override
    public List<StockItemEntity> loadAll() throws SQLException {
        return null;
    }


    public String generateId() throws SQLException {
        String sql = "SELECT stock_id FROM stock_item ORDER BY stock_id DESC LIMIT 1";
        ResultSet resultSet =SQLUtil.execute(sql);
        while (resultSet.next()){
            return  generateNextId(resultSet.getString(1));
        }
        return  generateNextId(null);

    }

    private String generateNextId(String currentID) {
        if (currentID!=null){
            String numericPart = currentID.substring(1);
            int numericValue = Integer.parseInt(numericPart);
            numericValue++;
            String nextStockId = String.format("I%03d", numericValue);
            return nextStockId;
        }
        else {
            return "I001";
        }
    }


}
