package lk.ijse.freshBite.dao.custom.impl;

import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.dao.custom.SupplierDao;
import lk.ijse.freshBite.entity.SupplierEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoImpl implements SupplierDao {
    public boolean save(SupplierEntity entity) throws SQLException {
        String sql = "INSERT INTO supplier VALUES (?,?,?,?,?)";
        boolean isSaved = SQLUtil.execute(sql,entity.getSup_id(),entity.getName(),entity.getAddress(),entity.getTelephone(),entity.getEMail());
        return isSaved;
    }

    public List<SupplierEntity> loadAll() throws SQLException {
        String sql = "SELECT * FROM supplier";
       ResultSet resultSet = SQLUtil.execute(sql);
       List<SupplierEntity> entities = new ArrayList<>();
       while (resultSet.next()){
           entities.add(new SupplierEntity(resultSet.getString(1),
                   resultSet.getString(2),
                   resultSet.getString(3),
                   resultSet.getString(5),
                   resultSet.getString(4)));
       }
       return  entities;
    }

    @Override
    public String generateId() throws SQLException {
        return null;
    }

    public boolean update(SupplierEntity entity) throws SQLException {
        String sql = "UPDATE supplier SET name=?,address = ?,phone_number=?,email = ? WHERE sup_id = ?";
        boolean isUpdated =SQLUtil.execute(sql,entity.getName(),entity.getAddress(),entity.getTelephone(),entity.getEMail(),entity.getSup_id());
        return isUpdated;
    }

    public boolean delete(String supId) throws SQLException {
        String sql = "DELETE FROM supplier WHERE sup_id=?";
        return  SQLUtil.execute(sql,supId);
    }
    public List<String> getSupIdList() throws SQLException {
        String sql = "SELECT sup_id FROM supplier";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<String> list = new ArrayList<>();
        while (resultSet.next()){
            list.add(resultSet.getString(1));
        }
        return list;
    }
}
