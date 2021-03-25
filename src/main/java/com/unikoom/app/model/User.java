package com.unikoom.app.model;

import com.unikoom.app.model.types.Sex;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Oleg Kiselev
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(of = {"id"})
@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "UserSeq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(generator = "UserSeq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    private String login;

    @NotBlank
    @Column(name = "full_name")
    private String fullName;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private Date birthday;

    @Enumerated(EnumType.STRING)
    private Sex sex;

}
