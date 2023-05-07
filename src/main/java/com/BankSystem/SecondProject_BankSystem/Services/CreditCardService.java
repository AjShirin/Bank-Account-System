package com.BankSystem.SecondProject_BankSystem.Services;

        import com.BankSystem.SecondProject_BankSystem.Models.CreditCard;
        import com.BankSystem.SecondProject_BankSystem.Models.Customer;
        import com.BankSystem.SecondProject_BankSystem.Models.Loan;
        import com.BankSystem.SecondProject_BankSystem.Models.Transaction;
        import com.BankSystem.SecondProject_BankSystem.Repositories.CreditCardRepository;
        import com.BankSystem.SecondProject_BankSystem.Repositories.CustomerRepository;
        import com.BankSystem.SecondProject_BankSystem.RequestObject.LoanRequest;
        import com.BankSystem.SecondProject_BankSystem.RequestObject.creditCardRequest;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.text.DateFormat;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.List;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public void createCreditCard(creditCardRequest creditCardRequest) {
        CreditCard creditCard = new CreditCard(); // create object
        creditCard.setCardNumber(creditCardRequest.getCardNumber());
        creditCard.setCreditLimit(creditCardRequest.getCreditLimit());
        creditCard.setUpdatedDate(new Date()); // give current date
        creditCard.setCreatedDate(new Date());// give current date
        creditCard.setIsActive(Boolean.TRUE);
        Customer customer = customerRepository.findById(creditCardRequest.getCustomerID()).get();
        creditCard.setCustomer(customer);
        creditCardRepository.save(creditCard);
    }

    //function that gets all CreditCard (getAllCreditCard)
    public List<CreditCard> getAllCreditCard() {
        return creditCardRepository.getAllCreditCard();
    }

    // Function that updates Credit Card (whole row) [updateCreditCard]
    public String updateCreditCard(creditCardRequest creditCardRequest) {
        try {
            CreditCard creditCard = creditCardRepository.getCreditCardById1(creditCardRequest.getId());
            creditCard.setCreditLimit(creditCardRequest.getCreditLimit());
            creditCard.setUpdatedDate(new Date());
            creditCard.setIsActive(Boolean.TRUE);
            creditCardRepository.save(creditCard);
            return "The Account ID:" + creditCardRequest.getId() + " has been successfully updated :)";
        } catch (Exception e) {
            return "An error occurred, record is not updated. Please try again.";
        }
    }
    // function that makes the is active to false (deleteCreditCardById)
    public void deleteCreditCardById(creditCardRequest creditCardRequest) {
        CreditCard creditCard = creditCardRepository.getCreditCardById1(creditCardRequest.getId());
        creditCard.setIsActive(Boolean.FALSE);
        creditCardRepository.save(creditCard);
    }
}
