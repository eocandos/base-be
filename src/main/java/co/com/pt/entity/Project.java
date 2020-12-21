package co.com.pt.entity;

import co.com.pt.enums.ProjectStateForManagerEnum;
import co.com.pt.enums.ProjectStateForUserEnum;
import co.com.pt.shared.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "project")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "user")
@JsonIgnoreProperties(value = {"user", "offers", "messages"})
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @Column(name = "project_id")
    @JsonView(Views.Messages.class)
    private Long projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany( mappedBy = "project", cascade = CascadeType.ALL)
    private List<Offer> offers;

    @OneToMany( mappedBy = "project", cascade = CascadeType.MERGE)
    private List<Message> messages;

    @NotNull
    @JsonView(Views.Messages.class)
    private String projectName;

    @NotNull
    private String projectDescription;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ProjectCategory.class)
    @JoinColumn(name = "category_id")
    private ProjectCategory projectCategory;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ProjectSegment.class)
    @JoinColumn(name = "segment_id")
    private ProjectSegment projectSegment;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ProjectProduct.class)
    @JoinColumn(name = "product_id")
    private ProjectProduct projectProduct;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Department.class)
    @JoinColumn(name = "department_execution_id")
    private Department departmentExecution;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = City.class)
    @JoinColumn(name = "city_execution_id")
    private City cityExecution;

    // @NotNull
    // private Integer categoryType;

    @NotNull
    private Integer duration;

    @NotNull
    private Integer unitDuration;

    @NotNull
    private BigDecimal projectPrice;

    @NotNull
    private Date closingDate;

    @NotNull
    private Date adjudicationDate;

    @Enumerated(EnumType.STRING)
    private ProjectStateForUserEnum projectStateForUser;

    @Enumerated(EnumType.STRING)
    private ProjectStateForManagerEnum projectStateForManager;

    @NotNull
    private String contactNameProject;
    @NotNull
    private String contactEmailProject;
    @NotNull
    private String contactMobilePhoneProject;
    //@NotNull
    private String contactPhoneProject;
    //@NotNull
    private String contactExtensionProject;

    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;

    public Long getProjectId() {
        return projectId;
    }
}
