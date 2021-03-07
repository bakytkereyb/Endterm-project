package repositories.interfaces;

import entities.User;

public interface IUserRepository {
    //common account methods
    // method to get one user from db
    User getUserByUsername(String username);

    //admin methods
    // method to create a new user in db
    boolean createUser(User user);
}
