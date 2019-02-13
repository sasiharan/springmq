package com.example.springmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableJms
public class SpringmqApplication {
	@Autowired
	private JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringmqApplication.class, args);
	}


	@GetMapping("send")
	String send(){
		try{
			jmsTemplate.convertAndSend("DEV.QUEUE.1", "Hello World!");
			//System.out.println(jmsTemplate.getConnectionFactory().toString());
			return "OK";
		}catch(JmsException ex){
			return "FAIL";
		}
	}
}

