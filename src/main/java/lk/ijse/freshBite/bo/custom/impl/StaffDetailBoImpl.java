package lk.ijse.freshBite.bo.custom.impl;

import lk.ijse.freshBite.bo.custom.StaffDetailBo;
import lk.ijse.freshBite.dao.DaoFactory;
import lk.ijse.freshBite.dao.custom.StaffDetailDao;
import lk.ijse.freshBite.dao.custom.impl.StaffDetailDaoImpl;
import lk.ijse.freshBite.dto.StaffDetailDto;
import lk.ijse.freshBite.entity.StaffDetailEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDetailBoImpl implements StaffDetailBo {
    private StaffDetailDao staffDetailDao = (StaffDetailDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.STAFF);
    public boolean addEmployee(StaffDetailDto dto) throws SQLException, IOException {
        return staffDetailDao.save(new StaffDetailEntity(dto.getEmpId(),dto.getName(),dto.getAddress(),dto.getNic(),dto.getTelephone(),
                dto.getEmail(),dto.getJobRole(),dto.getChargePerHour(),dto.getQualification(),dto.getBarCode()));
    }

    public boolean updateEmployee(StaffDetailDto dto) throws SQLException {
        return staffDetailDao.update(new StaffDetailEntity(dto.getEmpId(),dto.getName(),dto.getAddress(),dto.getNic(),dto.getTelephone(),
                dto.getEmail(),dto.getJobRole(),dto.getChargePerHour(),dto.getQualification()));
    }

    public boolean deleteEmployee(String empId) throws SQLException {
        return staffDetailDao.delete(empId);
    }

    public List<StaffDetailDto> loadEmployees() throws SQLException {
      List<StaffDetailEntity> entities = staffDetailDao.loadAll();
      List<StaffDetailDto> dtoList = new ArrayList<>();
      for (StaffDetailEntity entity :entities){
          dtoList.add(new StaffDetailDto(entity.getEmpId(),entity.getName(),entity.getAddress(),entity.getNic(),entity.getTelephone(),entity.getEmail(),
                  entity.getJobRole(),entity.getChargePerHour(),entity.getQualification(),entity.getBarCode()));
      }
        return dtoList;
    }

    public String generateEmpId() throws SQLException {

        return staffDetailDao.generateId();
    }



    public String getBarcodePath(String text) throws SQLException {
       return staffDetailDao.getBarcodePath(text);
    }
}
