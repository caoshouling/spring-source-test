package org.csl.study.spring.source.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.csl.study.spring.source.common.JsonResponse;
import org.csl.study.spring.source.po.User;
import org.csl.study.spring.source.po.UserPageQueryVo;
import org.csl.study.spring.source.service.UserService;
import org.csl.study.spring.source.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;

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
	
	@RequestMapping("/userlistPage")
	public String  userlistPage() {
		
		return "user/userlist" ;
	}	
	@RequestMapping("/userform")
	public String  userform() {
		
		return "user/userform" ;
	}	
	@RequestMapping("/userlist")
	@ResponseBody
	public JsonResponse  findAll(UserPageQueryVo vo,@RequestParam(value = "pageNum",required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
	
		PageInfo<User> userPage = userService.findUserListWithPage(vo,pageNum ,pageSize);
		
		return  new JsonResponse(userPage);
	}
	@RequestMapping("/save")
	@ResponseBody
	public JsonResponse addUser (UserVo userVo,HttpServletRequest request ) throws IllegalStateException, IOException {
		
		System.out.println("user = "+userVo);
		
		List<MultipartFile> images = userVo.getImages();
		List<String> fileNames = new ArrayList<>();
		if(images != null){
			for(MultipartFile imgMultipartFile :images){
				String fileName = imgMultipartFile.getOriginalFilename();
				fileNames.add(fileName);
				File imageFile = new File(request.getServletContext().getRealPath("/static/img"),fileName);
				
				imgMultipartFile.transferTo(imageFile);
			}
		}
		User user = userService.saveUser(userVo);
		
		return new JsonResponse(user).success();
	}
	
}
