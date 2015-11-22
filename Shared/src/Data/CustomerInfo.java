package Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerInfo")
public class CustomerInfo implements Serializable {

    private String userName;
    private Account account;
    private String lastName;
    private String firstName;
    private List<Loan> loans;

    public CustomerInfo(Account account, List<Loan> loans) {
        this.userName = account.getOwner().getUserName();
        this.firstName = account.getOwner().getFirstName();
        this.lastName = account.getOwner().getLastName();
        this.account = account;
        this.loans = loans;
    }

    public CustomerInfo() {
    }

    public String getUserName() {
        return this.userName;
    }

    public Account getAccount() {
        return this.account;
    }

    public List<Loan> getLoans() {
        return this.loans != null
                ? this.loans
                : new ArrayList();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
