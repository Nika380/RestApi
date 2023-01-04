package project.rest.restapi.dto;
import lombok.Data;


@Data

public class LoansDto {



    private Integer userId;
    private String loanNumber;
    private Integer amount;
    private Double interestRate;
    private Integer term;
    private Integer interest;



}
