package hello.itemservice.domain;



import lombok.Data;


@Data
public class Item {


    private Long id;
    private String itemName;
    private Integer price ; // null일 수도 있기 때문에
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
