import config.HibernateFactoryUtil;
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        save();
        get();
//        getHQL();
//        getSQL();
//        getCriteria();
//        saveOneToOne();
//        saveOneToMany();
//        saveManyToMany();
    }

    private static void save() throws InterruptedException {
        final Greeter greetJpa = new Greeter();
        greetJpa.setGreeting("Bye");
        greetJpa.setTarget("JPA");

        final Greeter greetHibernate = new Greeter();
        greetHibernate.setGreeting("Hello");
        greetHibernate.setTarget("Hibernate");

        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(greetHibernate);
        session.save(greetJpa);
        session.getTransaction().commit();
        session.close();
    }

    private static void get() {
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.createQuery("from Greeter", Greeter.class)
                .list()
                .forEach(g -> System.out.printf("%s, %s!%n", g.getGreeting(), g.getTarget()));
        session.close();
    }

    private static void getHQL() {
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.createQuery("from Greeter ", Greeter.class)
                .list()
                .forEach(System.out::println);

        session.createQuery("from Greeter as p where p.target like :name", Greeter.class)
                .setParameter("name", "Hiberna%")
                .list()
                .forEach(System.out::println);

        session.createNamedQuery("getGreeterByTarget", Greeter.class)
                .setParameter("name", "Hibernate")
                .list()
                .forEach(System.out::println);
    }

    private static void getSQL() {
        final SessionFactory sessionFactory = HibernateFactoryUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        System.out.println("No greeters: " +
                session.createSQLQuery("select count(identifier) as c from Greeter")
                        .addScalar("c", IntegerType.INSTANCE)
                        .uniqueResult());

        session.createNativeQuery("select * from Greeter")
                .addEntity(Greeter.class)
                .list()
                .forEach(System.out::println);

        session.createSQLQuery("select target as \"name\" from Greeter")
                .setResultTransformer(Transformers.aliasToBean(NameDTO.class))
                .list()
                .forEach(System.out::println);
    }

    private static void getCriteria() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        final Greeter greeter = new Greeter();
        greeter.setGreeting("Hello");
        greeter.setTarget("JPA");
        entityManager.persist(greeter);
        entityManager.getTransaction().commit();

        entityManager.createQuery("select g from Greeter g", Greeter.class)
                .getResultList()
                .forEach(System.out::println);

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Greeter> criteriaQuery = criteriaBuilder.createQuery(Greeter.class);
        Root<Greeter> getterRoot = criteriaQuery.from(Greeter.class);
        criteriaQuery.select(getterRoot);
        entityManager.createQuery(criteriaQuery)
                .getResultList()
                .forEach(System.out::println);

        criteriaQuery = criteriaBuilder.createQuery(Greeter.class);
        getterRoot = criteriaQuery.from(Greeter.class);
        criteriaQuery.select(getterRoot);
        criteriaQuery.where(criteriaBuilder.equal(getterRoot.get("target"), "Hibernate"));
        entityManager.createQuery(criteriaQuery)
                .getResultList()
                .forEach(System.out::println);

        criteriaQuery = criteriaBuilder.createQuery(Greeter.class);
        getterRoot = criteriaQuery.from(Greeter.class);
        criteriaQuery.select(getterRoot);
        criteriaQuery.where(criteriaBuilder.like(getterRoot.get("target"), "JP%"));
        entityManager.createQuery(criteriaQuery)
                .getResultList()
                .forEach(System.out::println);
    }

    private static void saveOneToOne() {
        final Responsible responsible = new Responsible();
        responsible.setName("Bob");

        final Greeter greetHibernate = new Greeter();
        greetHibernate.setGreeting("Hello");
        greetHibernate.setTarget("Hibernate");
        greetHibernate.setResponsible(responsible);

        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(greetHibernate);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    private static void saveOneToMany() {
        final Responsible responsible = new Responsible();
        responsible.setName("Bob");

        final Place place1 = new Place();
        place1.setName("place1");
        place1.setResponsible(responsible);
        final Place place2 = new Place();
        place2.setName("place2");
        place2.setResponsible(responsible);

        responsible.getPlaces().addAll(Arrays.asList(place1, place2));

        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(responsible);
        entityManager.flush();
        entityManager.getTransaction().commit();

        entityManager.createQuery("from Responsible", Responsible.class)
                .getResultList()
                .forEach(System.out::println);
    }

    private static void saveManyToMany() {
        final Company company1 = new Company();
        company1.setName("company1");
        final Company company2 = new Company();
        company2.setName("company2");

        final Responsible responsible1 = new Responsible();
        responsible1.setName("responsible1");
        final Responsible responsible2 = new Responsible();
        responsible2.setName("responsible2");

        company1.getResponsibles().addAll(Arrays.asList(responsible1, responsible2));
        company2.getResponsibles().addAll(Arrays.asList(responsible1, responsible2));

        responsible1.getCompanies().addAll(Arrays.asList(company1, company2));
        responsible2.getCompanies().addAll(Arrays.asList(company1, company2));

        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(responsible1);
        entityManager.persist(responsible2);
        entityManager.flush();
        entityManager.getTransaction().commit();

        entityManager.createQuery("from Responsible", Responsible.class)
                .getResultList()
                .forEach(System.out::println);

        entityManager.createQuery("from Company", Company.class)
                .getResultList()
                .forEach(System.out::println);
    }
}
