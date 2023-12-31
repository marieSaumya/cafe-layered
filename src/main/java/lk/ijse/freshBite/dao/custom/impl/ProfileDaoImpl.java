package lk.ijse.freshBite.dao.custom.impl;

import lk.ijse.freshBite.dao.custom.ProfileDao;
import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.entity.ProfileEntity;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfileDaoImpl  implements ProfileDao {
    private ProfileEntity entity;

    @Override
    public boolean save(ProfileEntity dto) throws SQLException, IOException {
        return false;
    }



    @Override
    public boolean delete(String Id) throws SQLException {
        return false;
    }

    public List<ProfileEntity> loadAll() throws SQLException {
        List<ProfileEntity> entities = new ArrayList<>();
        String sql = "SELECT * FROM users";
        ResultSet resultSet = SQLUtil.execute(sql);

        while (resultSet.next()){
            entities.add( new ProfileEntity(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
                    ));
        }
        return  entities;
    }

    @Override
    public String generateId() throws SQLException {
        return null;
    }

    public boolean update(ProfileEntity entity) throws SQLException {
        this.entity = entity;
        String sql = "UPDATE users SET username=?,password=?,email=?,phone_no=?,address=? WHERE user_id=?";

        return SQLUtil.execute(sql,entity.getUserName(),entity.getPassword(),entity.getEmail(),
                entity.getPhone(),entity.getAddress(),"U001");


    }
}
