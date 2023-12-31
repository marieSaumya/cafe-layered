package lk.ijse.freshBite.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private String order_id;
    private String customer_id;
    private LocalDate date;
    private LocalDateTime order_time;
    private double total;

    public OrderDto(String order_id, String customer_id, LocalDate date, double total) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.date = date;
        this.order_time = LocalDateTime.now();
        this.total = total;
    }
}
