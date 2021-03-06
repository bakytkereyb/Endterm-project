package controllers;

import entities.Card;
import entities.Transaction;
import entities.User;
import repositories.interfaces.ICardRepository;
import repositories.interfaces.ITransactionRepository;
import repositories.interfaces.IUserRepository;

import java.util.List;

public class UserController {
    private final IUserRepository user_repo;
    private final ICardRepository card_repo;
    private final ITransactionRepository trans_repo;

    // Constructor for creating a new UserController
    public UserController(IUserRepository user_repo, ICardRepository card_repo, ITransactionRepository trans_repo) {
        this.user_repo = user_repo;
        this.card_repo = card_repo;
        this.trans_repo = trans_repo;
    }

    // common method for all users to get info account
    public User getUser(String username) {
        User user = user_repo.getUserByUsername(username);

        return user;
    }

    // method just for admin user to create user account
    public String createUser(User user) {
        boolean user_created = user_repo.createUser(user);
        boolean card_created;
        if (user.isUser_type()) {
            card_created = true;
        }
        else {
            card_created = card_repo.createCardForUsername(user.getUsername());
        }

        return (user_created && card_created ? "User is successfully created in database!" : "User addition was failed!");
    }

    // method for customer user to get transaction history
    public List<Transaction> getTransactionHistory(String username) {
        List<Transaction> transactions = trans_repo.getTransactionsByUsername(username);

        return transactions;
    }

    // method for customer user to get information about bank card
    public String getCardInfo(String username) {
        Card card = card_repo.getCardByUsername(username);

        return card.getCardInfo();
    }

    // method for customer user to transfer money to another customer user
    public String transferMoney(String from_username, String to_username, int money) {
        boolean transfered;
        boolean transaction_created;

        if (card_repo.depositMoney(money, to_username) && card_repo.withdrawMoney(money, from_username)) {
            transfered = true;
            transaction_created = trans_repo.createTransaction(new Transaction(java.time.LocalDate.now(),from_username,to_username, money));
        }
        else {
            transfered = false;
            transaction_created = false;
        }

        return (transfered && transaction_created ? "Money transfer is successfully done!" : "Money transfer was failed!");
    }
}
