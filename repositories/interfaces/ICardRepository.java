package repositories.interfaces;

import entities.Card;

public interface ICardRepository {
    // method to create a new card for one username in db
    boolean createCardForUsername(String username);
    // method to get a card from db
    Card getCardByUsername(String username);
    // method to deposit some money into one card
    boolean depositMoney(int money, String username);
    // method to withdraw some money from one card
    boolean withdrawMoney(int money, String username);
}
