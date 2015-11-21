package BankServices;

import Contracts.*;
import Data.*;
import Exceptions.RecordNotFoundException;
import Exceptions.TransferException;
import Services.BankService;
import Services.SessionService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.security.auth.login.FailedLoginException;
import javax.xml.ws.Endpoint;
import java.util.Date;

@WebService(targetNamespace = "http://bank")
public class BankWebService implements ICustomerServer, IManagerServer {

    private IBankService bankService;

    public BankWebService() {
    }

    public BankWebService(BankService bankService) {

        this.bankService = bankService;
        Bank bank = SessionService.getInstance().getBank();

        Object implementor = new BankWebService();
        String address = String.format("http://localhost:808%1$d/%2$s", bank.toInt(),  bank.name());
        System.out.println(address);

        Endpoint.publish(address, implementor);
        SessionService.getInstance().log().info(String.format("[WEB SERVICES] SERVER STARTED"));
    }

    @WebMethod
    public String sayHelloWorldFrom(String to) {
        String bankName = SessionService.getInstance().getBank().name();
        String result = String.format("Hello, %1$s, from %2$s", to, bankName);
        System.out.println(result);
        return result;
    }

    @WebMethod
    @Override
    public int openAccount(Bank bank, String firstName, String lastName, String emailAddress, String phoneNumber, String password) {

        int accountNumber = bankService.openAccount(bank, firstName, lastName, emailAddress, phoneNumber, password);

        return accountNumber;
    }

    @WebMethod
    @Override
    public Customer getCustomer(Bank bank, String email, String password)
            throws FailedLoginException {

        Customer foundCustomer = bankService.getCustomer(email, password);
        return foundCustomer;
    }

    @WebMethod
    @Override
    public Customer signIn(Bank bank, String email, String password)
            throws FailedLoginException {
        return getCustomer(bank, email, password);
    }

    @WebMethod
    @Override
    public Loan getLoan(Bank bank, int accountNumber, String password, long loanAmount)
            throws FailedLoginException {

        Loan newLoan = bankService.getLoan(bank, accountNumber, password, loanAmount);
        return newLoan;
    }

    @WebMethod
    @Override
    public Loan transferLoan(int loanId, Bank currentBank, Bank otherBank)
            throws TransferException {
        return null;
    }

    @WebMethod
    @Override
    public void delayPayment(Bank bank, int loanID, Date currentDueDate, Date newDueDate)
            throws RecordNotFoundException {
        bankService.delayPayment(bank, loanID, currentDueDate, newDueDate);
    }

    @WebMethod
    @Override
    public CustomerInfo[] getCustomersInfo(Bank bank)
            throws FailedLoginException {
        return bankService.getCustomersInfo(bank);
    }
}
