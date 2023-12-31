package lk.ijse.freshBite.dao.custom.impl;

import lk.ijse.freshBite.dao.custom.MenuItemDao;
import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.entity.AddMenuEntity;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenueItemDaoImpl implements MenuItemDao {


    @Override
    public boolean save(AddMenuEntity dto) throws SQLException, IOException {
        return false;
    }

    @Override
    public boolean update(AddMenuEntity dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String Id) throws SQLException {
        return false;
    }

    public List<AddMenuEntity> loadAll() throws SQLException {

        String sql = "SELECT * FROM menu_item";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<AddMenuEntity> entities = new ArrayList<>();
        while(resultSet.next()){

            entities.add(new AddMenuEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getDouble(3),
                    resultSet.getString(7),
                    resultSet.getString(6),
                    resultSet.getString(8)));
        }
        return entities;
    }

    public List<String> getAllCustId() throws SQLException {
        String sql = "SELECT customer_id FROM customers";
        ResultSet resultSet =SQLUtil.execute(sql);
        List<String> idList = new ArrayList<>();
        while (resultSet.next()){
            idList.add(resultSet.getString(1));
        }
        return  idList;
    }

    public String getName(String id) throws SQLException {
        String sql = "SELECT name FROM customers WHERE customer_id =?";
        ResultSet resultSet = SQLUtil.execute(sql,id);
        String name = null;
        while (resultSet.next()){
            name= resultSet.getString(1);
        }
        return  name;
    }



    public String generateId() throws SQLException {
        String sql = "SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1";
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
            String nextStockId = String.format("O%03d", numericValue);
            return nextStockId;
        }
        else {
            return "O001";
        }
    }


}
