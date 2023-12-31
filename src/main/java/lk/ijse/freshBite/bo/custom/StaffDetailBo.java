package lk.ijse.freshBite.bo.custom;

import lk.ijse.freshBite.bo.SuperBo;
import lk.ijse.freshBite.dto.StaffDetailDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface StaffDetailBo extends SuperBo {
    boolean addEmployee(StaffDetailDto dto) throws SQLException, IOException;
    boolean updateEmployee(StaffDetailDto dto) throws SQLException;
    boolean deleteEmployee(String empId) throws SQLException;
    List<StaffDetailDto> loadEmployees() throws SQLException;
    String generateEmpId() throws SQLException;
    String getBarcodePath(String text) throws SQLException;

}
