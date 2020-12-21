package co.com.pt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="project_product")
@DynamicUpdate
public class ProjectProduct implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Integer productId;

    @NotNull
    private String productName;

    @ManyToOne
    @JoinColumn(name = "segment_id")
    @JsonIgnore
    private ProjectSegment segment;

    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;

    public ProjectProduct() {
    }

    public ProjectProduct(String productName) {
        this.productName = productName;
    }

}
