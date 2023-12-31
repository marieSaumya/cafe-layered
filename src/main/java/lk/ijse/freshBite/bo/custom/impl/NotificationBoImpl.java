package lk.ijse.freshBite.bo.custom.impl;

import lk.ijse.freshBite.bo.custom.NotificationBo;
import lk.ijse.freshBite.dao.DaoFactory;
import lk.ijse.freshBite.dao.custom.QueryDao;
import lk.ijse.freshBite.dao.custom.impl.QueryDaoImpl;
import lk.ijse.freshBite.dto.NotificationDto;
import lk.ijse.freshBite.entity.NotificationEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationBoImpl implements NotificationBo {
    private QueryDao queryDao = (QueryDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.QUERY);
    @Override
    public List<NotificationDto> getOutOfStockData() throws SQLException {
        List<NotificationEntity> entities = queryDao.getOutOfStockData();
        List<NotificationDto> dtos = new ArrayList<>();
        for (NotificationEntity entity:entities){
            dtos.add(new NotificationDto(entity.getItemName(), entity.getTelephone(), entity.getSup_name()));
        }
        return dtos;
    }
}
