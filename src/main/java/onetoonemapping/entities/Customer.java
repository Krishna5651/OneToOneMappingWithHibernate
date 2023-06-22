/**
 * Created By Krishna Shinde
 * Date : 21-06-2023
 * Time : 17:19
 * Project: OneToOneMapping
 **/

package onetoonemapping.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customer")
public class Customer {
@Id
@GeneratedValue(generator = "gen")
@GenericGenerator(name = "gen",strategy = "foreign",parameters = {@org.hibernate.annotations.Parameter(name = "property",value = "txn")})
    private int txn_id;
    private String customer_name;
    private String customer_email;
    private String customer_address;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Transaction txn;

    public int getTxn_id() {
        return txn_id;
    }

    public void setTxn_id(int txn_id) {
        this.txn_id = txn_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public Transaction getTxn() {
        return txn;
    }

    public void setTxn(Transaction txn) {
        this.txn = txn;
    }
}


