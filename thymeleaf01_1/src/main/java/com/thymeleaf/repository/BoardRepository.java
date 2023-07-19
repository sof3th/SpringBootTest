package com.thymeleaf.repository;

import com.thymeleaf.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Collection<Board> findByTitle(String title);
    Collection<Board> findByWriter(String writer);

    Collection<Board> findByTitleAndWriter(String title, String writer);

    Collection<Board> findByContentContaining(String content);

    Collection<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno);

}
