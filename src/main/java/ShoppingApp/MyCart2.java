package ShoppingApp;

public class MyCart2 {

    private Integer Id;
    private String Username;
    private String Item;
    private Integer Price;
    private Integer Quantity;
    private Integer Total;

//    getters that catch the data
    public Integer getId() {
        return Id;
    }

    public String getUsername() {
        return Username;
    }

    public String getItem() {
        return Item;
    }

    public Integer getPrice() {
        return Price;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public Integer getTotal() {
        return Total;
    }

//    setters that sets the data in table
    public void setId(Integer id) {
        Id = id;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setItem(String item) {
        Item = item;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public void setTotal(Integer total) {
        Total = total;
    }

    public MyCart2(Integer id, String username, String item, Integer price, Integer quantity, Integer total) {
        Id = id;
        Username = username;
        Item = item;
        Price = price;
        Quantity = quantity;
        Total = total;
    }
}