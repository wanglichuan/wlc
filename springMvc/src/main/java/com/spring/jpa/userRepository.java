package com.spring.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.entity.User;
/**
 * 
 * @author Administrator
 *	����һ��jpa�־û�����
 *
 */
public interface userRepository extends JpaRepository<User, Integer>{
		
		
}
