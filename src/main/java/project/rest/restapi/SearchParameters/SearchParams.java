package project.rest.restapi.SearchParameters;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import project.rest.restapi.services.collateral.CollateralType;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SearchParams {

    private String loanNumber;
    private Integer amount;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateTo;

    private String privateNumber;
    private CollateralType type;
    private String value;

    private Integer pageSize;
    private Integer page;

//    სესხის ნომერი
//    სესხის თანხა
//    სესხის შექმნის თარიღის შუალედი
//    კლიენტის პირადი ნომერი
//    უზრუნველყოფის ტიპი
//    უზრუნველყოფის სახელი
}
