package repositories.interfaces;

import entities.Transaction;

import java.util.List;

public interface ITransactionRepository {
    // method to get transactions by username from db
    List<Transaction> getTransactionsByUsername(String username);
    // method to create a new transaction in db
    boolean createTransaction(Transaction transaction);
}
