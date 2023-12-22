package ShoppingApp;

public class Admin_SigninInfo2 {

    private Integer Id;
    private String FirstN;
    private String LastN;
    private String UserN;
    private String Email;
    private String Password;

    public Integer getId() {
        return Id;
    }

    public String getFirstN() {
        return FirstN;
    }

    public String getLastN() {
        return LastN;
    }

    public String getUserN() {
        return UserN;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setFirstN(String firstN) {
        FirstN = firstN;
    }

    public void setLastN(String lastN) {
        LastN = lastN;
    }

    public void setUserN(String userN) {
        UserN = userN;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Admin_SigninInfo2(Integer id, String firstN, String lastN, String userN, String email, String password) {
        Id = id;
        FirstN = firstN;
        LastN = lastN;
        UserN = userN;
        Email = email;
        Password = password;
    }
}
