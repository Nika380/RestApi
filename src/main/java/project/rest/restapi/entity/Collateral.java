package project.rest.restapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import project.rest.restapi.services.collateral.CollateralType;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "collaterals")
public class Collateral {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    @Enumerated
    private CollateralType type;

    @Column(name = "loan_number")
    private String loanNumber;

    @Column(name = "value")
    private String value;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @PrePersist
    void prePersist () {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }



}
