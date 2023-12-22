package ShoppingApp;

public class Admin_Order2 {
    private Integer id;
    private String userN;
    private String item;
    private Integer price;
    private Integer quantity;
    private Integer total;

    public Integer getId() {
        return id;
    }

    public String getUserN() {
        return userN;
    }

    public String getItem() {
        return item;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getTotal() {
        return total;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserN(String userN) {
        this.userN = userN;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Admin_Order2(Integer id, String userN, String item, Integer price, Integer quantity, Integer total) {
        this.id = id;
        this.userN = userN;
        this.item = item;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }
}
