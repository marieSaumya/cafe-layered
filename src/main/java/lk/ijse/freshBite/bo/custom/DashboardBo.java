package lk.ijse.freshBite.bo.custom;

import lk.ijse.freshBite.bo.SuperBo;
import lk.ijse.freshBite.dto.IncomeDto;
import lk.ijse.freshBite.dto.ReservationDto;

import java.sql.SQLException;
import java.util.List;

public interface DashboardBo  extends SuperBo {

    int getCustomerCount() throws SQLException;

    int getTotalOrderCount() throws SQLException;

    double getTotalPriceOfToday() throws SQLException;

    List<ReservationDto> getTodayReservations() throws SQLException;

    List<IncomeDto> getIncomeDetails() throws SQLException;
}
