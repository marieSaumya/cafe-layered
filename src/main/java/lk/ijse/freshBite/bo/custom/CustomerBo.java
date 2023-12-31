package lk.ijse.freshBite.bo.custom;

import lk.ijse.freshBite.bo.SuperBo;
import lk.ijse.freshBite.dto.CustomerDetailDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CustomerBo extends SuperBo {
     boolean saveCustomer(CustomerDetailDto customerDetailDto) throws SQLException, IOException;

     boolean updateCustomer(CustomerDetailDto customerDetailDto) throws SQLException;

     boolean deleteCustomer(String id) throws SQLException ;

     List<CustomerDetailDto> loadCustomers() throws SQLException;

     String generateCustomerId() throws SQLException;







}
