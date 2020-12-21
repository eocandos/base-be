package co.com.pt.entity;

import co.com.pt.shared.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="department")
@DynamicUpdate
// @JsonIgnoreProperties(value = "cities")
public class Department implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "department_id")
    @JsonView(Views.NoCities.class)
    private Long departmentId;

    // @NotNull
    @JsonView(Views.NoCities.class)
    private String departmentName;

    // @NotNull
    private boolean enabled;

    @OneToMany( mappedBy = "department", cascade = CascadeType.ALL )
    private List<City> cities;

    /*
    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;*/

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

}
