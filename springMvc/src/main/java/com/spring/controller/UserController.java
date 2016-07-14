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

//@RestController���ڲ����õ�Controller ����һ��json����
@Controller
@RequestMapping("/user")
public class UserController {
	
	 @Autowired
	 private UserService UserService;
	 /**
	  * ��ѯ���е��û���Ϣ
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
	  * ��ת�����ҳ��
	  * @return
	  */
	 @RequestMapping("/toAdd")
	 public String toAdd(){
		 return "user/add";
	 }
	 /**
	  * ʵ�����
	  * @param user
	  * @return
	  */
	 
	 @RequestMapping(value="/add" ,method = RequestMethod.GET)
	 public String add(User user){
		 UserService.saveUser(user);//ִ����Ӳ���
		// List<User> users = UserService.findAll();//����ȫ������Ա��Ϣ
		// model.addAttribute("users", users);
		 return "redirect:/user/index";
	 }
	 /**
	  * ʵ�ַ�ҳ��ѯ
	  */
	 @RequestMapping("/page")
	 public String listUsers(Map<String, Object> map,@RequestParam(required=false,defaultValue="0")Integer pageNo, HttpSession session) {
			Page<User> listUser = UserService.pageList(pageNo);
			map.put("page", listUser);
			//map.put("user", session.getAttribute("user"));
			return "user/pageList";
		}
	 
	 /**
	  * ʵ��ɾ��Ա����Ϣ
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
	  * ʵ�ָ���
	  * @param id
	  * @return
	  */
	 @RequestMapping(value="/update",method = RequestMethod.GET)
	 public String updateUser(Integer id){
		 UserService.update(id);
		return "redirect:/user/page";
		 
	 }
}
