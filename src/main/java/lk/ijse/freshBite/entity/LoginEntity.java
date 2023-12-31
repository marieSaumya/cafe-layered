package lk.ijse.freshBite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginEntity {

    private String  userName;
    private String pwd;

    public LoginEntity(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }
}
