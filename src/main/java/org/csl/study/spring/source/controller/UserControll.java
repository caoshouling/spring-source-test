package org.csl.study.spring.source.controller;

import java.util.List;

import org.csl.study.spring.source.po.User;
import org.csl.study.spring.source.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageRowBounds;

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
	
	@RequestMapping("/userlist")
	public String findAll(Model model) {
	
		PageRowBounds pageRowBounds = new PageRowBounds(3, 4);
		List<User> userList = userService.getUserList(pageRowBounds);
		model.addAttribute("userList", userList);
		return "user/userlist" ;
	}	
	@RequestMapping("/json")
	@ResponseBody
	public User findAll() {
		User user=  userService.getUserById(1);
		
		return user;
	}
	
}
