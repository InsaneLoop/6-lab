import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // Create and save User
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        session.save(user);

        // Create and save Product
        Product product = new Product();
        product.setName("Laptop");
        product.setPrice(1200.00);
        product.setUser(user);
        session.save(product);

        // Fetch data
        User fetchedUser = session.get(User.class, 1);
        System.out.println(fetchedUser.getName());

        // Update data
        fetchedUser.setName("Updated Name");
        session.update(fetchedUser);

        // Delete data
        session.delete(product);

        transaction.commit();
        session.close();
    }
}
