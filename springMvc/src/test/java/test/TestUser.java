package test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.entity.User;
import com.spring.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/springMvc/src/main/resources/config/application.yml"}) 
public class TestUser {
	
	@Autowired
	 private UserService userService;
	//�����û�
	public void testSaveUser(){
		User user = new User();
		user.setName("����");
		user.setPassword("123");
		user.setPhone("123456110");
		user.setEmail("12346@qq.com");
		
		userService.saveUser(user);
		System.out.println("�ɹ�");
	}
}
