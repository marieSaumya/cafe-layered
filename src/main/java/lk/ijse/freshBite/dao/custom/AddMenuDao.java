package lk.ijse.freshBite.dao.custom;

import javafx.scene.image.Image;
import lk.ijse.freshBite.dao.CrudDao;
import lk.ijse.freshBite.dto.AddMenuDto;
import lk.ijse.freshBite.dto.StockItemDto;
import lk.ijse.freshBite.dto.tm.ItemCardTm;
import lk.ijse.freshBite.entity.AddMenuEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface AddMenuDao extends CrudDao<AddMenuEntity> {

    boolean updateItem(List<ItemCardTm> cartTmList) throws SQLException;
}
