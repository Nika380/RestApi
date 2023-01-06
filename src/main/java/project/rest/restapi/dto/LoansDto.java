package project.rest.restapi.dto;
import lombok.Data;

import java.math.BigInteger;


@Data

public class LoansDto {



    private Integer userId;
    private String loanNumber;
    private double amount;
    private double interestRate;
    private Integer term;
    private double interest;



}
