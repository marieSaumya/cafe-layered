package lk.ijse.freshBite.entity;

public class AnalyticsEntity {
    private String location;
    private int customerCount;

    public AnalyticsEntity() {
    }

    public AnalyticsEntity(String location, int customerCount) {
        this.location = location;
        this.customerCount = customerCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(int customerCount) {
        this.customerCount = customerCount;
    }

    @Override
    public String toString() {
        return "AnalyticsDto{" +
                "location='" + location + '\'' +
                ", customerCount=" + customerCount +
                '}';
    }
}
