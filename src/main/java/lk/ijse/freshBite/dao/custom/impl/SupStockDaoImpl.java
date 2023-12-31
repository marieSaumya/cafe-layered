package lk.ijse.freshBite.dao.custom.impl;

import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.dao.custom.SupStockDao;
import lk.ijse.freshBite.entity.Sup_StockEntity;

import java.sql.SQLException;
import java.util.List;

public class SupStockDaoImpl implements SupStockDao {
    public boolean save(Sup_StockEntity entity) throws SQLException {

                String sql = "INSERT INTO item_supply_details(supplier_id,stock_id,date,quantity) VALUES (?,?,?,?)";
                return SQLUtil.execute(sql,entity.getSup_id(),entity.getStockId(),entity.getDate(),entity.getQuantity());

    }



    public boolean update( Sup_StockEntity entity) throws SQLException {

                String sql = "UPDATE item_supply_details SET supplier_id=?,quantity = ?,date=? WHERE stock_id=?" ;

                return  SQLUtil.execute(sql,entity.getSup_id(),entity.getQuantity(),entity.getDate(),entity.getStockId());
    }

    @Override
    public boolean delete(String Id) throws SQLException {
        return false;
    }

    @Override
    public List<Sup_StockEntity> loadAll() throws SQLException {
        return null;
    }

    @Override
    public String generateId() throws SQLException {
        return null;
    }


}
