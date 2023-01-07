package project.rest.restapi.SearchParameters;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import project.rest.restapi.services.collateral.CollateralType;

import java.time.LocalDate;

@Data
public class SearchParams {

    private String loanNumber;
    private Integer amount;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateTo;

    private String privateNumber;
    @Enumerated(EnumType.STRING)
    private CollateralType type;
    private String value;

    private Integer pageSize = 10;
    private Integer page = 0;
}
