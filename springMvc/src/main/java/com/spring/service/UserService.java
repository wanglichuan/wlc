package com.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.entity.User;

/**
 * 业务层接口
 * @author Administrator
 *
 */
public interface UserService {
	/**
	 * 保存用户
	 * @param user
	 */
	 void saveUser(User user);
	 /**
	  * 查找全部用户
	  * @return list
	  */
	 List<User> findAll();
	 /**
	  * 实现分页查询
	  * 利用 Page进行分页
	  * @param pageNo
	  * @return
	  */
	 Page<User> pageList(Integer pageNo);
	 /**
	  * 直接获取pageable对象实现分页
	  * @param pageable
	  * @return
	  */
	 public	Page<User> pageList1(Pageable pageable);
	 
	 /*删除*/
	 void delete(Integer id);
	 /*根据id查找用户*/
	 User findById(Integer id);
	 /*修改用户*/
	 void update(Integer id);
}
