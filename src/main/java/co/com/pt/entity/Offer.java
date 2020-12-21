package co.com.pt.entity;

import co.com.pt.enums.OfferStatusForManagerEnum;
import co.com.pt.enums.OfferStatusForUserEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "offer")
// @Table(name = "offer", uniqueConstraints = {@UniqueConstraint(columnNames = { "project" })})
@ToString(exclude = { "project", "provider" })
public class Offer implements Serializable {

    @Id
    @Column(name = "offer_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    private Long offerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User provider;

    @ManyToOne
    // @JsonIgnoreProperties("offers")
    @JoinColumn(name = "project_id")
    private Project project;

    @Enumerated(EnumType.STRING)
    private OfferStatusForUserEnum offerStatusForUser;

    @Enumerated(EnumType.STRING)
    private OfferStatusForManagerEnum offerStatusForManager;

    ////////////////////////////
    @NotNull
    private BigDecimal amount;

    @NotNull
    private String deliverable;

    private String exclusions;

    private String requiredInformation;

    @NotNull
    private String paymentMethod;

    private String additionalNotes;

    // @NotNull
    private Date deliverDate;

    @NotNull
    private Integer proposedTerm;

    @NotNull
    private Integer unitProposedTerm;

    // @NotEmpty
    private String documents;
    ////////////////////////////

    @CreationTimestamp
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;

    public Project getProject() {
        return project;
    }

    public Long getProjectId() {
        return project.getProjectId();
    }
}