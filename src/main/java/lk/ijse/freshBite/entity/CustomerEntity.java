package lk.ijse.freshBite.entity;

public class CustomerEntity {
    private  String customer_id;
    private String name ;
    private String address;
    private String telephone;
    private String email;
    private String gender;
    private String membership_level;

    public CustomerEntity() {
    }

    public CustomerEntity(String customer_id, String name, String address, String telephone, String email, String gender, String membership_level) {
        this.customer_id = customer_id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.gender = gender;
        this.membership_level = membership_level;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMembership_level() {
        return membership_level;
    }

    public void setMembership_level(String membership_level) {
        this.membership_level = membership_level;
    }
}
