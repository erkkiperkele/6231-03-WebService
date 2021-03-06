package WebServiceClient;

import Contracts.ICustomerServer;
import Contracts.IManagerServer;
import Data.Bank;
import Data.Customer;
import Data.CustomerInfo;
import Data.Loan;
import Exceptions.RecordNotFoundException;
import WebServiceClient.XMLExceptions.FailedLoginException_Exception;
import WebServiceClient.XMLExceptions.RecordNotFoundException_Exception;
import WebServiceClient.XMLExceptions.TransferException_Exception;

//import javax.jws.WebService;
import javax.security.auth.login.FailedLoginException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class BankWS implements ICustomerServer, IManagerServer {


    private final BankWebService service;

    public BankWS(Bank bank) {
        service = new BankWebService_Service().getBankWebService(bank);
    }

    @Override
    public int openAccount(Bank bank, String firstName, String lastName, String emailAddress, String phoneNumber, String password) {

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

        try {
            return service.transferLoan(loanId, currentBank, otherBank);
        } catch (TransferException_Exception e) {
            throw new Exceptions.TransferException(e.getMessage());
        }
    }

    @Override
    public void delayPayment(Bank bank, int loanID, Date currentDueDate, Date newDueDate) throws RecordNotFoundException {
        //TODO: Implement

        GregorianCalendar c = new GregorianCalendar();


        try {
            c.setTime(currentDueDate);
            XMLGregorianCalendar xmlCurrent = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            c.setTime(newDueDate);
            XMLGregorianCalendar xmlNew = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

            service.delayPayment(bank, loanID, xmlCurrent, xmlNew);
        } catch (RecordNotFoundException_Exception e) {
            throw new RecordNotFoundException(e.getMessage());
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CustomerInfo[] getCustomersInfo(Bank bank) throws FailedLoginException {

        List<CustomerInfo> info;
        try {
            info = service.getCustomersInfo(bank);
        } catch (FailedLoginException_Exception e) {
            throw new FailedLoginException(e.getMessage());
        }

        return info.toArray(new CustomerInfo[info.size()]);
    }
}
