package lk.ijse.freshBite.dao.custom;

import lk.ijse.freshBite.dao.CrudDao;
import lk.ijse.freshBite.dto.ReservationDto;
import lk.ijse.freshBite.entity.ReservationEntity;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface ReservationDao extends CrudDao<ReservationEntity> {

    boolean completeReservation(String id) throws SQLException;
    boolean unCompleteReservation(String id) throws SQLException;
    boolean checkComplete(String id) throws SQLException;
}
