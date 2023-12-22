package ShoppingApp;

public class MYORDERS2 {

    private Integer Id;
    private String UserN;
    private String Item;
    private Integer Price;
    private Integer Quantity;
    private Integer Total;

//    //    getters that catch the data


    public Integer getId() {
        return Id;
    }

    public String getUserN() {
        return UserN;
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

    public void setId(Integer id) {
        Id = id;
    }

    public void setUserN(String userN) {
        UserN = userN;
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

    public MYORDERS2(Integer id, String username, String item, Integer price, Integer quantity, Integer total) {
        Id = id;
        UserN = username;
        Item = item;
        Price = price;
        Quantity = quantity;
        Total = total;
    }
}
