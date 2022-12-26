package project.rest.restapi.entity;

import lombok.Data;
import project.rest.restapi.dto.CollateralDto;
import project.rest.restapi.dto.CustomerDto;
import project.rest.restapi.dto.LoansDto;


@Data
public class RegistrationDtos {

    private  LoansDto loans;
    private  CustomerDto customer;
    private  CollateralDto collateral;


}
