package com.thymeleaf.repository;

import com.thymeleaf.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void testClass() {
        System.out.println(boardRepository.getClass().getName());
    }

    @Test
    public void testInsert() {
        Board board = new Board();

        IntStream.rangeClosed(1, 100).forEach(i -> {
            Board b = Board.builder().title("title " + i).writer("writer " + i).content("content " + i).build();
            System.out.println(boardRepository.save(b));
        });
    }

    @Test
    public void testInsertMulti() {

        /*
        Map<String, List<String>> boardMap = new HashMap<String, List<String>>();
        boardMap.put("title", Arrays.asList("날씨", "전달", "spring", "jpa"));
        boardMap.put("content", Arrays.asList("다음 주 까지 비 예보가 계속 됩니다.", "수요일까지 교육입니다. 잘 챙겨서 오세요.", "spring 교육 어떤가요?.", "jpa 누구나 할수 있습니다."));
        boardMap.put("user", Arrays.asList("park", :"choi", "song", "lee"));

        boardMap.forEach((title, content, user) -> {});
         */
    }

    @Test
    public void testSelect() {
        Long bno = 20L;
        Optional<Board> result = boardRepository.findById(bno);

        if (result.isPresent()) {
            Board board = result.get();
            System.out.println(board);
        }
    }

    @Test
    public void testSelectByTitle() {
        Collection<Board> boardList = boardRepository.findByTitle("title 20");
        System.out.println(boardList);
        boardList.forEach(board -> {
            System.out.println(board);
        });
    }

    @Test
    public void testSelectByWriter() {
        Collection<Board> boardList = boardRepository.findByWriter("writer 30");
        System.out.println(boardList);
        boardList.forEach(board -> {
            System.out.println(board);
        });
    }

    @Test
    public void testSelectByTitleAndWrite() {
        Collection<Board> boardList = boardRepository.findByTitleAndWriter("title 20", "writer 20");
        System.out.println(boardList);
        boardList.forEach(board -> {
            System.out.println(board);
        });
    }

    @Test
    public void testSelectByContentContaining() {
        Collection<Board> boardList = boardRepository.findByContentContaining("content");
        System.out.println(boardList.getClass().getName());
        System.out.println(boardList.stream().count());
        boardList.forEach(board -> {
            System.out.println(board);
        });
    }

    @Test
    public void testDelete() {
        Long bno = 11L;
        Optional<Board> result = boardRepository.findById(bno);

        if (result.isPresent()) {
            Board board = result.get();
            boardRepository.delete(board);
        }
    }

    @Test
    public void testPage() {
        Pageable pageable = PageRequest.of(20, 4);
        Page<Board> res = boardRepository.findAll(pageable);

        System.out.println("Total Pages : " + res.getTotalPages());
        res.get().forEach(board -> System.out.println(board));
    }

    @Test
    public void testPageSort() {

        Sort sort1 = Sort.by("bno").descending();

        Pageable pageable = PageRequest.of(20, 4, sort1);
        Page<Board> res = boardRepository.findAll(pageable);

        System.out.println("Total Pages : " + res.getTotalPages());
        res.get().forEach(board -> System.out.println(board));


    }
}

