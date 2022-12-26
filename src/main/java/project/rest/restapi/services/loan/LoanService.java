package project.rest.restapi.services.loan;

import org.springframework.stereotype.Service;
import project.rest.restapi.entity.Collateral;
import project.rest.restapi.entity.Customer;
import project.rest.restapi.entity.Loan;
import project.rest.restapi.entity.RegistrationDtos;
import project.rest.restapi.repository.CollateralRepository;
import project.rest.restapi.repository.CustomerRepository;
import project.rest.restapi.repository.LoanRepository;

import java.util.List;

@Service
public class LoanService implements  LoanInterface{
    private final LoanRepository loanRepository;
    private final CustomerRepository customerRepository;
    private final CollateralRepository collateralRepository;

    public LoanService(LoanRepository loanRepository, CustomerRepository customerRepository, CollateralRepository collateralRepository) {
        this.loanRepository = loanRepository;
        this.customerRepository = customerRepository;
        this.collateralRepository = collateralRepository;
    }

    @Override
    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }


    public RegistrationDtos addLoan(RegistrationDtos registrationDtos) {


        Loan loanMake = new Loan();
        loanMake.setLoanNumber(registrationDtos.getLoans().getLoanNumber());
        loanMake.setTerm(registrationDtos.getLoans().getTerm());
        loanMake.setInterest(registrationDtos.getLoans().getInterest());
        loanMake.setAmount(registrationDtos.getLoans().getAmount());
        loanMake.setInterestRate(registrationDtos.getLoans().getInterestRate());
        loanMake.setUserId(registrationDtos.getLoans().getUserId());

        Customer customerMake = new Customer();
        customerMake.setPrivateNumber(registrationDtos.getCustomer().getPrivateNumber());
        customerMake.setLastName(registrationDtos.getCustomer().getLastName());
        customerMake.setFirstName(registrationDtos.getCustomer().getFirstName());
        customerMake.setBirthDate(registrationDtos.getCustomer().getBirthDate());

        Collateral collateralMake = new Collateral();
        collateralMake.setValue(registrationDtos.getCollateral().getValue());
        collateralMake.setType(registrationDtos.getCollateral().getType());


        loanRepository.save(loanMake);
        customerRepository.save(customerMake);
        collateralRepository.save(collateralMake);

        return registrationDtos;
    }
}
