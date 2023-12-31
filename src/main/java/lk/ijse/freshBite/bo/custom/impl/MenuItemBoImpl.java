package lk.ijse.freshBite.bo.custom.impl;

import lk.ijse.freshBite.bo.custom.MenuItemBo;
import lk.ijse.freshBite.dao.DaoFactory;
import lk.ijse.freshBite.dao.custom.*;
import lk.ijse.freshBite.dao.custom.impl.*;
import lk.ijse.freshBite.db.DbConnection;
import lk.ijse.freshBite.dto.AddMenuDto;
import lk.ijse.freshBite.dto.MenuItemDto;
import lk.ijse.freshBite.entity.AddMenuEntity;
import lk.ijse.freshBite.entity.OrderEntity;
import lk.ijse.freshBite.entity.OrderItemEntity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MenuItemBoImpl implements MenuItemBo {
    private OrderDao orderDao = (OrderDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.ORDERS);
    private OrderItemDao orderItemDao = (OrderItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.ORDER_ITEM);
    private AddMenuDao addMenuDao = (AddMenuDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.ADD_MENU);
    private MenuItemDao itemDao = (MenuItemDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.MENU_ITEM);
    private CustomerDetailDao customerDetailDao = (CustomerDetailDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.CUSTOMER);

    public boolean placeOrder(MenuItemDto dto) throws SQLException {
        Connection connection = null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            boolean isOrderSaved = orderDao.save(new OrderEntity(dto.getOrderId(),dto.getCustomerId(),dto.getDate(), LocalDateTime.now(),dto.getTotal()));
            if (isOrderSaved){
                boolean isUpdateItem =addMenuDao.updateItem(dto.getCartTmList());
                if (isUpdateItem){
                    boolean saveOrderDetails =orderItemDao.save(new OrderItemEntity(dto.getOrderId(),dto.getCartTmList()));
                    if (saveOrderDetails){
                        connection.commit();
                    }
                    else {
                        connection.rollback();;
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            connection.setAutoCommit(true);
        }
        return  true;
    }
   public String getMembership(String id) throws SQLException{
        return customerDetailDao.getMembership(id);

    }

    public List<AddMenuDto> getAllMenuItems() throws SQLException {
      List<AddMenuDto> dtoList = new ArrayList<>();
      List<AddMenuEntity> entities = itemDao.loadAll();
      for (AddMenuEntity entity : entities){
          dtoList.add(new AddMenuDto(entity.getItemId(),entity.getName(),entity.getMenu_type(),entity.getQty_on_hand(),entity.getUnit_Price(),
                  entity.getAvailability(),entity.getStockId(),entity.getImagePath()));
      }
        return dtoList;
    }

    public List<String> getAllCustId() throws SQLException {
       return itemDao.getAllCustId();
    }

    public String getName(String id) throws SQLException {
        return itemDao.getName(id);
    }



    public String generateOrderId() throws SQLException {
        return itemDao.generateId();

    }

}
