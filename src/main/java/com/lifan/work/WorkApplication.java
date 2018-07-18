package com.lifan.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author steven.sheng
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@RestController
public class WorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkApplication.class, args);
	}

	@RequestMapping("/")
	public String home(){
		return "For 则一妈妈";
	}

}
