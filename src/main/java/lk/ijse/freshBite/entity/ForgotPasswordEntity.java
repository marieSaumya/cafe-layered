package lk.ijse.freshBite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ForgotPasswordEntity {
    private  String userName;
    private String pwd;

    public ForgotPasswordEntity(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }

    public ForgotPasswordEntity(String userName) {
        this.userName = userName;
    }
}
