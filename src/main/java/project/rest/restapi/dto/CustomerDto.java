package project.rest.restapi.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


import java.time.LocalDate;

@Data
public class CustomerDto {
    private String privateNumber;
    private String firstName;
    private String lastName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;
}
