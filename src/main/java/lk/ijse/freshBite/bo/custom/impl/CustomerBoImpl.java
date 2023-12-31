package lk.ijse.freshBite.bo.custom.impl;

import lk.ijse.freshBite.bo.custom.CustomerBo;
import lk.ijse.freshBite.dao.DaoFactory;
import lk.ijse.freshBite.dao.custom.CustomerDetailDao;
import lk.ijse.freshBite.dao.custom.impl.CustomerDetailDaoImpl;
import lk.ijse.freshBite.dto.CustomerDetailDto;
import lk.ijse.freshBite.entity.CustomerEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {
    private CustomerDetailDao customerDetailDao = (CustomerDetailDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.CUSTOMER);
    public boolean saveCustomer(CustomerDetailDto customerDetailDto) throws SQLException, IOException {
     return customerDetailDao.save(new CustomerEntity(customerDetailDto.getCustId(), customerDetailDto.getName(),customerDetailDto.getAddress(),
             customerDetailDto.getTelephone(),customerDetailDto.getEmail(),customerDetailDto.getGender(),customerDetailDto.getMembership()));

    }

    public boolean updateCustomer(CustomerDetailDto customerDetailDto) throws SQLException {
       return customerDetailDao.update(new CustomerEntity(customerDetailDto.getCustId(), customerDetailDto.getName(),customerDetailDto.getAddress(),
               customerDetailDto.getTelephone(),customerDetailDto.getEmail(),customerDetailDto.getGender(),customerDetailDto.getMembership()));
    }
    public boolean deleteCustomer(String id) throws SQLException {
        return customerDetailDao.delete(id);
    }

    public List<CustomerDetailDto> loadCustomers() throws SQLException {
     List<CustomerEntity> entityList = customerDetailDao.loadAll();
     List<CustomerDetailDto> dtoList = new ArrayList<>();
     for (CustomerEntity entity : entityList){
         dtoList.add(new CustomerDetailDto(entity.getCustomer_id(),entity.getName(),entity.getAddress(),
                 entity.getTelephone(),entity.getEmail(),entity.getGender(),entity.getMembership_level()));
     }
     return dtoList;

    }

    public String generateCustomerId() throws SQLException {
       return customerDetailDao.generateId();
    }







}
