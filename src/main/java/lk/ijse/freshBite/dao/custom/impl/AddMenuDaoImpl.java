package lk.ijse.freshBite.dao.custom.impl;

import lk.ijse.freshBite.dao.custom.AddMenuDao;
import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.dto.tm.ItemCardTm;
import lk.ijse.freshBite.entity.AddMenuEntity;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddMenuDaoImpl implements AddMenuDao {
    public boolean save(AddMenuEntity entity) throws SQLException, IOException {

        String sql = "INSERT INTO menu_item (item_id, name, unit_price, menu_type, qty_on_hand, stock_id, availability, image_path) VALUES (?,?,?,?,?,?,?,?)";

        return  SQLUtil.execute(sql,entity.getItemId(),entity.getName(),entity.getUnit_Price(),entity.getMenu_type(),
                entity.getQty_on_hand(),entity.getStockId(),entity.getAvailability(),entity.getImagePath());

    }


    public boolean update(AddMenuEntity entity) throws SQLException {

        String sql = "UPDATE menu_item SET name=?,unit_price =?,menu_type=?,qty_on_hand=?,stock_id=?,availability=?,image_path=? WHERE item_id=?";

        return  SQLUtil.execute(sql,entity.getName(),entity.getUnit_Price(),entity.getMenu_type(),
                entity.getQty_on_hand(),entity.getStockId(),entity.getAvailability(),entity.getImagePath(),entity.getItemId());

    }

    public boolean delete(String menuId) throws SQLException {
        String sql = "DELETE FROM menu_item WHERE item_id=? ";
        return SQLUtil.execute(sql,menuId);
    }

    public List<AddMenuEntity> loadAll() throws SQLException {
        String sql = "SELECT * FROM menu_item";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<AddMenuEntity> entityList = new ArrayList<>();
        while(resultSet.next()){

            entityList.add(new AddMenuEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getDouble(3),
                    resultSet.getString(7),
                    resultSet.getString(6),
                    resultSet.getString(8)));
        }
        return entityList;
    }

    @Override
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



    public boolean updateItem(List<ItemCardTm> cartTmList) throws SQLException {
        for (ItemCardTm item : cartTmList){
            if (!updateQty(item.getItemName(),item.getQty())){
                return  false;
            }
        }
        return  true;
    }

    private boolean updateQty(String itemName, int qty) throws SQLException {
        String sql ="UPDATE menu_item SET qty_on_hand =qty_on_hand -? WHERE name=?";
        return SQLUtil.execute(sql,qty,itemName);

    }




}
