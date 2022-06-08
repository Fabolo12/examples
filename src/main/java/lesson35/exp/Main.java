package lesson35.exp;

import com.mongodb.client.MongoDatabase;
import lesson35.exp.dao.AccountDao;
import lesson35.exp.dao.UserDao;
import lesson35.exp.services.UserService;
import lesson35.exp.utils.MongoUtil;


public class Main {
    private static final MongoDatabase db = MongoUtil.connect("aLevel");

    public static void main(String[] args) {
        AccountDao accountDao = new AccountDao(db);
        UserDao userDao = new UserDao(db);
        UserService service = new UserService(accountDao, userDao);
        service.run();
    }

}
