import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

public class Main {
    public static void main(String[] args) {
        Account account=new Account();
        account.setMoney(2432);
        Customer customer=new Customer();
        customer.setName("Julke");
        customer.setAccount(account);
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("testPersistenceUnit");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction= entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(customer);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

    }
}
