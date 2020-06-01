package com.sallu.api.entities;

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
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user")
public class User implements Serializable {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_user")
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<FichaMedica> medicalRecords;

    // Nome
    @NotBlank(message = "{user.nm_user}")
    @JsonProperty
    @Column(name = "nm_user", length = 128, nullable = false)
    private String name;

    @JsonProperty
    @Column(name = "nm_tel", length = 15, nullable = false)
    private String telephone;

    // Data de Nascimento
    @NotNull(message = "{user.dt_birthday}")
    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dt_birthday", nullable = false)
    private Date birthdayDate;

    // Sexo
//    @NotBlank(message = "{user.user_sex}")
//    @JsonProperty
//    @Column(name = "user_sex", nullable = false)
//    private String sex;

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