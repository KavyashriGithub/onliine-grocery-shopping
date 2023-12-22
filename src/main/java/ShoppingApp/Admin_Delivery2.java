package ShoppingApp;

public class Admin_Delivery2 {
    private Integer id;
    private String firstN;
    private String lastN;
    private String phoneNumber;
    private String address;
    private String pin;

    public Integer getId() {
        return id;
    }

    public String getFirstN() {
        return firstN;
    }

    public String getLastN() {
        return lastN;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPin() {
        return pin;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstN(String firstN) {
        this.firstN = firstN;
    }

    public void setLastN(String lastN) {
        this.lastN = lastN;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Admin_Delivery2(Integer id, String firstN, String lastN, String phoneNumber, String address, String pin) {
        this.id = id;
        this.firstN = firstN;
        this.lastN = lastN;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.pin = pin;
    }
}
