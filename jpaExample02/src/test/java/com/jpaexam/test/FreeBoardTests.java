package com.jpaexam.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpaexam.entity.FreeBoard;
import com.jpaexam.entity.FreeBoardReply;
import com.jpaexam.repository.FreeBoardReplyRepository;
import com.jpaexam.repository.FreeBoardRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@Commit
public class FreeBoardTests {

	@Autowired
	FreeBoardRepository boardRepo;
	
	@Autowired
	FreeBoardReplyRepository replyRepo;	

	/*
	@Autowired
	Logger log;*/
	
	@Test
	public void insertSamples(){
		
		IntStream.range(1,200).forEach(i ->{
			
			FreeBoard board = new FreeBoard();
			board.setBno((long) i);
			board.setTitle("Free Board ... " + i);
			board.setContent("Free Content.... "+ i);
			board.setWriter("user"+ i%10 );
			
			boardRepo.save(board);
		});
			
	}
	
	@Transactional
	@Test
	public void insertReply2Way() {
		
		Optional<FreeBoard> result = boardRepo.findById(199L);				
		
		result.ifPresent(board ->{
			List<FreeBoardReply> replies = board.getReplies();
			
			FreeBoardReply reply = new FreeBoardReply();
			reply.setReply("REPLY..............");
			reply.setReplyer("replyer00");
			reply.setBoard(board);
			
			replies.add(reply);
			
			board.setReplies(replies);

			boardRepo.save(board);
		});
		
	}
	
	@Test
	public void insertReply1Way(){

		FreeBoard board = new FreeBoard();
		board.setBno(199L);
		
		FreeBoardReply reply = new FreeBoardReply();
		reply.setReply("REPLY..............");
		reply.setReplyer("replyer00");
		reply.setBoard(board);
		
		replyRepo.save(reply);
		
	}
	
	@Test
	public void testList1(){
		
		Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
		
		boardRepo.findByBnoGreaterThan(0L, page).forEach(board ->{

			System.out.println(board.getBno() +": " +board.getTitle());
			//log.info(board.getBno() +": " +board.getTitle() );
			
		});
	}

	@Transactional
	@Test
	public void testList2(){
		
		Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
		
		boardRepo.findByBnoGreaterThan(0L, page).forEach(board ->{

			System.out.println(board.getBno() +": " +board.getTitle()  +":" + board.getReplies().size());
			//log.info(board.getBno() +": " +board.getTitle()  +":" + board.getReplies().size());
			
		});
	}
	
	@Test
	public void testList3(){
		
		Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
		
		boardRepo.getPage(page).forEach(arr ->
			System.out.println(Arrays.toString(arr)));
				//log.info(Arrays.toString(arr)));
	}
	
	@Test
	public void testList52(){
		
		Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
		
		boardRepo.getPage52(page).forEach(arr ->
				System.out.println(Arrays.toString(arr)));
						//log.info(Arrays.toString(arr)));
	}
	
	@Test
	public void testRead(){
		
		Optional<FreeBoard> result = boardRepo.findById(200L);
		
		FreeBoard board = result.get();
		
		List<FreeBoardReply> replies = replyRepo.getReply(board);
		
		replies.forEach(reply  ->
				System.out.println("REPLY: "+reply));
				//log.info("REPLY: "+reply));
		
		
	}

	
	
}
