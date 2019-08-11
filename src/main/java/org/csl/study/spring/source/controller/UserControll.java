package org.csl.study.spring.source.controller;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.csl.study.spring.source.exception.BusinessException;
import org.csl.study.spring.source.po.User;
import org.csl.study.spring.source.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserControll {
    @Autowired
	private UserService userService;
	@RequestMapping("/getuser/{id}")
	public String getUserById(Model model,@PathVariable Integer id) {
		 model.addAttribute("message", "hello word33453433");
		 User user=  userService.getUserById(id);
		 model.addAttribute("username", user.getUserName());
		return "hello" ;
	}
	
	@RequestMapping("/userList")
	public String findAll(Model model) {
	
		RowBounds rowBounds = new RowBounds(0, 4);
		List<User> userList = userService.getUserList(rowBounds);
		model.addAttribute("userList", userList);
		return "userList" ;
	}	
	@RequestMapping("/json")
	@ResponseBody
	public User findAll() {
		User user=  userService.getUserById(1);
		
		return user;
	}
	
}
