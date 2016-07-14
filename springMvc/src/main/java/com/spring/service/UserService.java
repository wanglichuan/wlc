package com.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.entity.User;

/**
 * ҵ���ӿ�
 * @author Administrator
 *
 */
public interface UserService {
	/**
	 * �����û�
	 * @param user
	 */
	 void saveUser(User user);
	 /**
	  * ����ȫ���û�
	  * @return list
	  */
	 List<User> findAll();
	 /**
	  * ʵ�ַ�ҳ��ѯ
	  * ���� Page���з�ҳ
	  * @param pageNo
	  * @return
	  */
	 Page<User> pageList(Integer pageNo);
	 /**
	  * ֱ�ӻ�ȡpageable����ʵ�ַ�ҳ
	  * @param pageable
	  * @return
	  */
	 public	Page<User> pageList1(Pageable pageable);
	 
	 /*ɾ��*/
	 void delete(Integer id);
	 /*����id�����û�*/
	 User findById(Integer id);
	 /*�޸��û�*/
	 void update(Integer id);
}
