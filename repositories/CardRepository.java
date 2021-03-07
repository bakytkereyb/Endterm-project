package repositories;

import data.interfaces.IDB;
import entities.Card;
import repositories.interfaces.ICardRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardRepository implements ICardRepository {
    // constant variable to connect with database
    private final IDB db;

    // Constructor for creating a new CardRepository
    public CardRepository(IDB db) {
        this.db = db;
    }

    // method to create a new card for one username in db
    @Override
    public boolean createCardForUsername(String username) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String InsertStatement = "INSERT INTO cards(username, money, number) VALUES (?,0,'xxxx-xxxx-xxxx-xxxx');";
            PreparedStatement st = con.prepareStatement(InsertStatement);

            // Setting parameters into prepared SQL statement
            st.setString(1, username);

            // executing SQL statement in database
            st.execute();

            // if everything is successfully done, return true
            return true;
        } catch (SQLException throwables) {
            // if there are some exceptions
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // this will be done whether exception occur or not
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // otherwise return false, if nothing happens
        return false;
    }

    // method to get a card from db
    @Override
    public Card getCardByUsername(String username) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String SelectStatement = "SELECT * FROM cards WHERE username=?";
            PreparedStatement st = con.prepareStatement(SelectStatement);

            st.setString(1, username);

            ResultSet rs = st.executeQuery();

            // if there is a result, do this
            if (rs.next()) {
                Card card = new Card(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getInt("money"),
                        rs.getString("number"));

                // return result card from database
                return card;
            }
        } catch (SQLException throwables) {
            // if there are some exceptions
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // this will be done whether exception occur or not
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // otherwise return null, if nothing happens
        return null;
    }

    // method to deposit some money into one card
    @Override
    public boolean depositMoney(int money, String username) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();


            Card card = getCardByUsername(username);
            money += card.getMoney();

            // Creating SQL statement to deposit money into card-number by username
            String UpdateStatement = "UPDATE cards SET money = ? WHERE username = ?;";
            PreparedStatement st = con.prepareStatement(UpdateStatement);

            st.setInt(1, money);
            st.setString(2, username);

            // executing SQL statement in database
            st.execute();

            // if everything is successfully done, return true
            return true;
        } catch (SQLException throwables) {
            // if there are some exceptions
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // this will be done whether exception occur or not
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // otherwise return false, if nothing happens
        return false;
    }

    // method to withdraw some money from one card
    @Override
    public boolean withdrawMoney(int money, String username) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();


            Card card = getCardByUsername(username);
            if (card.getMoney() < money) {
                return false; // if money is more than money in card, it is impossible to withdraw that money
            }
            money = card.getMoney() - money;

            // Creating SQL statement to deposit money into card-number by username
            String UpdateStatement= "UPDATE cards SET money = ? WHERE username = ?;";
            PreparedStatement st = con.prepareStatement(UpdateStatement);

            st.setInt(1, money);
            st.setString(2, username);

            // executing SQL statement in database
            st.execute();

            // if everything is successfully done, return true
            return true;
        } catch (SQLException throwables) {
            // if there are some exceptions
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // this will be done whether exception occur or not
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        // otherwise return false, if nothing happens
        return false;
    }
}
