package project.rest.restapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import project.rest.restapi.SearchParameters.SearchParams;
import project.rest.restapi.entity.Loan;
import project.rest.restapi.entity.RegistrationDtos;
import project.rest.restapi.services.loan.LoanService;

import java.util.Optional;


@RestController
@RequestMapping("/loans")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("")
    Page<Loan> getLoans(SearchParams params) {
        return loanService.getLoans(params);
    }

    @PostMapping("/register")
    RegistrationDtos addLoan(@RequestBody RegistrationDtos registrationDtos) {
        return loanService.addLoan(registrationDtos);
    }

    @GetMapping("/{id}")
    Optional<Loan> getById(@PathVariable int id) {
        return loanService.loanById(id);
    }

    @Scheduled(fixedRate = 10_000)
    @PutMapping("")
    void update() {
        loanService.update();
    }



}
