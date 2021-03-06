import controllers.UserController;
import data.DB;
import data.interfaces.IDB;
import repositories.CardRepository;
import repositories.TransactionRepository;
import repositories.UserRepository;
import repositories.interfaces.ICardRepository;
import repositories.interfaces.ITransactionRepository;
import repositories.interfaces.IUserRepository;

public class Main {
    public static void main(String[] args) {
        IDB db = new DB();
        ICardRepository card_repo = new CardRepository(db);
        IUserRepository user_repo = new UserRepository(db);
        ITransactionRepository trans_repo = new TransactionRepository(db);
        UserController controller = new UserController(user_repo, card_repo, trans_repo);

        MyApplication app = new MyApplication(controller);
        app.start();
    }
}
