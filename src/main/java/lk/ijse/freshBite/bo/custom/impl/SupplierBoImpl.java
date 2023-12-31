package lk.ijse.freshBite.bo.custom.impl;

import lk.ijse.freshBite.bo.custom.SupplierBo;
import lk.ijse.freshBite.dao.DaoFactory;
import lk.ijse.freshBite.dao.custom.SupplierDao;
import lk.ijse.freshBite.dao.custom.impl.SupplierDaoImpl;
import lk.ijse.freshBite.dto.SupplierDto;
import lk.ijse.freshBite.entity.SupplierEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierBoImpl implements SupplierBo {
    private SupplierDao supplierDao = (SupplierDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.SUPPLIER);
    public boolean addSupplier(SupplierDto dto) throws SQLException, IOException {
        return supplierDao.save(new SupplierEntity(dto.getSup_id(), dto.getName(),dto.getAddress(),dto.getEMail(),dto.getTelephone()));
    }

    public List<SupplierDto> loadSupplier() throws SQLException {
       List<SupplierEntity> entities = supplierDao.loadAll();
       List<SupplierDto> dtoList = new ArrayList<>();
       for (SupplierEntity entity : entities){
           dtoList.add(new SupplierDto(entity.getSup_id(), entity.getName(), entity.getAddress(), entity.getEMail(), entity.getTelephone()));
       }
        return  dtoList;
    }

    public boolean updateSupplier(SupplierDto dto) throws SQLException {
        return supplierDao.update(new SupplierEntity(dto.getSup_id(), dto.getName(),dto.getAddress(),dto.getEMail(),dto.getTelephone()));
    }

    public boolean deleteSupplier(String supId) throws SQLException {
        return supplierDao.delete(supId);
    }
}
