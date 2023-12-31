package lk.ijse.freshBite.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class StockDto{

        private String stockId;
        private String name;
        private  int quantity;
        private double price;
        private String sup_id;
        private  java.sql.Date date;

        public StockDto(String stockId, String name, int quantity, double price, String sup_id, LocalDate date) {
            this.stockId = stockId;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            this.sup_id = sup_id;
            this.date = Date.valueOf(date);
        }
}
