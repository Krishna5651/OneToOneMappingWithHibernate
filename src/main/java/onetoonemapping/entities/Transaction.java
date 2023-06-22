/**
 * Created By Krishna Shinde
 * Date : 21-06-2023
 * Time : 17:19
 * Project: OneToOneMapping
 **/

package onetoonemapping.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int txn_id;
    private String txn_date;
    private String txn_total;
    @OneToOne(mappedBy = "txn")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Customer customer;

    public int getTxn_id() {
        return txn_id;
    }

    public void setTxn_id(int txn_id) {
        this.txn_id = txn_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTxn_date() {
        return txn_date;
    }

    public void setTxn_date(String txn_date) {
        this.txn_date = txn_date;
    }

    public String getTxn_total() {
        return txn_total;
    }

    public void setTxn_total(String txn_total) {
        this.txn_total = txn_total;
    }


}


