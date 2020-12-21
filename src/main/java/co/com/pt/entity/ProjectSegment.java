package co.com.pt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="project_segment")
@DynamicUpdate
public class ProjectSegment implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "segment_id")
    private Long segmentId;

    @NotNull
    private String segmentName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private ProjectCategory category;

    @OneToMany( mappedBy = "segment")
    private List<ProjectProduct> products;

    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;

    public ProjectSegment() {
    }

    public ProjectSegment(String segmentName) {
        this.segmentName = segmentName;
    }

}
