package lk.ijse.freshBite.bo.custom.impl;

import lk.ijse.freshBite.bo.custom.ProfileBo;
import lk.ijse.freshBite.dao.DaoFactory;
import lk.ijse.freshBite.dao.custom.ProfileDao;
import lk.ijse.freshBite.dao.custom.impl.ProfileDaoImpl;
import lk.ijse.freshBite.dto.ProfileDto;
import lk.ijse.freshBite.entity.ProfileEntity;

import java.sql.SQLException;
import java.util.List;

public class ProfileBoImpl implements ProfileBo {
    private ProfileDao profileDao = (ProfileDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.PROFILE);

    public ProfileDto getUserData() throws SQLException {
        List<ProfileEntity> entities = profileDao.loadAll();
        ProfileDto dto = null;
        for (ProfileEntity entity : entities){
            dto = new ProfileDto(entity.getUserId(), entity.getPassword(), entity.getEmail(), entity.getPhone(), entity.getAddress());
        }
        return dto;
    }

    public boolean updateUser(ProfileDto dto) throws SQLException {
        return profileDao.update(new ProfileEntity(dto.getUserName(), dto.getPassword(), dto.getEmail(), dto.getPhone(), dto.getAddress()));


    }
}
