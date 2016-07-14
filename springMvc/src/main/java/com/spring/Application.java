package com.spring;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * spring-boot������� ����������Ϣ��main����
 * @author Administrator
 *
 */
@SpringBootApplication  
@Controller  
public class Application {  
      
    @RequestMapping("/")  
    public String index(){  
        return "../../index.html";  
    }  
      
    public static void main(String[] args) {  
    	 ApplicationContext ctx = SpringApplication.run(Application.class, args);

         System.out.println("spring boot �ṩ����");

         String[] beanNames = ctx.getBeanDefinitionNames();
         Arrays.sort(beanNames);
         for (String beanName : beanNames) {
             System.out.println(beanName);
         }
    }  
}  