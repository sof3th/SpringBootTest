package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.example.domain.MemberVO;



@Controller
public class SampleController {

	@GetMapping("/sample1")
	public void sample1(Model model) {
		model.addAttribute("greeting", "Hello World!!!");
	}
	
	@GetMapping("/sample2")
	public void sample2(Model model) {
		MemberVO tmp = new MemberVO(100, "id00", "pw00", "hong",  new Timestamp(System.currentTimeMillis()));
		
		model.addAttribute("member", tmp);
	}
	
	@GetMapping("/sample3")
	public void sample3(Model model) {

		List<MemberVO> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			list.add(new MemberVO(123, "u0" + i, "p0" + i, "홍길동" + i, new Timestamp(System.currentTimeMillis())));
		}
		model.addAttribute("list", list);
	}
	
	@GetMapping("/sample4")
	public void sample4(Model model) {

		List<MemberVO> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			
			list.add(new MemberVO(i, "u000" + i % 3, "p0000" + i % 3, "홍길동" + i,
					new Timestamp(System.currentTimeMillis())));
		}

		model.addAttribute("list", list);

	}

	@GetMapping("/sample5")
	public void sample5(Model model) {

		String result = "SUCCESS";

		model.addAttribute("result", result);

	}

	@GetMapping("/sample6")
	public void sample6(Model model) {

		List<MemberVO> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			
			list.add(new MemberVO(i, "u0" + i, "p0" + i, "홍길동" + i,
					new Timestamp(System.currentTimeMillis())));
		}

		model.addAttribute("list", list);

		String result = "SUCCESS";

		model.addAttribute("result", result);

	}
	
	
	@GetMapping("/sample7")
	public void sample7(Model model) {

		model.addAttribute("now", new Date());
		model.addAttribute("price", 123456789);
		model.addAttribute("title", "This is a just sample.");
		model.addAttribute("options", Arrays.asList("AAAA","BBB","CCC","DDD"));
		
	}
	
	@GetMapping("/sample8")
	public void sample8(Model model) {
		
	}
	
	@GetMapping("/sample9")
	public void sample9(Model model) {
		
	}
	
	@GetMapping("/sample/hello")
	public void hello(){
		
	}
}
