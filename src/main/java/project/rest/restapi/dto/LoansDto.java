package project.rest.restapi.dto;
import lombok.Data;
import project.rest.restapi.entity.Loan;
import project.rest.restapi.repository.CollateralRepository;


@Data

public class LoansDto {



    private Integer userId;
    private String loanNumber;
    private Integer amount;
    private Double interestRate;
    private Integer term;
    private Integer interest;



}
