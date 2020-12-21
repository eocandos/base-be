package co.com.pt.entity;

import co.com.pt.enums.AnswerStateEnum;
import co.com.pt.enums.MessageNotifyEnum;
import co.com.pt.enums.QuestionStateEnum;
import co.com.pt.shared.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "message")
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
@ToString(exclude = { "project", "provider", "client" })
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,  generator="seq")
    @Column(name = "message_id", updatable = false, nullable = false)
    @JsonView(Views.Messages.class)
    private Long messageId;

    @ManyToOne
    // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "project_id")
    @JsonView(Views.Messages.class)
    private Project project;

    @JsonView(Views.Messages.class)
    private String question;

    @ManyToOne(fetch = FetchType.EAGER)
    // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private User provider;

    @JsonView(Views.Messages.class)
    private String answer;

    @ManyToOne(fetch = FetchType.EAGER)
    // @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    private User client;

    @Enumerated(EnumType.STRING)
    @JsonView(Views.Messages.class)
    private QuestionStateEnum questionState;

    @Enumerated(EnumType.STRING)
    @JsonView(Views.Messages.class)
    private AnswerStateEnum answerState;

    @Enumerated(EnumType.STRING)
    @JsonView(Views.Messages.class)
    private MessageNotifyEnum notify; // NEW - SOLVED

    @CreationTimestamp
    private Date questionDate;
    private Date answerDate;
    @UpdateTimestamp
    private Date updateDate;

}
