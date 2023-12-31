package lk.ijse.freshBite.dao;

import lk.ijse.freshBite.dto.AddMenuDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T> extends SuperDao {
    boolean save(T dto) throws SQLException,IOException;
    boolean update(T dto) throws SQLException;
    boolean delete(String Id) throws SQLException;
    List<T> loadAll() throws SQLException;
    String generateId() throws SQLException;
}
