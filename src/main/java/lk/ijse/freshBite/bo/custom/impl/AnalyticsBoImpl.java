package lk.ijse.freshBite.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.freshBite.bo.custom.AnalyticsBo;
import lk.ijse.freshBite.dao.DaoFactory;
import lk.ijse.freshBite.dao.custom.AnalyticsDao;
import lk.ijse.freshBite.dao.custom.impl.AnalyticsDaoImpl;
import lk.ijse.freshBite.dao.custom.QueryDao;
import lk.ijse.freshBite.dao.custom.impl.QueryDaoImpl;
import lk.ijse.freshBite.dto.AnalyticsDto;
import lk.ijse.freshBite.dto.ExpenseDataDto;
import lk.ijse.freshBite.dto.SalesDataDto;
import lk.ijse.freshBite.dto.TrendingItemDto;
import lk.ijse.freshBite.entity.AnalyticsEntity;
import lk.ijse.freshBite.entity.ExpenseDataEntity;
import lk.ijse.freshBite.entity.SalesDataEntity;
import lk.ijse.freshBite.entity.TrendingItemEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnalyticsBoImpl implements AnalyticsBo {
    private QueryDao  queryDao = (QueryDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.QUERY);
    private AnalyticsDao analyticsDao = (AnalyticsDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.ANALYTICS);

    @Override
    public int getSoldUnits() throws SQLException {
      return queryDao.getSoldUnits();
    }

    @Override
    public List<TrendingItemDto> getTrendingItems() throws SQLException {
        List<TrendingItemEntity> entities = queryDao.getTrendingItems();
        List<TrendingItemDto> dtoList = new ArrayList<>();
        for (TrendingItemEntity entity : entities){
            dtoList.add(new TrendingItemDto(entity.getItemId(),entity.getItemName(),entity.getQuantity(),entity.getImagePath()));
        }
        return dtoList;
    }

    @Override
    public ObservableList<ExpenseDataDto> getDailyChartData() throws SQLException {
       ObservableList<ExpenseDataEntity> entities = queryDao.getDailyChartData();
       ObservableList<ExpenseDataDto> dtos = FXCollections.observableArrayList();
       for (ExpenseDataEntity entity : entities){
           dtos.add(new ExpenseDataDto(entity.getDate(),entity.getExpenseAmount()));
       }
       return  dtos;
    }

    @Override
    public ObservableList<ExpenseDataDto> getWeeklyChartData() throws SQLException {
        ObservableList<ExpenseDataEntity> entities = queryDao.getWeeklyChartData();
        ObservableList<ExpenseDataDto> dtos = FXCollections.observableArrayList();
        for (ExpenseDataEntity entity : entities){
            dtos.add(new ExpenseDataDto(entity.getDate(),entity.getExpenseAmount()));
        }
        return  dtos;
    }

    @Override
    public ObservableList<ExpenseDataDto> getMonthluChartData() throws SQLException {
        ObservableList<ExpenseDataEntity> entities = queryDao.getMonthluChartData();
        ObservableList<ExpenseDataDto> dtos = FXCollections.observableArrayList();
        for (ExpenseDataEntity entity : entities){
            dtos.add(new ExpenseDataDto(entity.getDate(),entity.getExpenseAmount()));
        }
        return  dtos;

    }

    @Override
    public List<SalesDataDto> getSalesData() throws SQLException {
       List<SalesDataEntity> entities = queryDao.getSalesData();
       List<SalesDataDto> dtoList = new ArrayList<>();
       for (SalesDataEntity entity : entities){
           dtoList.add(new SalesDataDto(entity.getItemName(),entity.getUnitPrice(),entity.getTotalQuantity(),entity.getTotalPrice(),entity.getCustomerId(),entity.getTransactionDate()));
       }
       return dtoList;

    }

    @Override
    public Double getTotalRevenue() throws SQLException {
       return analyticsDao.getTotalRevenue();
    }

    @Override
    public List<AnalyticsDto> getCustomerLocationData() throws SQLException {
       List<AnalyticsEntity> entities = analyticsDao.getCustomerLocationData();
       List<AnalyticsDto> dtoList = new ArrayList<>();
       for (AnalyticsEntity entity:entities){
           dtoList.add(new AnalyticsDto(entity.getLocation(),entity.getCustomerCount()));
       }
       return dtoList;
    }
}
