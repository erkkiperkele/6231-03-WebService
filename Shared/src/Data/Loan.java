package Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loan", propOrder = {
        "loanNumber",
        "customerAccountNumber",
        "amount",
        "dueDate"
})
public class Loan implements Serializable {

    private int loanNumber;
    private int customerAccountNumber;
    private long amount;
    private Date dueDate;

    public Loan(int loanNumber, int customerAccountNumber, long amount, Date dueDate) {
        this.loanNumber = loanNumber;
        this.customerAccountNumber = customerAccountNumber;
        this.amount = amount;
        this.dueDate = dueDate;
    }

    public Loan() {
    }

    public int getLoanNumber() {
        return this.loanNumber;
    }

    public int getCustomerAccountNumber() {
        return this.customerAccountNumber;
    }

    public long getAmount() {
        return this.amount;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String displayInfo = "";

        displayInfo += (this.loanNumber + " - ");
        displayInfo += (this.customerAccountNumber + " - ");
        displayInfo += (this.amount + " - ");
        displayInfo += (dateFormat.format(this.dueDate));

        return displayInfo;
    }
}
