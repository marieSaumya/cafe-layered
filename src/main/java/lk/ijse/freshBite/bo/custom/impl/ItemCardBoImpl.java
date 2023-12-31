package lk.ijse.freshBite.bo.custom.impl;

import lk.ijse.freshBite.bo.custom.ItemCardBo;
import lk.ijse.freshBite.dao.DaoFactory;
import lk.ijse.freshBite.dao.custom.ItemCardDao;
import lk.ijse.freshBite.dao.custom.impl.ItemCardDaoImpl;
import lk.ijse.freshBite.dto.AddMenuDto;
import lk.ijse.freshBite.entity.AddMenuEntity;

import java.sql.SQLException;

public class ItemCardBoImpl implements ItemCardBo {
    private ItemCardDao itemCardDao = (ItemCardDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.ITEM_CARD);

    public String getStatus(String name) throws SQLException {
      return itemCardDao.getStatus(name);

    }

    public AddMenuDto getItemDetails(String name) throws SQLException {
        AddMenuEntity entity = itemCardDao.getItemDetails(name);
        return new AddMenuDto(entity.getItemId(),entity.getName(),entity.getMenu_type(),
                entity.getQty_on_hand(),entity.getUnit_Price(),entity.getAvailability(),entity.getStockId(),entity.getImagePath()) ;
    }
}
