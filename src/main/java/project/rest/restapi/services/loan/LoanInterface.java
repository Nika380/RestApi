package project.rest.restapi.services.loan;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import project.rest.restapi.SearchParameters.SearchParams;
import project.rest.restapi.dto.LoansDto;
import project.rest.restapi.entity.Loan;
import project.rest.restapi.entity.RegistrationDtos;

import java.util.List;

public interface LoanInterface {
    Page<Loan> getLoans(SearchParams params);

    RegistrationDtos addLoan(RegistrationDtos registrationDtos);
}
