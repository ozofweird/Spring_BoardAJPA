package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@RequestMapping(value="/logout.do")
	public String handleRequest(HttpSession session) {
	
		// 宏扼快历客 楷搬等 技记 按眉 碍力 辆丰
		session.invalidate();

		return "login.jsp";
	}
}
