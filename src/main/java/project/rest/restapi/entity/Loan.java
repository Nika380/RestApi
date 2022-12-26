package project.rest.restapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "loans")
public class Loan {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "loan_number")
    private String loanNumber;
    @Basic
    @Column(name = "amount")
    private Integer amount;
    @Basic
    @Column(name = "interest_rate")
    private Double interestRate;
    @Basic
    @Column(name = "term")
    private Integer term;
    @Basic
    @Column(name = "interest")
    private Integer interest;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Basic
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Basic
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    void prePersist () {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Customer customer;




}
