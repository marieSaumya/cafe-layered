package lk.ijse.freshBite.dao.custom.impl;

import lk.ijse.freshBite.dao.custom.OrderDao;
import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.entity.OrderEntity;

import java.sql.*;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

   /*public static List<TrendingItemDto> getTrendingItems() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql= "WITH total_ordered_items AS (\n" +
                "    SELECT\n" +
                "        order_item.item_id,\n" +
                "        SUM(order_item.quantity) AS total_quantity,\n" +
                "        menu_item.name AS item_name,\n" +
                "        menu_item.image_path\n" +
                "    FROM order_item\n" +
                "    JOIN menu_item\n" +
                "    ON order_item.item_id = menu_item.item_id\n" +
                "    GROUP BY order_item.item_id, menu_item.name, menu_item.image_path\n" +
                ")\n" +
                "\n" +
                "SELECT\n" +
                "    total_ordered_items.item_id,\n" +
                "    total_ordered_items.total_quantity,\n" +
                "    total_ordered_items.item_name,\n" +
                "    total_ordered_items.image_path\n" +
                "FROM total_ordered_items\n" +
                "ORDER BY total_ordered_items.total_quantity DESC\n" +
                "LIMIT 5";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<TrendingItemDto> list = new ArrayList<>();
        while (resultSet.next()){
            list.add(new TrendingItemDto(resultSet.getString(1), resultSet.getString(3),resultSet.getInt(2),resultSet.getString(4) ));
        }
        return list;
    }
*/
    public  boolean save(OrderEntity entity) throws SQLException {

        String sql = "INSERT INTO orders VALUES (?,?,?,?,?)";
        return SQLUtil.execute(sql,entity.getOrder_id(),entity.getCustomer_id(),entity.getDate(),entity.getOrder_time(),entity.getTotal());
    }

    @Override
    public boolean update(OrderEntity dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String Id) throws SQLException {
        return false;
    }

    @Override
    public List<OrderEntity> loadAll() throws SQLException {
        return null;
    }

    @Override
    public String generateId() throws SQLException {
        return null;
    }


    public Double getTotalRevenue() throws SQLException {

        String sql = "SELECT\n" +
                "    DATE(order_time) AS order_date,\n" +
                "    SUM(total_price) AS total_price_day\n" +
                "FROM orders\n" +
                "GROUP BY DATE(order_time)\n" +
                "ORDER BY order_date;";

        ResultSet resultSet = SQLUtil.execute(sql);
        double price = -1;
        while (resultSet.next()){
            price = resultSet.getDouble(2);
        }
        return  price;
    }
}
