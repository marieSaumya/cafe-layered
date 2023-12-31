package lk.ijse.freshBite.dto;

import lk.ijse.freshBite.dto.tm.ItemCardTm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor

public class OrderItemDto {
    private String order_id;
    private List<ItemCardTm> itemCardTmList;

    public OrderItemDto(String order_id, List<ItemCardTm> itemCardTmList) {
        this.order_id = order_id;
        this.itemCardTmList = itemCardTmList;
    }
}
