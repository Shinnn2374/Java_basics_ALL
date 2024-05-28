import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        try(StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").build();
            SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().
                    buildSessionFactory();
            Session session = sessionFactory.openSession())
        {
            Transaction transaction = session.beginTransaction();

            session.createNativeQuery("TRUNCATE TABLE LinkedPurchaseList", LinkedPurchase.class)
                    .executeUpdate();

            List<Purchase> purchases = session
                    .createQuery("FROM " + Purchase.class.getSimpleName(), Purchase.class)
                    .getResultList();
            purchases.stream()
                    .map(LinkedPurchase::newLinkedPurchase)
                    .forEach(session::persist);

            transaction.commit();
        }
    }
}
