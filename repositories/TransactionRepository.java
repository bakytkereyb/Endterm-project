package repositories;

import data.interfaces.IDB;
import entities.Transaction;
import entities.User;
import repositories.interfaces.ICardRepository;
import repositories.interfaces.ITransactionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TransactionRepository implements ITransactionRepository {
    // constant variable to connect with database
    private final IDB db;

    // Constructor for creating a new TransactionRepository
    public TransactionRepository(IDB db) {
        this.db = db;
    }

    @Override
    public List<Transaction> getTransactionsByUsername(String username) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String SelectStatement = "SELECT * FROM transactions WHERE from_username=?";
            PreparedStatement st = con.prepareStatement(SelectStatement);

            st.setString(1, username);

            ResultSet rs = st.executeQuery();

            List<Transaction> transactions = new LinkedList<>();

            // while there is a result, do this
            while (rs.next()) {
                Transaction transaction = new Transaction(
                        rs.getInt("id"),
                        rs.getDate("date").toLocalDate(),
                        rs.getString("from_username"),
                        rs.getString("to_username"),
                        rs.getInt("money"));

                transactions.add(transaction);
            }

            // result result transaction list from database
            return transactions;
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

    @Override
    public boolean createTransaction(Transaction transaction) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String InsertStatement = "INSERT INTO transactions(date, from_username, to_username, money) VALUES (?,?,?,?);";
            PreparedStatement st = con.prepareStatement(InsertStatement);

            // Setting parameters into prepared SQL statement
            st.setDate(1, java.sql.Date.valueOf(transaction.getDate()));
            st.setString(2, transaction.getFrom_username());
            st.setString(3, transaction.getTo_username());
            st.setInt(4, transaction.getMoney());


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
