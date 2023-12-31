package lk.ijse.freshBite.dao.custom.impl;

import lk.ijse.freshBite.dao.custom.ReservationDao;
import lk.ijse.freshBite.dao.SQLUtil;
import lk.ijse.freshBite.db.DbConnection;
import lk.ijse.freshBite.entity.ReservationEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl implements ReservationDao {

    public boolean save(ReservationEntity entity) throws SQLException {
        String userId = getUserId();
        String sql = "INSERT INTO reservations (reservation_id,user_id,customer_id,date,time,table_number,number_of_people)VALUES (?,?,?,?,?,?,?)";

        return SQLUtil.execute(sql,entity.getId(),userId,entity.getCustId(),Date.valueOf(entity.getDate()),entity.getTime(),
                entity.getTableNo(),entity.getSize());

    }

    private String getUserId() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "SELECT user_id FROM users";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            return  resultSet.getString(1);
        }
        return  null;
    }

    public boolean update(ReservationEntity entity) throws SQLException {
        String userId = getUserId();

        String sql = "UPDATE reservations SET user_id=?,customer_id=?,date=?,time=?,table_number=?,number_of_people=? WHERE reservation_id=?";

        return SQLUtil.execute(sql,userId,entity.getCustId(),Date.valueOf(entity.getDate()),entity.getTime(),
                entity.getTableNo(),entity.getSize(),entity.getId());

    }

    public List<ReservationEntity> loadAll() throws SQLException {
        String sql = "SELECT * from reservations r inner join customers c on r.customer_id= c.customer_id";
        ResultSet resultSet = SQLUtil.execute(sql);
        List<ReservationEntity> entityList = new ArrayList<>();
        while (resultSet.next()){

               entityList.add(new ReservationEntity(resultSet.getString(1),
                       resultSet.getDate(4).toLocalDate(),
                       resultSet.getString(5),
                       resultSet.getInt(6),
                       resultSet.getString(9),
                       resultSet.getString(13),
                       resultSet.getInt(7),
                       resultSet.getString(10)
               ));
        }

        return entityList;
    }





    public String generateId() throws SQLException {
        String sql = "SELECT reservation_id FROM reservations ORDER BY reservation_id DESC LIMIT 1";
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
            String Id = String.format("R%03d", numericValue);
            return Id;
        }
        else {
            return "R001";
        }
    }

    public boolean delete(String reservationId) throws SQLException {
        String sql = "DELETE FROM  reservations WHERE  reservation_id = ?";
        return SQLUtil.execute(sql,reservationId);
    }

    public boolean completeReservation(String id) throws SQLException {
        String sql = "UPDATE reservations SET IsCompleted=1 WHERE reservation_id=?";
        return SQLUtil.execute(sql,id);
    }

    public boolean unCompleteReservation(String id) throws SQLException {
        String sql = "UPDATE reservations SET IsCompleted=0 WHERE reservation_id=?";
        return SQLUtil.execute(sql,id);
    }

    public boolean checkComplete(String id) throws SQLException {
        String sql = "SELECT IsCompleted FROM reservations WHERE reservation_id=?";
        ResultSet resultSet = SQLUtil.execute(sql,id);
        int complete =-1;
        while (resultSet.next()){
            complete = resultSet.getInt(1);
        }
        if (complete==1){
            return  true;
        }
        else {
            return  false;
        }

    }


}
