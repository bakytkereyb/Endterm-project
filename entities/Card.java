package entities;

public class Card {
    private int id;
    private String username;
    private int money;
    private String number;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public Card (int id, String username, int money, String number) {
        setId(id);
        setUsername(username);
        setMoney(money);
        setNumber(number);
    }
    public Card (String username, int money, String number) {
        setUsername(username);
        setMoney(money);
        setNumber(number);
    }

    public String getCardInfo() {
        String out = "";
        out += getId() + " | ";
        out += getUsername() + " | ";
        out += getMoney() + " | ";
        out += getNumber() + " | ";
        return out;
    }
}
