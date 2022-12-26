package project.rest.restapi.controller;

import org.springframework.web.bind.annotation.*;
import project.rest.restapi.dto.LoansDto;
import project.rest.restapi.entity.Loan;
import project.rest.restapi.entity.RegistrationDtos;
import project.rest.restapi.services.loan.LoanService;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("")
    List<Loan> getLoans() {
        return loanService.getLoans();
    }

    @PostMapping("/register")
    RegistrationDtos addLoan(@RequestBody RegistrationDtos registrationDtos) {
        return loanService.addLoan(registrationDtos);
    }

}
