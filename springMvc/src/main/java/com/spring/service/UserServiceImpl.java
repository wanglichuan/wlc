package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.User;
import com.spring.jpa.userRepository;
/**
 * �û�ҵ�����ʵ����
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	
	 @Autowired
	    private userRepository userRepository;//ע��UserRepository
	 
	@Override
	@Transactional
	public void saveUser(User user) {
		userRepository.save(user);
	}
	/**
	 * ʵ�ֲ�ѯ���е��û���Ϣ
	 */
	@Override
	@Transactional
	public List<User> findAll() {
		
		return userRepository.findAll();
	}
	/**
	 * ͨ���������ɵ�Pageable����
	 */
	@Override
	public Page<User> pageList(Integer pageNo) {
		Sort sort = new Sort(new Order(Direction.ASC, "id"));
		PageRequest pageRequest = new PageRequest(pageNo, 3,sort);
		return userRepository.findAll(pageRequest);
	}
	 /**
	  * ֱ�ӻ�ȡPageable����ʽ
	  * 
	  * @param pageable
	  * @return
	  */
	public	Page<User> pageList1(@PageableDefault(value=3,
			sort={"id"},direction=Sort.Direction.ASC) Pageable pageable){
		
				return userRepository.findAll(pageable);
		
	}
	@Override
	public void delete(Integer id) {
		userRepository.delete(id);
	}
	@Override
	public User findById(Integer id) {
		User user = userRepository.findOne(id);
		return user;
	}
	@Override
	public void update(Integer id) {
		User  user = userRepository.findOne(id);
		userRepository.save(user);
	}
}
