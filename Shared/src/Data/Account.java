package Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "account")
public class Account implements Serializable {

    private int accountNumber;
    private Customer owner;
    private long creditLimit;

    public Account(int accountNumber, Customer owner, long creditLimit) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.creditLimit = creditLimit;
    }

    public Account() {
    }

    public Customer getOwner() {
        return this.owner;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public long getCreditLimit() {
        return this.creditLimit;
    }
}
