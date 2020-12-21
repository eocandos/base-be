package co.com.pt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="project_category")
@DynamicUpdate
public class ProjectCategory implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long categoryId;

    private String categoryName;

    @OneToMany( mappedBy = "category")
    private List<ProjectSegment> segments;

    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;

    public ProjectCategory() {
    }

    public ProjectCategory(String categoryName) {
        this.categoryName = categoryName;
    }

}
