package project.rest.restapi.services.loan;

import org.springframework.data.domain.Page;
import project.rest.restapi.dto.LoansDto;
import project.rest.restapi.entity.Loan;
import project.rest.restapi.entity.RegistrationDtos;

import java.util.List;

public interface LoanInterface {
    List<Loan> getLoans();

    RegistrationDtos addLoan(RegistrationDtos registrationDtos);
}
