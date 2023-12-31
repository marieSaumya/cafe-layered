package lk.ijse.freshBite.entity;

import lk.ijse.freshBite.dto.tm.ItemCardTm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MenuItemEntity {
    private String orderId;
    private LocalDate date;
    private String customerId;
    private double total;
    private List<ItemCardTm> cartTmList = new ArrayList<>();

    public MenuItemEntity(String orderId, LocalDate date, String customerId, double total, List<ItemCardTm> cartTmList) {
        this.orderId = orderId;
        this.date = date;
        this.customerId = customerId;
        this.total = total;
        this.cartTmList = cartTmList;
    }
}
