package com.example.springwebjdk17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebJdk17Application {

	public static void main(String[] args) {
//		var dotenv = Dotenv.configure().load();
//		dotenv.entries().forEach((entry) -> {
//			System.out.println("entry = " + entry);
////			System.setProperty(entry.getKey(), entry.getValue());
//		});

//		System.out.println("dotenv.get(\"DB_CS\") = " + dotenv.get("DB_CS"));
//		System.setProperty("DB_CS", dotenv.get("DB_CS"));

		var ctx = SpringApplication.run(SpringWebJdk17Application.class, args);

//		PersonRepo repo = ctx.getBean(PersonRepo.class);
//
////		Person p1 = new Person(3L, "John");
////		repo.save(p1);
//
//		Person p1r = repo.findById(3L).orElse(null);
//		System.out.println("p1r = " + p1r);
	}
}
