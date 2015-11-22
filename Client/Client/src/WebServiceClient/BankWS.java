package WebServiceClient;

import Data.*;
import Contracts.ICustomerServer;
import Contracts.IManagerServer;
import Data.Bank;
import Data.Customer;
import Data.CustomerInfo;
import Data.Loan;
import Exceptions.RecordNotFoundException;
import WebServiceClient.FailedLoginException_Exception;

//import javax.jws.WebService;
import javax.security.auth.login.FailedLoginException;
import java.util.Date;
import java.util.List;

public class BankWS implements ICustomerServer, IManagerServer {


    private final BankWebService service;

//    public static void main(String[] argv) {
//        BankWebService service = new BankWebService_Service().getBankWebService();
//
//
//        //invoke business method
//        String test = service.sayHelloWorldFrom("Aymeric");
//        System.out.println(test);
//
//    }

    public BankWS(Bank bank) {
        service = new BankWebService_Service().getBankWebService(bank);
        //invoke business method
        service.sayHelloWorldFrom("Aymeric");

    }

    @Override
    public int openAccount(Bank bank, String firstName, String lastName, String emailAddress, String phoneNumber, String password) {

//        Bank mappedBank = WebServiceClient.Bank.Royal;

        int accountNumber = service.openAccount(bank, firstName, lastName, emailAddress, phoneNumber, password);
        System.out.println("Account Number: " + accountNumber);
        return accountNumber;
    }

    @Override
    public Customer getCustomer(Bank bank, String email, String password)
            throws javax.security.auth.login.FailedLoginException {
        try {
            return service.getCustomer(bank, email, password);
        } catch (FailedLoginException_Exception e) {
            throw new FailedLoginException(e.getMessage());
        }
    }

    @Override
    public Customer signIn(Bank bank, String email, String password) throws FailedLoginException {
        try {
            return service.signIn(bank, email, password);
        } catch (FailedLoginException_Exception e) {
            throw new FailedLoginException(e.getMessage());
        }
    }

    @Override
    public Loan getLoan(Bank bank, int accountNumber, String password, long loanAmount) throws FailedLoginException {

        try {
            return service.getLoan(bank, accountNumber, password, loanAmount);
        } catch (FailedLoginException_Exception e) {
            throw new FailedLoginException(e.getMessage());
        }
    }

    @Override
    public Loan transferLoan(int loanId, Bank currentBank, Bank otherBank) throws Exceptions.TransferException {

//        return null;
//
        try {
            return service.transferLoan(loanId, currentBank, otherBank);
        } catch (TransferException_Exception e) {
            throw new Exceptions.TransferException(e.getMessage());
        }
    }

    @Override
    public void delayPayment(Bank bank, int loanID, Date currentDueDate, Date newDueDate) throws RecordNotFoundException {
        //TODO: Implement
//        service.delayPayment(bank, loanID, currentDueDate, newDueDate);
    }

    @Override
    public CustomerInfo[] getCustomersInfo(Bank bank) throws FailedLoginException {
//        return null;

//        return new CustomerInfo[0];
        List<CustomerInfo> info;
        try {
            info = service.getCustomersInfo(bank);
        } catch (FailedLoginException_Exception e) {
            throw new FailedLoginException(e.getMessage());
        }

        return info.toArray(new CustomerInfo[info.size()]);
    }
}
