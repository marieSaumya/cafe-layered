package lk.ijse.freshBite.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class TrendingItemEntity {
    private String itemId;
    private String itemName;
    private int quantity;
    private String imagePath;

    public TrendingItemEntity() {
    }

    public TrendingItemEntity(String itemId, String itemName, int quantity, String imagePath) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.imagePath = imagePath;
    }
}
