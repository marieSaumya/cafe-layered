package lk.ijse.freshBite.dao.custom.impl;

import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.dao.custom.StaffDetailDao;
import lk.ijse.freshBite.entity.StaffDetailEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDetailDaoImpl implements StaffDetailDao {
    public boolean save(StaffDetailEntity entity) throws SQLException {
        String sql = "INSERT INTO Employee VALUES (?,?,?,?,?,?,?,?,?,?)";
       return SQLUtil.execute(sql,entity.getEmpId(),entity.getName(),entity.getNic(),
               entity.getTelephone(),entity.getAddress(),entity.getEmail(),entity.getJobRole(),
               entity.getChargePerHour(),entity.getQualification(),entity.getBarCode());
    }

    public boolean update(StaffDetailEntity entity) throws SQLException {
        String sql = "UPDATE Employee SET name=?,NIC=?,phone_number=?,address=?,email=?,job_role=?,charge_per_hour=?,qualification=? WHERE Emp_id=?";
        return SQLUtil.execute(sql,entity.getName(),entity.getNic(),
                entity.getTelephone(),entity.getAddress(),entity.getEmail(),entity.getJobRole(),
                entity.getChargePerHour(),entity.getQualification(),entity.getBarCode(),entity.getEmpId());

    }

    public boolean delete(String empId) throws SQLException {
        String sql = "DELETE FROM Employee WHERE Emp_id =?";
        return SQLUtil.execute(sql,empId);
    }

    public List<StaffDetailEntity> loadAll() throws SQLException {
        String sql = "SELECT * FROM Employee";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<StaffDetailEntity> entities = new ArrayList<>();
        while (resultSet.next()){
            entities.add(new StaffDetailEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(3),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getDouble(8),
                    resultSet.getString(9)
            ));

        }
        return entities;
    }

    public String generateId() throws SQLException {
        String sql = "SELECT Emp_id FROM Employee ORDER BY Emp_id DESC LIMIT 1";
        ResultSet resultSet = SQLUtil.execute(sql);
        while (resultSet.next()){
            return getNextId(  resultSet.getString(1));
        }
        return getNextId(null);
    }

    private String getNextId(String currentId) {

        if (currentId!= null){
            String numericPart = currentId.substring(1);
            int numericValue = Integer.parseInt(numericPart);
            numericValue++;
            String nextStockId = String.format("E%03d", numericValue);
            return nextStockId;
        }
        else {
            return "E001";
        }
    }

    public String getBarcodePath(String text) throws SQLException {
        String sql = "SELECT barcode_data FROM Employee WHERE Emp_id = ?";
        ResultSet resultSet = SQLUtil.execute(sql,text);
        while (resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
}
