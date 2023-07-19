package com.thymeleaf.repository;

import com.thymeleaf.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTest {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass() {
        System.out.println(memoRepository.getClass().getName());
    }

    @Test
    public void testInsert() {

        Memo memo = new Memo();

        IntStream.rangeClosed(1, 100).forEach(i -> {
            Memo m = Memo.builder().memoText("test test " + i + " test").build();
            System.out.println(memoRepository.save(m));
        });
    }

    @Test
    public void testSelect() {
        Long mno = 15L;
        Optional<Memo> result = memoRepository.findById(mno);

        if (result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    @Test
    public void testDelete() {
        Long mno = 19L;
        Optional<Memo> result = memoRepository.findById(mno);

        if (result.isPresent()) {
            Memo memo = result.get();
            memoRepository.delete(memo);
        }
    }
}
