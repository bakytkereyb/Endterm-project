package repositories;

import data.interfaces.IDB;
import entities.Card;
import entities.User;
import repositories.interfaces.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IUserRepository {
    // constant variable to connect with database
    private final IDB db;

    // Constructor for creating a new UserRepository
    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public User getUserByUsername(String username) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String SelectStatement = "SELECT * FROM users WHERE username=?";
            PreparedStatement st = con.prepareStatement(SelectStatement);

            st.setString(1, username);

            ResultSet rs = st.executeQuery();

            // if there is a result, do this
            if (rs.next()) {
                User user = new User(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBoolean("user_type"),
                        rs.getString("full_name"),
                        rs.getString("address"));

                // return result user from database
                return user;
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

    @Override
    public boolean createUser(User user) {
        Connection con = null;
        try {
            // connecting with database
            con = db.getConnection();

            // Creating SQL statement
            String InsertStatement = "INSERT INTO users(username, password, user_type, full_name, address) VALUES (?,?,?,?,?);";
            PreparedStatement st = con.prepareStatement(InsertStatement);

            // Setting parameters into prepared SQL statement
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setBoolean(3, user.isUser_type());
            st.setString(4, user.getFull_name());
            st.setString(5, user.getAddress());

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
