package com.spring.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.entity.User;
/**
 * 
 * @author Administrator
 *	创建一个jpa持久化创库
 *
 */
public interface userRepository extends JpaRepository<User, Integer>{
		
		
}
