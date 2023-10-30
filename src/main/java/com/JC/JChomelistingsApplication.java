package com.JC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.JC"})
@SpringBootApplication
public class JChomelistingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JChomelistingsApplication.class, args);
	}
}
