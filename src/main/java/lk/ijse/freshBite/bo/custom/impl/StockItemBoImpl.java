package lk.ijse.freshBite.bo.custom.impl;

import lk.ijse.freshBite.bo.custom.StockItemBo;
import lk.ijse.freshBite.dao.DaoFactory;
import lk.ijse.freshBite.dao.custom.QueryDao;
import lk.ijse.freshBite.dao.custom.StockItemDao;
import lk.ijse.freshBite.dao.custom.SupStockDao;
import lk.ijse.freshBite.dao.custom.SupplierDao;
import lk.ijse.freshBite.dao.custom.impl.QueryDaoImpl;
import lk.ijse.freshBite.dao.custom.impl.StockItemDaoImpl;
import lk.ijse.freshBite.dao.custom.impl.SupStockDaoImpl;
import lk.ijse.freshBite.dao.custom.impl.SupplierDaoImpl;
import lk.ijse.freshBite.db.DbConnection;
import lk.ijse.freshBite.dto.StockDto;
import lk.ijse.freshBite.entity.StockEntity;
import lk.ijse.freshBite.entity.StockItemEntity;
import lk.ijse.freshBite.entity.Sup_StockEntity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockItemBoImpl implements StockItemBo {
    private StockItemDao itemDao = (StockItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.STOCK);
    private SupStockDao supStockDao = (SupStockDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.SUP_STOCK);
    private QueryDao queryDao = (QueryDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.QUERY);
    private SupplierDao supplierDao = (SupplierDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.SUPPLIER);
    public boolean addItems(StockDto dto) throws SQLException {
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isSaved = itemDao.save(new StockItemEntity(dto.getStockId(), dto.getName(), dto.getQuantity(),dto.getPrice()));
            if (isSaved){

                boolean isInsert = supStockDao.save(new Sup_StockEntity(dto.getSup_id(), dto.getStockId(), dto.getDate(),dto.getQuantity()));
                if (isInsert){
                    connection.commit();
                }
                else {
                    connection.rollback();
                }
            }

        } catch (SQLException e) {
            connection.rollback();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            connection.setAutoCommit(true);
        }

        return  true;

    }



    public boolean updateItems( StockDto dto) throws SQLException {
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isSaved = itemDao.update(new StockItemEntity(dto.getStockId(), dto.getName(), dto.getQuantity(),dto.getPrice()));
            if (isSaved){
                boolean updated = supStockDao.update(new Sup_StockEntity(dto.getSup_id(), dto.getStockId(), dto.getDate(),dto.getQuantity()));
                if (updated){
                    connection.commit();
                }
                else {
                    connection.rollback();
                }
            }

        } catch (SQLException e) {
            connection.rollback();
        }
        finally {
            connection.setAutoCommit(true);
        }
        return true;
    }

    public boolean deleteItem(String stockId) throws SQLException {
        return itemDao.delete(stockId);
    }

    public List<StockDto> loadItems() throws SQLException {
       List<StockEntity> entities = queryDao.loadItems();
       List<StockDto> stockItems = new ArrayList<>();
       for (StockEntity entity:entities){
           stockItems.add(new StockDto(entity.getStockId(),entity.getName(),
                   entity.getQuantity(),entity.getPrice(),entity.getSup_id(),entity.getDate()));
       }
        return stockItems;

    }

    @Override
    public List<String> getSupIdList() throws SQLException {
       return supplierDao.getSupIdList();
    }

    public String getNextStockId() throws SQLException {
        return itemDao.generateId();

    }
}
