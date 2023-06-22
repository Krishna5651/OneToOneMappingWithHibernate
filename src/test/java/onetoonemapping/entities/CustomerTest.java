package onetoonemapping.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void testConstructor() {
        Customer actualCustomer = new Customer();
        actualCustomer.setCustomer_address("42 Main St");
        actualCustomer.setCustomer_email("jane.doe@example.org");
        actualCustomer.setCustomer_name("Customer name");
        Customer customer = new Customer();
        customer.setCustomer_address("42 Main St");
        customer.setCustomer_email("jane.doe@example.org");
        customer.setCustomer_name("Customer name");
        Transaction txn = new Transaction();
        customer.setTxn(txn);
        customer.setTxn_id(1);
        Transaction txn2 = new Transaction();
        txn2.setCustomer(customer);
        txn2.setTxn_date("2020-03-01");
        txn2.setTxn_id(1);
        txn2.setTxn_total("Txn total");
        Customer customer2 = new Customer();
        customer2.setCustomer_address("42 Main St");
        customer2.setCustomer_email("jane.doe@example.org");
        customer2.setCustomer_name("Customer name");
        customer2.setTxn(txn2);
        customer2.setTxn_id(1);
        Transaction txn3 = new Transaction();
        txn3.setCustomer(customer2);
        txn3.setTxn_date("2020-03-01");
        txn3.setTxn_id(1);
        txn3.setTxn_total("Txn total");
        actualCustomer.setTxn(txn3);
        actualCustomer.setTxn_id(1);
        assertEquals("42 Main St", actualCustomer.getCustomer_address());
        Transaction txn4 = actualCustomer.getTxn();
        Customer customer3 = txn4.getCustomer();
        assertEquals("42 Main St", customer3.getCustomer_address());
        Transaction txn5 = customer3.getTxn();
        Customer customer4 = txn5.getCustomer();
        assertEquals("42 Main St", customer4.getCustomer_address());
        assertEquals("jane.doe@example.org", actualCustomer.getCustomer_email());
        assertEquals("jane.doe@example.org", customer3.getCustomer_email());
        assertEquals("jane.doe@example.org", customer4.getCustomer_email());
        assertEquals("Customer name", actualCustomer.getCustomer_name());
        assertEquals("Customer name", customer3.getCustomer_name());
        assertEquals("Customer name", customer4.getCustomer_name());
        assertSame(txn3, txn4);
        assertSame(txn2, txn5);
        assertSame(txn, customer4.getTxn());
        assertEquals(1, actualCustomer.getTxn_id());
        assertEquals(1, customer3.getTxn_id());
        assertEquals(1, customer4.getTxn_id());
    }
}

