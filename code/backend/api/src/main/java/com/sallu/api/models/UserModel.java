package com.sallu.api.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user", uniqueConstraints = @UniqueConstraint(columnNames = "nm_email", name = "email"))
public class UserModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_user")
    private Integer id;

    @NotBlank(message = "{user.nm_user}")
    @JsonProperty
    @Column(name = "nm_user", length = 128, nullable = false)
    private String name;

    @NotNull(message = "{user.dt_birthday}")
    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dt_birthday", nullable = false)
    private LocalDate birthdayDate;

    @NotBlank(message = "{user.user_sex}")
    @JsonProperty
    @Column(name = "user_sex", length = 1, nullable = false)
    private String sex;

    @Email(message = "{email.valid}")
    @NotBlank(message = "{user.nm_email}")
    @JsonProperty
    @Column(name = "nm_email", nullable = false, unique = true)
    private String email;

    @Size(min = 8, message = "{password.length}")
    @NotBlank(message = "{user.nm_password}")
    @JsonProperty
    @Column(name = "nm_password", nullable = false)
    private String password;

    @NotNull(message = "{user.bl_admin}")
    @JsonProperty
    @Column(name = "bl_admin", nullable = false)
    private Boolean admin;
}