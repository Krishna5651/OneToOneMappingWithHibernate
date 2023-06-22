package onetoonemapping.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class TransactionTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link Transaction}
     *   <li>{@link Transaction#setCustomer(Customer)}
     *   <li>{@link Transaction#setTxn_date(String)}
     *   <li>{@link Transaction#setTxn_id(int)}
     *   <li>{@link Transaction#setTxn_total(String)}
     *   <li>{@link Transaction#getCustomer()}
     *   <li>{@link Transaction#getTxn_date()}
     *   <li>{@link Transaction#getTxn_id()}
     *   <li>{@link Transaction#getTxn_total()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Transaction actualTransaction = new Transaction();
        Transaction txn = new Transaction();
        Customer customer = new Customer();
        txn.setCustomer(customer);
        txn.setTxn_date("2020-03-01");
        txn.setTxn_id(1);
        txn.setTxn_total("Txn total");
        Customer customer2 = new Customer();
        customer2.setCustomer_address("42 Main St");
        customer2.setCustomer_email("jane.doe@example.org");
        customer2.setCustomer_name("Customer name");
        customer2.setTxn(txn);
        customer2.setTxn_id(1);
        Transaction txn2 = new Transaction();
        txn2.setCustomer(customer2);
        txn2.setTxn_date("2020-03-01");
        txn2.setTxn_id(1);
        txn2.setTxn_total("Txn total");
        Customer customer3 = new Customer();
        customer3.setCustomer_address("42 Main St");
        customer3.setCustomer_email("jane.doe@example.org");
        customer3.setCustomer_name("Customer name");
        customer3.setTxn(txn2);
        customer3.setTxn_id(1);
        actualTransaction.setCustomer(customer3);
        actualTransaction.setTxn_date("2020-03-01");
        actualTransaction.setTxn_id(1);
        actualTransaction.setTxn_total("Txn total");
        Customer customer4 = actualTransaction.getCustomer();
        assertSame(customer3, customer4);
        Transaction txn3 = customer4.getTxn();
        Customer customer5 = txn3.getCustomer();
        assertSame(customer2, customer5);
        Transaction txn4 = customer5.getTxn();
        assertSame(customer, txn4.getCustomer());
        assertEquals("2020-03-01", actualTransaction.getTxn_date());
        assertEquals("2020-03-01", txn3.getTxn_date());
        assertEquals("2020-03-01", txn4.getTxn_date());
        assertEquals(1, actualTransaction.getTxn_id());
        assertEquals(1, txn3.getTxn_id());
        assertEquals(1, txn4.getTxn_id());
        assertEquals("Txn total", actualTransaction.getTxn_total());
        assertEquals("Txn total", txn3.getTxn_total());
        assertEquals("Txn total", txn4.getTxn_total());
    }
}

