package lk.ijse.freshBite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileEntity {
    private String userId ;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;


    public ProfileEntity(String userId, String userName, String password, String email, String phone,String address) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public ProfileEntity(String userName, String pw, String mail, String phoneNo, String address) {
        this.userName = userName;
        this.password = pw;
        this.email = mail;
        this.phone = phoneNo;
        this.address = address;
    }
}
