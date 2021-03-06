package repositories.interfaces;

import entities.Transaction;

import java.util.List;

public interface ITransactionRepository {
    List<Transaction> getTransactionsByUsername(String username);
    boolean createTransaction(Transaction transaction);
}
