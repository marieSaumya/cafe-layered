package lk.ijse.freshBite.bo.custom;

import lk.ijse.freshBite.bo.SuperBo;
import lk.ijse.freshBite.dto.SupplierDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface SupplierBo extends SuperBo {
    boolean addSupplier(SupplierDto dto) throws SQLException, IOException;
    List<SupplierDto> loadSupplier() throws SQLException;
    boolean updateSupplier(SupplierDto supplierDto) throws SQLException;
    boolean deleteSupplier(String supId) throws SQLException;
}
