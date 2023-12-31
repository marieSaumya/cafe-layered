package lk.ijse.freshBite.dto;

import lombok.Getter;

import java.sql.Date;

@Getter
public class StockItemDto {
    private String stockId;
    private String name;
    private  int quantity;
    private double price;

    public StockItemDto(String stockId, String name, int quantity, double price) {
        this.stockId = stockId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;

    }

    public StockItemDto() {
    }



    public StockItemDto(String stockId, String name, int quantity) {
        this.stockId = stockId;
        this.name = name;
        this.quantity = quantity;

    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "StockItemDto{" +
                "stockId='" + stockId + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price + '\'' +
                '}';
    }
}
