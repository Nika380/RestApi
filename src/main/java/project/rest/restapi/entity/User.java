package project.rest.restapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
@Entity
@Table(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    @Column(name = "create_date")
    private Date createDate = new Date();
    @Column(name = "active")
    private boolean active;


    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
