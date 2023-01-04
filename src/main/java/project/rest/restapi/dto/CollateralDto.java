package project.rest.restapi.dto;


import jakarta.persistence.Enumerated;
import lombok.Data;
import project.rest.restapi.services.collateral.CollateralType;

@Data
public class CollateralDto {
    @Enumerated
    private CollateralType type;

    private String value;

    private String loanNumber;




}
