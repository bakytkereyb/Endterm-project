package entities;

import java.time.LocalDate;

public class Transaction {
    // unique id of transaction
    private int id;
    // transaction date when happened it
    private LocalDate date;
    // who send money
    private String from_username;
    // whom money is sent
    private String to_username;
    // how much money is sent
    private int money;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getFrom_username() {
        return from_username;
    }
    public void setFrom_username(String from_username) {
        this.from_username = from_username;
    }

    public String getTo_username() {
        return to_username;
    }
    public void setTo_username(String to_username) {
        this.to_username = to_username;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    // constructor to create a new Transaction
    public Transaction(LocalDate date, String from_username, String to_username, int money) {
        setDate(date);
        setFrom_username(from_username);
        setTo_username(to_username);
        setMoney(money);
    }
    // constructor to create a new Transaction with id
    public Transaction(int id, LocalDate date, String from_username, String to_username, int money) {
        setId(id);
        setDate(date);
        setFrom_username(from_username);
        setTo_username(to_username);
        setMoney(money);
    }

    // method to get whole info about transaction
    public String getTransactionInfo() {
        String out = "";
        out += getId() + " | ";
        out += getDate() + " | ";
        out += getFrom_username() + " | ";
        out += getTo_username() + " | ";
        out += getMoney() + " | ";
        return out;
    }
}
