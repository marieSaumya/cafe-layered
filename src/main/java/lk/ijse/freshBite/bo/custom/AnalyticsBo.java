package lk.ijse.freshBite.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.freshBite.bo.SuperBo;
import lk.ijse.freshBite.dto.AnalyticsDto;
import lk.ijse.freshBite.dto.ExpenseDataDto;
import lk.ijse.freshBite.dto.SalesDataDto;
import lk.ijse.freshBite.dto.TrendingItemDto;
import lk.ijse.freshBite.entity.AnalyticsEntity;
import lk.ijse.freshBite.entity.ExpenseDataEntity;
import lk.ijse.freshBite.entity.SalesDataEntity;
import lk.ijse.freshBite.entity.TrendingItemEntity;

import java.sql.SQLException;
import java.util.List;

public interface AnalyticsBo extends SuperBo {
    int getSoldUnits() throws SQLException;
    List<TrendingItemDto> getTrendingItems() throws SQLException;
    ObservableList<ExpenseDataDto> getDailyChartData() throws SQLException;
    ObservableList<ExpenseDataDto> getWeeklyChartData() throws SQLException;
    ObservableList<ExpenseDataDto> getMonthluChartData() throws SQLException;
    List<SalesDataDto> getSalesData() throws SQLException;
    Double getTotalRevenue() throws SQLException;
    List<AnalyticsDto> getCustomerLocationData() throws SQLException;

}
