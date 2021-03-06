package repositories.interfaces;

import entities.User;

public interface IUserRepository {
    //common account methods
    User getUserByUsername(String username);

    //admin methods
    boolean createUser(User user);
}
