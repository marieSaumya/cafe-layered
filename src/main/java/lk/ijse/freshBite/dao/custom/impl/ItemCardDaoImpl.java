package lk.ijse.freshBite.dao.custom.impl;

import lk.ijse.freshBite.dao.custom.ItemCardDao;
import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.entity.AddMenuEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemCardDaoImpl implements ItemCardDao {

    public String getStatus(String name) throws SQLException {
        String sql = "SELECT availability FROM menu_item WHERE name = ?";
        String menuName = null;
        ResultSet resultSet = SQLUtil.execute(sql,name);
        while (resultSet.next()){
            menuName =resultSet.getString(1);
        }
        return  menuName;

    }

    public AddMenuEntity getItemDetails(String name) throws SQLException {
        String sql = "SELECT * FROM menu_item WHERE name=?";
        ResultSet resultSet= SQLUtil.execute(sql,name);
        AddMenuEntity entity = null;
        while (resultSet.next()){
            entity = new AddMenuEntity(resultSet.getString(1),resultSet.getString(2),resultSet.getString(4),resultSet.getInt(5),resultSet.getDouble(3),resultSet.getString(7),resultSet.getString(6),resultSet.getString(8));
        }
        return  entity;
    }
}
