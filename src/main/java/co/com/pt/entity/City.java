package co.com.pt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="city")
@DynamicUpdate
public class City implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "city_id")
    private Long cityId;

    @NotNull
    private String cityName;

    @NotNull
    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    /*
    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;*/

    public City() {
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

}
