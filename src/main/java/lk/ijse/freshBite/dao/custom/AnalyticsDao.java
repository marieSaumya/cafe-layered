package lk.ijse.freshBite.dao.custom;

import lk.ijse.freshBite.dao.CrudDao;
import lk.ijse.freshBite.dto.AnalyticsDto;
import lk.ijse.freshBite.entity.AnalyticsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface AnalyticsDao extends CrudDao<AnalyticsEntity> {
    Double getTotalRevenue() throws SQLException;
     List<AnalyticsEntity> getCustomerLocationData() throws SQLException ;
}
