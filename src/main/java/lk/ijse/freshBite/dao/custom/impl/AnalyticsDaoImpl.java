package lk.ijse.freshBite.dao.custom.impl;

import lk.ijse.freshBite.dao.custom.AnalyticsDao;
import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.entity.AnalyticsEntity;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnalyticsDaoImpl implements AnalyticsDao {
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
    public List<AnalyticsEntity> getCustomerLocationData() throws SQLException {
        String sql = "SELECT address, COUNT(DISTINCT customer_id) AS customer_count\n" +
                "FROM customers\n" +
                "GROUP BY address\n" +
                "ORDER BY customer_count DESC";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<AnalyticsEntity> list = new ArrayList<>();
        while (resultSet.next()){
            list.add(new AnalyticsEntity(resultSet.getString(1),resultSet.getInt(2)));
        }
        return list;
    }

    @Override
    public boolean save(AnalyticsEntity dto) throws SQLException, IOException {
        return false;
    }

    @Override
    public boolean update(AnalyticsEntity dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String Id) throws SQLException {
        return false;
    }

    @Override
    public List<AnalyticsEntity> loadAll() throws SQLException {
        return null;
    }

    @Override
    public String generateId() throws SQLException {
        return null;
    }
}
