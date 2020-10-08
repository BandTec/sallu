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
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<MedicalRecord> medicalRecords;

    @NotBlank(message = "{user.name}")
    @JsonProperty
    @Column(name = "name", length = 128, nullable = false)
    private String name;

    @JsonProperty
    @Column(name = "cellphone", length = 15, nullable = false)
    private String cellphone;

    //@JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday")
    private Date birthday;

    @NotBlank(message = "{user.sex}")
    @JsonProperty
    //@Column(name = "sex", length = 1, nullable = false)
    private String sex;

    @Email(message = "{email.valid}")
    @NotBlank(message = "{user.email}")
    @JsonProperty
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Size(min = 8, message = "{password.length}")
    @JsonProperty
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull(message = "{user.bl_admin}")
    @JsonProperty
    @Column(name = "is_admin")
    private Boolean isAdmin;
}