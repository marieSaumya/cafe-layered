package lk.ijse.freshBite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor

public class OrderEntity {
    private String order_id;
    private String customer_id;
    private LocalDate date;
    private LocalDateTime order_time;
    private double total;

    public OrderEntity(String order_id, String customer_id, LocalDate date, LocalDateTime order_time, double total) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.date = date;
        this.order_time = order_time;
        this.total = total;
    }
}
