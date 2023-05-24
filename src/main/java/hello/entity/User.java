package hello.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "users")
@Getter @Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    @Enumerated
    private EncryptionAlgorithm algorithm;

    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<Authority> authorities;

}
