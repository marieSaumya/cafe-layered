package lk.ijse.freshBite.bo.custom;

import lk.ijse.freshBite.bo.SuperBo;

import java.sql.SQLException;
import java.util.List;

public interface MailBo extends SuperBo {
    List<String> getCustomerEmails() throws SQLException;
}
