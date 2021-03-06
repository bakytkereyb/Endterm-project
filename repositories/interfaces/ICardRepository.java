package repositories.interfaces;

import entities.Card;

public interface ICardRepository {
    boolean createCardForUsername(String username);
    Card getCardByUsername(String username);
    boolean depositMoney(int money, String username);
    boolean withdrawMoney(int money, String username);
}
