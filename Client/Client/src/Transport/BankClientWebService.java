//package Transport;
//
//import Contracts.ICustomerServer;
//import Contracts.IManagerServer;
//import Data.Bank;
//import Data.Customer;
//import Data.CustomerInfo;
//import Data.Loan;
//import Exceptions.RecordNotFoundException;
//import Exceptions.TransferException;
//
//import javax.security.auth.login.FailedLoginException;
//import java.util.Date;
//
//
//public class BankClientWebService implements ICustomerServer, IManagerServer {
//
//
//    @Override
//    public int openAccount(Bank bank, String firstName, String lastName, String emailAddress, String phoneNumber, String password) {
//
//        return 0;
//    }
//
//    @Override
//    public Customer getCustomer(Bank bank, String email, String password) throws FailedLoginException {
//        return null;
//    }
//
//    @Override
//    public Customer signIn(Bank bank, String email, String password) throws FailedLoginException {
//        return null;
//    }
//
//    @Override
//    public Loan getLoan(Bank bank, int accountNumber, String password, long loanAmount) throws FailedLoginException {
//        return null;
//    }
//
//    @Override
//    public Loan transferLoan(int loanId, Bank currentBank, Bank otherBank) throws TransferException {
//        return null;
//    }
//
//    @Override
//    public void delayPayment(Bank bank, int loanID, Date currentDueDate, Date newDueDate) throws RecordNotFoundException {
//
//    }
//
//    @Override
//    public CustomerInfo[] getCustomersInfo(Bank bank) throws FailedLoginException {
//        return new CustomerInfo[0];
//    }
//}
