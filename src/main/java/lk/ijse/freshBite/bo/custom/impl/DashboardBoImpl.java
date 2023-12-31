package lk.ijse.freshBite.bo.custom.impl;

import lk.ijse.freshBite.bo.custom.DashboardBo;
import lk.ijse.freshBite.dao.DaoFactory;
import lk.ijse.freshBite.dao.custom.QueryDao;
import lk.ijse.freshBite.dao.custom.impl.QueryDaoImpl;
import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.dto.IncomeDto;
import lk.ijse.freshBite.dto.ReservationDto;
import lk.ijse.freshBite.entity.ReservationEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DashboardBoImpl implements DashboardBo {
    private QueryDao queryDao = (QueryDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.QUERY);

    public int getCustomerCount() throws SQLException {

        String sql = "SELECT count(*) AS avgCustomers FROM customers ";

        ResultSet resultSet = SQLUtil.execute(sql);
        int totalCustomers = -1;
        while (resultSet.next()){
            totalCustomers = resultSet.getInt(1);
        }
        return  totalCustomers;
    }
    public int getTotalOrderCount() throws SQLException {
        String sql = "SELECT count(*) AS totalOrders FROM orders WHERE date = ?";
        ResultSet resultSet = SQLUtil.execute(sql,String.valueOf(LocalDate.now()));
        int totalOrders = -1;
        while (resultSet.next()){
            totalOrders = resultSet.getInt(1);
        }
        return  totalOrders;
    }

    public double getTotalPriceOfToday() throws SQLException {

        String sql = "SELECT total_price FROM orders WHERE date = ?";
        ResultSet resultSet = SQLUtil.execute(sql,String.valueOf(LocalDate.now()));
        double price = -1;
        while (resultSet.next()){
            price+= resultSet.getDouble(1);
        }
        return  price;
    }

    public List<ReservationDto> getTodayReservations() throws SQLException {
        List<ReservationEntity> entityList = queryDao.getTodayReservations();
        List<ReservationDto> dtoList = new ArrayList<>();
        for (ReservationEntity entity:entityList){
            dtoList.add(new ReservationDto(entity.getId(), entity.getDate(),entity.getTime(),entity.getTableNo(),
                    entity.getCustId(),entity.getTelephone(),entity.getSize(),entity.getName()));
        }
        return dtoList;
    }
    public List<IncomeDto> getIncomeDetails() throws SQLException {

        String sql = "SELECT DATE(date) AS order_date, SUM(total_price) AS daily_income FROM orders GROUP BY DATE(date) ORDER BY TIMESTAMP(order_date)";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<IncomeDto> list = new ArrayList<>();
        while (resultSet.next()){
            list.add(new IncomeDto(resultSet.getString(1),resultSet.getDouble(2)));
        }
        return list;
    }
}

