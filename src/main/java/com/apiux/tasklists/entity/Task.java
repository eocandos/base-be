package com.apiux.tasklists.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
    @Column(name = "task_id")
    private Long taskId;

    private String taskName;

    private String taskDescription;

    private boolean active = true;

    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;

}
