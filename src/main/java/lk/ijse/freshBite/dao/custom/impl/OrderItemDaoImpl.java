package lk.ijse.freshBite.dao.custom.impl;

import lk.ijse.freshBite.dao.custom.OrderItemDao;
import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.dto.tm.ItemCardTm;
import lk.ijse.freshBite.entity.OrderItemEntity;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderItemDaoImpl implements OrderItemDao {

    public boolean save(OrderItemEntity entity) throws SQLException, IOException {
        String itemId = null;
        for (ItemCardTm item : entity.getItemCardTmList()){
            itemId = getItemId(item.getItemName());
            if (!saveOrderDetails(entity.getOrder_id(),itemId, item.getPrice(), item.getQty())){
                return  false;
            }
        }
        return  true;
    }

    public boolean saveOrderDetails(String order_id,String item_id,double price,int qty) throws SQLException {
        String sql = "INSERT INTO order_item (order_id,item_id,item_price,quantity) VALUES (?,?,?,?)";
        return SQLUtil.execute(sql,order_id,item_id,price,qty);
    }

    @Override
    public boolean update(OrderItemEntity dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String Id) throws SQLException {
        return false;
    }

    @Override
    public List<OrderItemEntity> loadAll() throws SQLException {
        return null;
    }

    @Override
    public String generateId() throws SQLException {
        return null;
    }

    public String getItemId(String itemName) throws SQLException {
        String sql = "SELECT item_id FROM menu_item WHERE name=?";
        ResultSet resultSet = SQLUtil.execute(sql,itemName);
        while (resultSet.next()){
            return resultSet.getString(1);
        }
        return  null;
    }


  /*  public int getSoldUnits() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT\n" +
                "    DATE(order_time) AS order_date,\n" +
                "    SUM(quantity) AS total_quantity_day\n" +
                "FROM order_item\n" +
                "JOIN orders\n" +
                "ON order_item.order_id = orders.order_id\n" +
                "GROUP BY DATE(order_time)\n" +
                "ORDER BY order_date;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        int units = -1;
        while (resultSet.next()){
            units = resultSet.getInt(2);
        }
        return  units;
    }*/
}
