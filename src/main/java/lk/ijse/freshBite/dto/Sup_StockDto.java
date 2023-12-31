package lk.ijse.freshBite.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Sup_StockDto {
    private String sup_id;
    private String stockId;
    private  java.sql.Date date;
    private  int quantity;

    public Sup_StockDto(String sup_id, String stockId, LocalDate date, int quantity) {
        this.sup_id = sup_id;
        this.stockId = stockId;
        this.date = Date.valueOf(date);
        this.quantity = quantity;
    }
}
