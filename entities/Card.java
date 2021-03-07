package entities;

public class Card {
    // unique id of card
    private int id;
    // every user has own card
    private String username;
    // money in card
    private int money;
    // card number
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

    // constructor to create a new Card
    public Card (int id, String username, int money, String number) {
        setId(id);
        setUsername(username);
        setMoney(money);
        setNumber(number);
    }

    // constructor to create a new Card without id
    public Card (String username, int money, String number) {
        setUsername(username);
        setMoney(money);
        setNumber(number);
    }

    // method to get whole info about card
    public String getCardInfo() {
        String out = "";
        out += getId() + " | ";
        out += getUsername() + " | ";
        out += getMoney() + " | ";
        out += getNumber() + " | ";
        return out;
    }
}
