package project.rest.restapi.SearchParameters;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import project.rest.restapi.services.collateral.CollateralType;
import java.time.LocalDateTime;

@Data
public class SearchParams {

    private String loanNumber;
    private Integer amount;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime dateFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime dateTo;

    private String privateNumber;
    private CollateralType type;
    private String value;

    private Integer pageSize = 10;
    private Integer page = 0;
}
