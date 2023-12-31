package lk.ijse.freshBite.bo.custom;

import lk.ijse.freshBite.bo.SuperBo;
import lk.ijse.freshBite.dto.NotificationDto;
import lk.ijse.freshBite.entity.NotificationEntity;

import java.sql.SQLException;
import java.util.List;

public interface NotificationBo extends SuperBo {
    List<NotificationDto> getOutOfStockData() throws SQLException;
}
