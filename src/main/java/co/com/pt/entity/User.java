package co.com.pt.entity;

import co.com.pt.enums.UserStateEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Data
@NoArgsConstructor
@ToString(exclude = "project")
@Table(name = "users")
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NaturalId
    @NotNull
    private String email;

    @NotNull
    @Size(min = 3, message = "Length must be more than 3")
    private String password;

    @NotNull
    private String name;

    @NotNull
    private Integer docType;

    @NotNull
    private String docNumber;

    @NotNull
    private String mobilePhone;

    private String phone;

    private String extension;

    @NotNull
    private String address;

    /*
    @NotEmpty
    private String personType;*/

    /*
    @Enumerated(EnumType.STRING)
    private UserStateEnum state;*/

    private boolean active;

    private String role = "ROLE_CLIENT";
/*
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Favorite favorite;*/

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Project> project;

    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;

}
