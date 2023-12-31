package lk.ijse.freshBite.bo.custom.impl;

import javafx.scene.image.Image;
import lk.ijse.freshBite.bo.custom.AddMenuBo;
import lk.ijse.freshBite.dao.DaoFactory;
import lk.ijse.freshBite.dao.custom.AddMenuDao;
import lk.ijse.freshBite.dao.custom.impl.AddMenuDaoImpl;
import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.dto.AddMenuDto;
import lk.ijse.freshBite.dto.StockItemDto;
import lk.ijse.freshBite.entity.AddMenuEntity;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddMenuBoImpl implements AddMenuBo {
    private AddMenuDao addMenuDao = (AddMenuDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.ADD_MENU);
@Override
    public boolean addMenu(AddMenuDto dto) throws SQLException, IOException {

        return addMenuDao.save(new AddMenuEntity(dto.getItemId(), dto.getName(), dto.getType(), dto.getQtyOnhand(), dto.getSellPrice(), dto.getStatus(), dto.getStockId(), dto.getImagePath()));

    }
@Override
    public boolean updateMenu(AddMenuDto dto) throws SQLException {

        return addMenuDao.update(new AddMenuEntity(dto.getItemId(), dto.getName(), dto.getType(), dto.getQtyOnhand(), dto.getSellPrice(), dto.getStatus(), dto.getStockId(), dto.getImagePath()));
    }
@Override
    public boolean deleteItem(String menuId) throws SQLException {

        return addMenuDao.delete(menuId);
    }
@Override
    public List<AddMenuDto> loadMenuItems() throws SQLException {
        List<AddMenuEntity> entityList = addMenuDao.loadAll();
        List<AddMenuDto> dtoList = new ArrayList<>();
        for (AddMenuEntity entity : entityList) {
            dtoList.add(new AddMenuDto(entity.getItemId(), entity.getName(), entity.getMenu_type(), entity.getQty_on_hand()
                    , entity.getUnit_Price(), entity.getAvailability(), entity.getStockId(), entity.getImagePath()));
        }
        return dtoList;
    }
    @Override
    public List<String> getStockId() throws SQLException {
        String sql = "SELECT stock_id FROM stock_item";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<String> idList = new ArrayList<>();
        while (resultSet.next()){
            idList.add(resultSet.getString(1));
        }
        return idList;
    }
    @Override
    public Image getImgPath(String itemId) throws SQLException {
        String sql = "SELECT image_path FROM menu_item WHERE item_id=? ";
        ResultSet resultSet = SQLUtil.execute(sql,itemId);
        String path = null;

        while (resultSet.next()){
            path=resultSet.getString(1);
        }
        return new Image(path,239,232,false,true);
    }
    @Override
    public StockItemDto getItemDetail(String id) throws SQLException {
        String sql = "SELECT * FROM stock_item WHERE stock_id=?";
        ResultSet resultSet=  SQLUtil.execute(sql,id);
        StockItemDto dto = null;
        while (resultSet.next()){
            dto = new StockItemDto(resultSet.getString(1),resultSet.getString(2),resultSet.getInt(4));
        }
        return  dto;
    }
    @Override
    public boolean updateStatus(String itemId) throws SQLException {
        String sql ="UPDATE menu_item SET availability =? WHERE item_id=?";

        return SQLUtil.execute(sql,"Unavailable",itemId);
    }
   @Override
    public boolean updateStatusAvailable(String itemId) throws SQLException {
        String sql ="UPDATE menu_item SET availability =? WHERE item_id=?";
        return SQLUtil.execute(sql,"Available",itemId);
    }

}

