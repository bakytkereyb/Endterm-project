package entities;

public class User {
    private String username;
    private String password;
    private boolean user_type;
    private String full_name;
    private String address;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUser_type() {
        return user_type;
    }
    public void setUser_type(boolean user_type) {
        this.user_type = user_type;
    }

    public String getFull_name() {
        return full_name;
    }
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public User(String username, String password, boolean user_type, String full_name, String address) {
        setUsername(username);
        setPassword(password);
        setUser_type(user_type);
        setFull_name(full_name);
        setAddress(address);
    }
    public String getUserInfo() {
        String out = "";
        out += getUsername() + " | ";
        out += getPassword() + " | ";
        out += (isUser_type() ? "Admin" : "Customer") + " | ";
        out += getFull_name() + " | ";
        out += getAddress() + " | ";
        return out;
    }
}
