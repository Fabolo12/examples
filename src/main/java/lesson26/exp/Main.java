package lesson26.exp;

import com.mongodb.client.MongoDatabase;
import lesson26.exp.dao.AccountDao;
import lesson26.exp.dao.UserDao;
import lesson26.exp.services.UserService;
import lesson26.exp.utils.MongoUtil;


public class Main {
    private static final MongoDatabase db = MongoUtil.connect("aLevel");

    public static void main(String[] args) {
        db.drop();
        AccountDao accountDao = new AccountDao(db);
        UserDao userDao = new UserDao(db);
        UserService service = new UserService(accountDao, userDao);
        service.run();
    }

}
