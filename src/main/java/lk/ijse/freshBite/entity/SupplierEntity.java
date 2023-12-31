package lk.ijse.freshBite.entity;

public class SupplierEntity {
private String sup_id;
private String name;
private String address;
private String EMail;
private String telephone;

    public SupplierEntity() {
    }

    public SupplierEntity(String sup_id, String name, String address, String EMail, String telephone) {
        this.sup_id = sup_id;
        this.name = name;
        this.address = address;
        this.EMail = EMail;
        this.telephone = telephone;
    }

    public String getSup_id() {
        return sup_id;
    }

    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
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

    public String getEMail() {
        return EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "SupplierDto{" +
                "sup_id='" + sup_id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", EMail='" + EMail + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
