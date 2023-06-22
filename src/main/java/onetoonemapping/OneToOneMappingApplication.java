package onetoonemapping;


import onetoonemapping.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class OneToOneMappingApplication {

    public static void main(String[] args) {
        StandardServiceRegistry ssrrr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssrrr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Transaction txs = session.beginTransaction();

        Customer customer = new Customer();
        customer.setCustomer_name("Ajay");
        customer.setCustomer_email("ajay@gmail.com");
        customer.setCustomer_address("sangali");


        onetoonemapping.entities.Transaction transaction = new onetoonemapping.entities.Transaction();
        transaction.setTxn_date("30/03/2023");
        transaction.setTxn_total("18000");

        customer.setTxn(transaction);
        transaction.setCustomer(customer);

        session.persist(customer);
        txs.commit();

        session.close();
        System.out.println("Sussecfully done");
    }

}
