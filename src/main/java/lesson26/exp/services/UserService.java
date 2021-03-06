package lesson26.exp.services;



import lesson26.exp.dao.AccountDao;
import lesson26.exp.dao.UserDao;
import lesson26.exp.model.Account;
import lesson26.exp.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserService {
    private final AccountDao accountDao;
    private final UserDao userDao;

    public UserService(AccountDao accountDao, UserDao userDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;
    }

    public void run() {
        System.out.println("createUsers");
        createUsers();
        System.out.println("~".repeat(20));

        System.out.println("createAccounts");
        createAccounts();
        System.out.println("~".repeat(20));

        System.out.println("bindAccounts");
        bindAccounts();
        System.out.println("~".repeat(20));

        System.out.println("findByName");
        findByName();
        System.out.println("~".repeat(20));

        System.out.println("findByAge");
        findByAge();
        System.out.println("~".repeat(20));

        System.out.println("findByCity");
        findByCity();
        System.out.println("~".repeat(20));

        System.out.println("findByAccounts");
        findByAccounts();
    }

    private void createUsers() {
        final User user1 = new User("FN1", "LN1", (short) 1981, "Company 1", "City 1");
        final User user2 = new User("FN2", "LN2", (short) 1934, "Company 2", "City 1");
        final User user3 = new User("FN3", "LN3", (short) 1965, "Company 1", "City 2");
        final User user4 = new User("FN4", "LN4", (short) 1995, "Company 2", "City 3");
        userDao.insertMany(Arrays.asList(user1, user2, user3, user4));
    }

    private void createAccounts() {
        final Account acc1 = new Account(1200.0f);
        final Account acc2 = new Account(5400f);
        final Account acc3 = new Account(32879f);
        final Account acc4 = new Account(780.5f);
        final Account acc5 = new Account(44.3f);
        accountDao.insertMany(Arrays.asList(acc1, acc2, acc3, acc4, acc5));
    }

    private void bindAccounts() {
        List<Account> accounts = accountDao.findAll();
        List<User> users = userDao.findAll();

        Account acc1 = accounts.get(0);
        Account acc2 = accounts.get(1);
        Account acc3 = accounts.get(2);
        Account acc4 = accounts.get(3);
        Account acc5 = accounts.get(4);

        User u1 = users.get(0);
        User u2 = users.get(1);
        User u3 = users.get(3);

        userDao.updateAccounts(u1.getId(), Arrays.asList(acc1.getId(), acc2.getId()));
        userDao.updateAccounts(u2.getId(), Arrays.asList(acc3.getId(), acc4.getId()));
        userDao.updateAccounts(u3.getId(), Collections.singletonList(acc5.getId()));

        accountDao.updateOwner(acc1.getId(), u1.getId());
        accountDao.updateOwner(acc2.getId(), u1.getId());
        accountDao.updateOwner(acc3.getId(), u2.getId());
        accountDao.updateOwner(acc4.getId(), u2.getId());
        accountDao.updateOwner(acc5.getId(), u3.getId());
    }

    private void findByName() {
        userDao.findManyByName("FN2").forEach(System.out::println);
        userDao.findManyByName("LN3").forEach(System.out::println);
    }

    private void findByAge() {
        userDao.findManyByAge((short) 40).forEach(System.out::println);
    }

    private void findByCity() {
        userDao.findManyByCity("City 1").forEach(System.out::println);
    }

    private void findByAccounts() {
        userDao.findManyByAccountsCount(1).forEach(System.out::println);
    }
}
