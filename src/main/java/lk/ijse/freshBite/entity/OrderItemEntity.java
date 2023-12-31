package lk.ijse.freshBite.entity;

import lk.ijse.freshBite.dto.tm.ItemCardTm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@NoArgsConstructor
@Setter

public class OrderItemEntity {
    private String order_id;
    private List<ItemCardTm> itemCardTmList;

    public OrderItemEntity(String order_id, List<ItemCardTm> itemCardTmList) {
        this.order_id = order_id;
        this.itemCardTmList = itemCardTmList;
    }
}
