package project.rest.restapi.services.loan;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import project.rest.restapi.SearchParameters.SearchParams;
import project.rest.restapi.entity.Collateral;
import project.rest.restapi.entity.Customer;
import project.rest.restapi.entity.Loan;
import project.rest.restapi.entity.RegistrationDtos;
import project.rest.restapi.exceptions.NotFoundException;
import project.rest.restapi.repository.CollateralRepository;
import project.rest.restapi.repository.CustomerRepository;
import project.rest.restapi.repository.LoanRepository;
import java.util.Objects;
import java.util.Optional;

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
    public Page<Loan> getLoans(SearchParams params) {



        return loanRepository.findAll((root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            if(params.getLoanNumber() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("loanNumber"), params.getLoanNumber()));
            }


            if(params.getAmount()!=null) {
                predicate = cb.and(predicate, cb.equal(root.get("amount"), params.getAmount()));
            }

            if(params.getType()!=null) {
                Join<Loan, Collateral> collateralJoin = root.join("collateral", JoinType.LEFT);
                predicate = cb.and(predicate, cb.equal(collateralJoin.get("type"),params.getType()));
            }

            if(params.getValue()!=null) {
                Join<Loan, Collateral> collateralJoin = root.join("collateral", JoinType.LEFT);
                predicate = cb.and(predicate, cb.equal(collateralJoin.get("value"), params.getValue()));
            }

            if(params.getPrivateNumber()!=null) {
                Join<Loan, Customer> customer = root.join("customer", JoinType.LEFT);
                predicate = cb.and(predicate, cb.equal(customer.get("privateNumber"), params.getPrivateNumber()));
            }
            if(params.getDateFrom()!=null) {
                predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get("createdAt"), params.getDateFrom()));
            }
            if(params.getDateTo()!=null) {
                predicate = cb.and(predicate, cb.lessThanOrEqualTo(root.get("createdAt"), params.getDateTo()));
            }


            return  predicate;
        },PageRequest.of(params.getPage(), params.getPageSize()));


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
        collateralMake.setLoanNumber(registrationDtos.getCollateral().getLoanNumber());


        if(customerRepository.findById(loanMake.getUserId()).isEmpty()) {
            throw new NotFoundException("Customer Does Not Exist");
        } else if (loanRepository.findByLoanNumber(loanMake.getLoanNumber()) != null) {
            if(Objects.equals(loanMake.getLoanNumber(), collateralMake.getLoanNumber())) {
                collateralRepository.save(collateralMake);
                return registrationDtos;
            }
            throw new NotFoundException("Loan With This Loan Number Already Exist");
        } else if(!Objects.equals(loanMake.getLoanNumber(), collateralMake.getLoanNumber())) {
            throw new NotFoundException("Loan Numbers Does Not Match");
        }
        else {
            loanRepository.save(loanMake);
            collateralRepository.save(collateralMake);
        }



        return registrationDtos;
    }

    public Optional<Loan> loanById(int id) {
        return loanRepository.findById(id);
    }
    public void update() {
        loanRepository.updateInterest();
    }

}
