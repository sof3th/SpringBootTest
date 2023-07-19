package com.thymeleaf.dto;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BoardDTO {

    private Long bno;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime regdate;
    private LocalDateTime updatedate;
}
