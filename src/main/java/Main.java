import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by SCIP on 29.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
    }
}
