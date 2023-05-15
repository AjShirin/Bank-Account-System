package com.BankSystem.SecondProject_BankSystem.Services;

import com.BankSystem.SecondProject_BankSystem.Models.Account;
import com.BankSystem.SecondProject_BankSystem.Models.Customer;
import com.BankSystem.SecondProject_BankSystem.Repositories.AccountRepository;
import com.BankSystem.SecondProject_BankSystem.Repositories.CreditCardRepository;
import com.BankSystem.SecondProject_BankSystem.Repositories.CustomerRepository;
import com.BankSystem.SecondProject_BankSystem.Repositories.TransactionRepository;
import com.BankSystem.SecondProject_BankSystem.RequestObject.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    // function to create new Account (createAccount)
    public void createAccount(Integer accountNumber, Double balance, Integer customerID) {
        Account account = new Account(); // create object
        account.setAccountNumber(accountNumber);
        account.setBalance(balance);
        account.setCreatedDate(new Date()); // give current date
        account.setUpdatedDate(new Date()); // give current date
        account.setIsActive(Boolean.TRUE);
        Customer customer = customerRepository.findById(customerID).get();
        account.setCustomer(customer);
        accountRepository.save(account);
    }

    //function that gets all the Account (getAllAccount)
    public List<Account> getAllAccount() {
        return accountRepository.getAllAccount();
    }

    // Function that updates Account (whole row) [updateAccount]
    public String updateAccount(AccountRequest accountRequest) {
        try {
            Account account = accountRepository.getAccountById(accountRequest.getId());
            account.setBalance(accountRequest.getBalance());
            account.setUpdatedDate(new Date());
            account.setIsActive(Boolean.TRUE);
            accountRepository.save(account);
            return "The Account ID:" + accountRequest.getId() + " has been successfully updated :)";
        } catch (Exception e) {
            return "An error occurred, record is not updated. Please try again.";
        }
    }

    // function that makes the is active to false (deleteAccountById)
    public void deleteAccountById(AccountRequest accountRequest) {
        Account account = accountRepository.getAccountById(accountRequest.getId());
        account.setIsActive(Boolean.FALSE);
        accountRepository.save(account);
    }
    // Question 3.Create a function to Update the account balance when a transaction is made.
//    public void updateAccountBalance(Integer accountId, Double transactionAmount) {
//        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
//        Double currentBalance = account.getBalance();
//        Double newBalance = currentBalance + transactionAmount;
//        account.setBalance(newBalance);
//        accountRepository.save(account);
//    }


//    public void createTransaction(AccountRequest accountRequest) {
//        Account account = accountRepository.findById(accountRequest.getAccountId()).orElseThrow(() -> new RuntimeException("Account not found"));
//        Double currentBalance = account.getBalance();
//        Double newBalance = currentBalance + accountRequest.get
//                .getAmount();
//        account.setBalance(newBalance);
//        accountRepository.save(account);
//    }

//    public void createTransaction(AccountRequest accountRequest) throws ParseException {
//        Account account = accountRepository.findById(accountRequest.getId()).orElseThrow(() -> new RuntimeException("Account not found"));
//
//        Transaction transaction = new Transaction();
//        transaction.setAmount(accountRequest.getAmount());
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
//        Date convertedDateFromStringToDateFormat = dateFormatter.parse(accountRequest.getTransactionDate());
//        transaction.setTransactionDate(convertedDateFromStringToDateFormat);
//        transaction.setCreatedDate(new Date());
//        transaction.setUpdatedDate(new Date());
//        transaction.setIsActive(Boolean.TRUE);
//        transaction.setAccount(account);
//        transactionRepository.save(transaction);
//
//        Double currentBalance = account.getBalance();
//        Double newBalance = currentBalance + accountRequest.getAmount();
//        account.setBalance(newBalance);
//        accountRepository.save(account);
//    }


    // Question 5 Generate a monthly statement for the account.
    public String generateMonthlyStatement(Integer accountId) {
        Account account = accountRepository.getAccountById(accountId);
        Customer customer = account.getCustomer(); // Calendar to get the current month and year. // Gets the Customer object associated with the Account object.
        Calendar cal = Calendar.getInstance();//  creates a new Calendar object and sets it to the current date and time.
        //The getInstance() method returns a Calendar object that is initialized with the current date and time.
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);

        String statementForAccount = "Monthly Statement for Account: " + account.getAccountNumber() + "\n" +
                "Customer Name: " + customer.getName() + "\n" +
                "Month: " + new DateFormatSymbols().getMonths()[month] + " " + year + "\n" +
                "Customer Email: " + customer.getEmail() + "\n" +
                "Customer Phone: " + customer.getPhone() + "\n" +
                "Account Balance: " + account.getBalance() + "\n";

        return statementForAccount;
    }

    // Question 2. Function that Retrieves the account balance for a specific account.
    public double getBalanceForSpecificAccount(Integer id) {
        return accountRepository.getBalanceForSpecificAccount(id);
    }


    public List<Account> getCustomerAccountInformation(Integer customerId) {
        return accountRepository.getCustomerAccountInformation(customerId);
    }
}
