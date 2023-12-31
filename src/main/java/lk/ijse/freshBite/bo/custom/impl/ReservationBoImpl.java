package lk.ijse.freshBite.bo.custom.impl;

import lk.ijse.freshBite.bo.custom.ReservationBo;
import lk.ijse.freshBite.dao.DaoFactory;
import lk.ijse.freshBite.dao.custom.CustomerDetailDao;
import lk.ijse.freshBite.dao.custom.QueryDao;
import lk.ijse.freshBite.dao.custom.ReservationDao;
import lk.ijse.freshBite.dao.custom.impl.CustomerDetailDaoImpl;
import lk.ijse.freshBite.dao.custom.impl.QueryDaoImpl;
import lk.ijse.freshBite.dao.custom.impl.ReservationDaoImpl;
import lk.ijse.freshBite.dto.ReservationDto;
import lk.ijse.freshBite.entity.ReservationEntity;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationBoImpl implements ReservationBo {
    private ReservationDao reservationDao = (ReservationDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.RESERVATION);
    public CustomerDetailDao customerDetailDao = (CustomerDetailDao) DaoFactory.getDaoFactory().getDao(DaoFactory.DataTypes.CUSTOMER);
    private QueryDao queryDao = new QueryDaoImpl();
    public boolean saveReservation(ReservationDto dto) throws SQLException, IOException {
        return reservationDao.save(new ReservationEntity(dto.getId(),dto.getDate(),dto.getTime(),dto.getTableNo(),
                dto.getCustId(),dto.getTelephone(),dto.getSize(), dto.getName()));

    }


    public boolean updateReservation(ReservationDto dto) throws SQLException {
        return reservationDao.update(new ReservationEntity(dto.getId(),dto.getDate(),dto.getTime(),dto.getTableNo(),
                dto.getCustId(),dto.getTelephone(),dto.getSize(), dto.getName()));

    }

    public List<ReservationDto> getAllReservations() throws SQLException {
        List<ReservationEntity> entityList = reservationDao.loadAll();
        List<ReservationDto> dtoList = new ArrayList<>();
        for (ReservationEntity entity:entityList){
            dtoList.add(new ReservationDto(entity.getId(),entity.getDate(),entity.getTime(),entity.getTableNo(),
                    entity.getCustId(),entity.getTelephone(),entity.getSize(),entity.getName()));
        }

        return dtoList;
    }

    public List<ReservationDto> getAllReservationListOnDate(LocalDate date) throws SQLException {
       List<ReservationEntity> entityList = queryDao.getAllReservationListOnDate(date);
       List<ReservationDto> dtoList = new ArrayList<>();
       for (ReservationEntity entity:entityList){
           dtoList.add(new ReservationDto(entity.getId(),entity.getDate(),entity.getTime(),entity.getTableNo(),
                   entity.getCustId(),entity.getTelephone(),entity.getSize(),entity.getName()));
       }
        return dtoList;

    }

    public List<ReservationDto> getAllReservationListtodayDate() throws SQLException {
        List<ReservationEntity> entityList = queryDao.getAllReservationListtodayDate();
        List<ReservationDto> dtoList = new ArrayList<>();
        for (ReservationEntity entity:entityList){
            dtoList.add(new ReservationDto(entity.getId(),entity.getDate(),entity.getTime(),entity.getTableNo(),
                    entity.getCustId(),entity.getTelephone(),entity.getSize(),entity.getName()));
        }
        return dtoList;
    }

    public String generateNextId() throws SQLException {
       return reservationDao.generateId();
    }


    public boolean deleteReservation(String reservationId) throws SQLException {
        return reservationDao.delete(reservationId);
    }

    public boolean completeReservation(String id) throws SQLException {
       return reservationDao.completeReservation(id);
    }

    public boolean unCompleteReservation(String id) throws SQLException {
      return reservationDao.unCompleteReservation(id);
    }

    public boolean checkComplete(String id) throws SQLException {
        return reservationDao.checkComplete(id);

    }
    public List<String> loadCustomerId() throws SQLException{
        return customerDetailDao.loadCustomerId();
    }
}
