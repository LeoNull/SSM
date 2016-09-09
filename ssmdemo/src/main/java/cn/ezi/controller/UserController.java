package cn.ezi.controller;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ezi.pojo.User;
import cn.ezi.servieces.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	IUserService userService;
	@RequestMapping("/showUser")
	public String showUser(HttpServletRequest request,Model model){
		int num=Integer.parseInt(request.getParameter("id"));
		User user = userService.selectByPrimaryKey(num);
		model.addAttribute("user",user);
		return "showUser";
	}

}
