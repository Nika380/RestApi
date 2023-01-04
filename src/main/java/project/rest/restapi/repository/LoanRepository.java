package project.rest.restapi.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.rest.restapi.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>, JpaSpecificationExecutor<Loan> {


    @Modifying
    @Transactional
    @Query("UPDATE Loan SET interest = interest + (amount * (interestRate / 365) / (24 * 60) * 3), updatedAt = local_datetime ")
    void updateInterest();

    Loan findByLoanNumber(String loanNumber);
}
