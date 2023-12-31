package lk.ijse.freshBite.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.freshBite.dao.custom.QueryDao;
import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.db.DbConnection;
import lk.ijse.freshBite.entity.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QueryDaoImpl implements QueryDao {

    public List<ReservationEntity> getTodayReservations() throws SQLException {

        String sql = "SELECT * from reservations r inner join customers c on r.customer_id= c.customer_id WHERE date=? ";

        ResultSet resultSet = SQLUtil.execute(sql,String.valueOf(LocalDate.now()));
        List<ReservationEntity> entityList = new ArrayList<>();
        while (resultSet.next()){
            entityList.add(new ReservationEntity(resultSet.getString(1),
                    resultSet.getDate(4).toLocalDate(),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getString(3),
                    resultSet.getString(13),
                    resultSet.getInt(7),
                    resultSet.getString(10)
            ));
        }
        return entityList;
    }
    public List<ReservationEntity> getAllReservationListOnDate(LocalDate date) throws SQLException {
        String sql = "SELECT * from reservations r inner join customers c on r.customer_id= c.customer_id WHERE date=?";
        ResultSet resultSet =SQLUtil.execute(sql,Date.valueOf(date));
        List<ReservationEntity> entityList = new ArrayList<>();
        while (resultSet.next()){
            entityList.add(new ReservationEntity(resultSet.getString(1),
                    resultSet.getDate(4).toLocalDate(),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getString(3),
                    resultSet.getString(13),
                    resultSet.getInt(7),
                    resultSet.getString(10)
            ));
        }
        return entityList;

    }
    public List<ReservationEntity> getAllReservationListtodayDate() throws SQLException {
        String sql = "SELECT * from reservations r inner join customers c on r.customer_id= c.customer_id WHERE date=?";
        ResultSet resultSet = SQLUtil.execute(sql,Date.valueOf(LocalDate.now()));
        List<ReservationEntity> entityList = new ArrayList<>();
        while (resultSet.next()){
            entityList.add(new ReservationEntity(resultSet.getString(1),
                    resultSet.getDate(4).toLocalDate(),
                    resultSet.getString(5),
                    resultSet.getInt(6),
                    resultSet.getString(3),
                    resultSet.getString(13),
                    resultSet.getInt(7),
                    resultSet.getString(10)
            ));
        }
        return entityList;
    }

    public int getSoldUnits() throws SQLException {
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
    }
    public  List<TrendingItemEntity> getTrendingItems() throws SQLException {
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
        ResultSet resultSet = SQLUtil.execute(sql);
        List<TrendingItemEntity> list = new ArrayList<>();
        while (resultSet.next()){
            list.add(new TrendingItemEntity(resultSet.getString(1), resultSet.getString(3),resultSet.getInt(2),resultSet.getString(4) ));
        }
        return list;
    }
    public ObservableList<ExpenseDataEntity> getDailyChartData() throws SQLException {
        String sql = "SELECT \n" +
                "DATE(date) AS expense_date,\n" +
                "  SUM(stock_item.cost_price * stock_item.quantity) AS daily_expense\n" +
                "FROM stock_item\n" +
                "JOIN item_supply_details  \n" +
                "ON stock_item.stock_id = item_supply_details .stock_id\n" +
                "GROUP BY DATE(date)\n" +
                "ORDER BY expense_date;";
        ResultSet resultSet = SQLUtil.execute(sql);
        ObservableList<ExpenseDataEntity> observableList = FXCollections.observableArrayList();
        while (resultSet.next()){
            observableList.add(new ExpenseDataEntity(resultSet.getString(1),resultSet.getDouble(2)));
        }
        return observableList;
    }

    public ObservableList<ExpenseDataEntity> getWeeklyChartData() throws SQLException {
        String sql = "SELECT\n" +
                "  WEEK(date) AS expense_week,\n" +
                "  SUM(stock_item.cost_price * stock_item.quantity) AS weekly_expense\n" +
                "FROM stock_item\n" +
                "JOIN item_supply_details \n" +
                "ON item_supply_details .stock_id = stock_item.stock_id\n" +
                "GROUP BY WEEK(date)\n" +
                "ORDER BY expense_week;";
        ResultSet resultSet =SQLUtil.execute(sql);
        ObservableList<ExpenseDataEntity> observableList = FXCollections.observableArrayList();
        while (resultSet.next()){
            observableList.add(new ExpenseDataEntity(resultSet.getString(1),resultSet.getDouble(2)));
        }
        return observableList;
    }

    public ObservableList<ExpenseDataEntity> getMonthluChartData() throws SQLException {
        String sql = "SELECT\n" +
                "  MONTHNAME(date) AS expense_month,\n" +
                "  SUM(stock_item.cost_price * stock_item.quantity) AS monthly_expense\n" +
                "FROM stock_item\n" +
                "JOIN item_supply_details\n" +
                "ON item_supply_details.stock_id = stock_item.stock_id\n" +
                "GROUP BY MONTHNAME(date)\n" +
                "ORDER BY expense_month;";
        ResultSet resultSet =SQLUtil.execute(sql);
        ObservableList<ExpenseDataEntity> observableList = FXCollections.observableArrayList();
        while (resultSet.next()){
            observableList.add(new ExpenseDataEntity(resultSet.getString(1),resultSet.getDouble(2)));
        }
        return observableList;
    }

    public List<SalesDataEntity> getSalesData() throws SQLException {
        String sql = "SELECT\n" +
                "        i.name AS item_name,\n" +
                "        i.unit_price,\n" +
                "         oi.quantity AS quantity_sold,\n" +
                "         oi.item_price AS total_price,\n" +
                "        o.customer_id,\n" +
                "        o.date AS transaction_date\n" +
                "     FROM\n" +
                "         order_item oi\n" +
                "     JOIN\n" +
                "         orders o ON oi.order_id = o.order_id\n" +
                "       JOIN\n" +
                "        menu_item i ON oi.item_id = i.item_id\n" +
                "      ORDER BY o.date DESC";
        ResultSet resultSet =SQLUtil.execute(sql);
        List<SalesDataEntity> list = new ArrayList<>();
        while (resultSet.next()){
            list.add(new SalesDataEntity(resultSet.getString(1),
                    resultSet.getDouble(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5),
                    resultSet.getString(6) ));
        }
        return list;
    }
    public List<StockEntity> loadItems() throws SQLException {
        String sql = "SELECT si.stock_id,si.name,si.cost_price,si.quantity,isd.date,isd.supplier_id  FROM stock_item si JOIN item_supply_details isd ON si.stock_id = isd.stock_id";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<StockEntity> stockItems = new ArrayList<>();
        while (resultSet.next()){
            stockItems.add(new StockEntity(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(4),
                    resultSet.getDouble(3),
                    resultSet.getString(6),
                    resultSet.getDate(5).toLocalDate()));
        }
        return stockItems;

    }
    public List<NotificationEntity> getOutOfStockData() throws SQLException {
        String sql ="SELECT\n" +
                "  menu_item.name AS item_name,\n" +
                "  supplier.name AS supplier_name,\n" +
                "  supplier.phone_number\n" +
                "FROM menu_item\n" +
                "JOIN item_supply_details\n" +
                "ON menu_item.stock_id = item_supply_details.stock_id\n" +
                "JOIN supplier\n" +
                "ON item_supply_details.supplier_id = supplier.sup_id\n" +
                "WHERE menu_item.qty_on_hand = 0;";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<NotificationEntity> entities = new ArrayList<>();
        while (resultSet.next()){
            entities.add(new NotificationEntity(resultSet.getString(1),resultSet.getString(3),resultSet.getString(2)));
        }
        return  entities;
    }
}
