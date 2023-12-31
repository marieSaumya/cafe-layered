package lk.ijse.freshBite.dao.custom.impl;

import lk.ijse.freshBite.dao.custom.CustomerDetailDao;
import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.db.DbConnection;
import lk.ijse.freshBite.entity.CustomerEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDetailDaoImpl implements CustomerDetailDao {
    public boolean save(CustomerEntity entity) throws SQLException {

        String sql = "INSERT INTO customers VALUES (?,?,?,?,?,?,?)";
        return  SQLUtil.execute(sql,entity.getCustomer_id(),entity.getName(),entity.getAddress(),
                entity.getEmail(),entity.getTelephone(),entity.getGender(),entity.getMembership_level());

    }

    public boolean update(CustomerEntity entity) throws SQLException {
        String sql = "UPDATE customers SET name=?,address =?,email=?,phone_no=?,gender=?,membership_level=? WHERE  customer_id=?";

        return SQLUtil.execute(sql,entity.getName(),entity.getAddress(),
                entity.getEmail(),entity.getTelephone(),entity.getGender(),entity.getMembership_level(),entity.getCustomer_id());
    }

    public boolean delete(String id) throws SQLException {
        String sql = "DELETE customers WHERE customer_id =?";

        return SQLUtil.execute(sql,id);
    }

    public List<CustomerEntity> loadAll() throws SQLException {

        String sql = "SELECT * FROM customers ";
        List<CustomerEntity> entityList = new ArrayList<>();
      ResultSet resultSet = SQLUtil.execute(sql);
      while (resultSet.next()){
          entityList.add(new CustomerEntity(
                  resultSet.getString(1),
                  resultSet.getString(2),
                  resultSet.getString(3),
                  resultSet.getString(5),
                  resultSet.getString(4),
                  resultSet.getString(6),
                  resultSet.getString(7)
          ));
      }
      return  entityList;
    }

    public String generateId() throws SQLException {

        String sql = "SELECT customer_id FROM customers ORDER BY customer_id DESC LIMIT 1";

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
            String nextStockId = String.format("C%03d", numericValue);
            return nextStockId;
        }
        else {
            return "C001";
        }
    }



    public String getTelephone(String custId) throws SQLException {

        String sql = "SELECT phone_no FROM customers WHERE customer_id=?";

        ResultSet resultSet = SQLUtil.execute(sql,custId);
        String tele = null;
        while(resultSet.next()){
            tele = resultSet.getString(1);
        }
        return  tele;
    }

    public String getName(String custId) throws SQLException {

        String sql = "SELECT name FROM customers WHERE customer_id=?";

        ResultSet resultSet = SQLUtil.execute(sql,custId);
        String name = null;
        while(resultSet.next()){
            name = resultSet.getString(1);
        }
        return  name;
    }



    public List<String> getCustomerEmails() throws SQLException {
        String sql = "SELECT email FROM customers";
        ResultSet resultSet =SQLUtil.execute(sql);
        List<String> emailList = new ArrayList<>();
        while (resultSet.next()){
            emailList.add(resultSet.getString(1));
        }
        return emailList;
    }
    public List<String> loadCustomerId() throws SQLException {

        String sql = "SELECT customer_id FROM customers";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<String> list = new ArrayList<>();
        while (resultSet.next()){
            list.add(resultSet.getString(1));
        }
        return list;
    }
    public String getMembership(String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT membership_level FROM customers WHERE customer_id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        String membership = null;
        while (resultSet.next()){
            membership= resultSet.getString(1);
        }
        return  membership;
    }
}
