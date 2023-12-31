package lk.ijse.freshBite.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.freshBite.dao.SuperDao;
import lk.ijse.freshBite.dto.ReservationDto;
import lk.ijse.freshBite.dto.StockDto;
import lk.ijse.freshBite.dto.TrendingItemDto;
import lk.ijse.freshBite.entity.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface QueryDao extends SuperDao {
    List<ReservationEntity> getTodayReservations() throws SQLException;
    List<ReservationEntity> getAllReservationListOnDate(LocalDate date) throws SQLException;
    List<ReservationEntity> getAllReservationListtodayDate() throws SQLException;
    int getSoldUnits() throws SQLException;
    List<TrendingItemEntity> getTrendingItems() throws SQLException;
    ObservableList<ExpenseDataEntity> getDailyChartData() throws SQLException;
    ObservableList<ExpenseDataEntity> getWeeklyChartData() throws SQLException;
    ObservableList<ExpenseDataEntity> getMonthluChartData() throws SQLException;
    List<SalesDataEntity> getSalesData() throws SQLException;
    List<StockEntity> loadItems() throws SQLException;
    List<NotificationEntity> getOutOfStockData() throws SQLException;

}
