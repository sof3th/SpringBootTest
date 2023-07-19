package com.thymeleaf.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="tbl_board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bno;

    @NonNull
    private String title;

    private String writer;

    private String content;

    @CreationTimestamp
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regdate;

    @UpdateTimestamp
    @Column(name ="updatedate" )
    private LocalDateTime updatedate;


    public void changeTitle(String title){
        this.title = title;
    }

    public void changeContent(String content){
        this.content = content;
    }
}
