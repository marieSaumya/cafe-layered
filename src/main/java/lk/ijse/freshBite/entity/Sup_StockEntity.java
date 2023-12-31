package lk.ijse.freshBite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class Sup_StockEntity {
    private String sup_id;
    private String stockId;
    private  Date date;
    private  int quantity;

    public Sup_StockEntity(String sup_id, String stockId, Date date, int quantity) {
        this.sup_id = sup_id;
        this.stockId = stockId;
        this.date = date;
        this.quantity = quantity;
    }
}
