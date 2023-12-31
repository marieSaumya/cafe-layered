package lk.ijse.freshBite.bo.custom;

import lk.ijse.freshBite.bo.SuperBo;
import lk.ijse.freshBite.dto.ProfileDto;

import java.sql.SQLException;

public interface ProfileBo extends SuperBo {
    ProfileDto getUserData() throws SQLException;

    boolean updateUser(ProfileDto dto) throws SQLException;
}
