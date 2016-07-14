package com.spring.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.User;
import com.spring.service.UserService;

//@RestController用于测试用的Controller 返回一个json数据
@Controller
@RequestMapping("/user")
public class UserController {
	
	 @Autowired
	 private UserService UserService;
	 /**
	  * 查询所有的用户信息
	  * @return
	  */
	 @RequestMapping("/index" )
	 public String findUser(Map<String, Object> map){
		 List<User> users = UserService.findAll();
		// model.addAttribute("user", users);
		map.put("user", users);
		// map.put("user", session.getAttribute("user"));
		return "user/userIndex";	 
	 }
	 
	
	 /**
	  * 跳转到添加页面
	  * @return
	  */
	 @RequestMapping("/toAdd")
	 public String toAdd(){
		 return "user/add";
	 }
	 /**
	  * 实现添加
	  * @param user
	  * @return
	  */
	 
	 @RequestMapping(value="/add" ,method = RequestMethod.GET)
	 public String add(User user){
		 UserService.saveUser(user);//执行添加操作
		// List<User> users = UserService.findAll();//查找全部的人员信息
		// model.addAttribute("users", users);
		 return "redirect:/user/index";
	 }
	 /**
	  * 实现分页查询
	  */
	 @RequestMapping("/page")
	 public String listUsers(Map<String, Object> map,@RequestParam(required=false,defaultValue="0")Integer pageNo, HttpSession session) {
			Page<User> listUser = UserService.pageList(pageNo);
			map.put("page", listUser);
			//map.put("user", session.getAttribute("user"));
			return "user/pageList";
		}
	 
	 /**
	  * 实现删除员工信息
	  * @param id
	  * @return
	  */
	 @RequestMapping("/del")
	 public String delteUser(Integer id){
		UserService.delete(id);
		return "redirect:/user/page";
	 }
	 @RequestMapping("/toUpdate")
	 public String toUpdateUser(Integer id,Map<String,Object> map){
		 User user = UserService.findById(id);
		 map.put("user", user);
		return "user/update";
	 }
	 /**
	  * 实现更新
	  * @param id
	  * @return
	  */
	 @RequestMapping(value="/update",method = RequestMethod.GET)
	 public String updateUser(Integer id){
		 UserService.update(id);
		return "redirect:/user/page";
		 
	 }
}
