package lk.ijse.freshBite.bo.custom;

import lk.ijse.freshBite.bo.SuperBo;
import lk.ijse.freshBite.dto.ReservationDto;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface ReservationBo extends SuperBo {
    boolean saveReservation(ReservationDto dto) throws SQLException, IOException;
    boolean deleteReservation(String reservationId) throws SQLException;
    boolean updateReservation(ReservationDto dto) throws SQLException;
    List<ReservationDto> getAllReservations() throws SQLException;
    List<ReservationDto> getAllReservationListOnDate(LocalDate date) throws SQLException;
    List<ReservationDto> getAllReservationListtodayDate() throws SQLException;
    String generateNextId() throws SQLException;
    boolean completeReservation(String id) throws SQLException;
    boolean unCompleteReservation(String id) throws SQLException;
    boolean checkComplete(String id) throws SQLException;
    List<String> loadCustomerId() throws SQLException;

}
