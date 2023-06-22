/**
 * Created By Krishna Shinde
 * Date : 22-06-2023
 * Time : 16:01
 * Project: OneToOneMappingWithHibernate
 **/

package onetoonemapping;

import jakarta.persistence.TypedQuery;
import onetoonemapping.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Iterator;
import java.util.List;

public class OneToOneMappingApplicationFetchDataFromDB {
    public static void main(String[] args) {
        StandardServiceRegistry ssrrr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(ssrrr).getMetadataBuilder().build();

        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Transaction txs = session.beginTransaction();

        TypedQuery query = session.createQuery("from Customer customer");
        List<Customer> list = query.getResultList();

        Iterator<Customer> iterator = list.listIterator();
        //we have to use the any condition to rectify the values of objects

        while (iterator.hasNext()) {

            Customer customer = iterator.next();
            System.out.println(customer.getCustomer_address() + "" + customer.getCustomer_email()
                    + "" + customer.getCustomer_name());
            onetoonemapping.entities.Transaction transaction = customer.getTxn();
            System.out.println(transaction.getTxn_date() + "" + transaction.getTxn_total());

        }
        session.close();
        System.out.println("Data has been retrieve successfully");
    }
}


