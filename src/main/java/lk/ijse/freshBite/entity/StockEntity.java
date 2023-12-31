package lk.ijse.freshBite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class StockEntity {

        private String stockId;
        private String name;
        private  int quantity;
        private double price;
        private String sup_id;
        private  LocalDate date;

        public StockEntity(String stockId, String name, int quantity, double price, String sup_id, LocalDate date) {
            this.stockId = stockId;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            this.sup_id = sup_id;
            this.date = date;
        }
}
