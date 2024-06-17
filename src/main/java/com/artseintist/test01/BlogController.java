package com.artseintist.test01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
	@RequestMapping(value = "/home")
	public String home() {
		return "home";
	}
	@RequestMapping(value = "/test")
	public String test() {
		return "sample1";
	}
	
	@RequestMapping(value = "/member") // 별병
	public String member(Model model) {
		
		model.addAttribute("mname", "이순신");
		return "/user/member"; // 실제 주소
	}
	
	@RequestMapping(value = "/test2") // 요청에 폴더명을 넣으면 하나로 묶을 수가 있음
	public String test2() {
		return "sample2"; // 실제 주소
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

//	@RequestMapping(value = "/loginok")
//	public String loginOk(HttpServletRequest request, Model model) { // 내장객체가 아니기 때문에
//		// 전역변수가 되면 안되며, 변수로 넣어줘야함
//		
//		String mid = request.getParameter("memberId");
//		String mpw = request.getParameter("memberPw");  
//		// DB에서 만들어야 하는 뭔가가 필요하다? 그럼 이게 필요함
//		
//		// 보낼 때도 그냥 보낼 수 없음 -- model이라는 객체를 사용함
//		
//		model.addAttribute("loginid", mid); // 앞에는 String, 뒤에는 Object - 아무거나 들어가도됨
//		// method 이름은 똑같은데 여러개 형태로 만드는게 오버로딩
//		
//		model.addAttribute("loginpw", mpw); 
//		model.addAttribute("User", "홍길동");
//		
//		
//		return "loginOk";
//	}
	
	
	@RequestMapping(value = "/loginok")
	public ModelAndView loginOk(HttpServletRequest request, ModelAndView mv) { 
		// 반환타입 중요
		
		// model과 viwe 객체를 합침
		
		String mid = request.getParameter("memberId");
		String mpw = request.getParameter("memberPw");  
		// DB에서 만들어야 하는 뭔가가 필요하다? 그럼 이게 필요함
		
		// 보낼 때도 그냥 보낼 수 없음 -- model이라는 객체를 사용함
		
//		model.addAttribute("loginid", mid); // 앞에는 String, 뒤에는 Object - 아무거나 들어가도됨
//		// method 이름은 똑같은데 여러개 형태로 만드는게 오버로딩
//		
//		model.addAttribute("loginpw", mpw); 
//		model.addAttribute("User", "홍길동");
		
		mv.addObject("loginid", mid);
		mv.addObject("loginpw", mpw);
		mv.addObject("User", "홍길동");
		
		mv.setViewName("loginOk");

		
		
		return mv;
	}

}
