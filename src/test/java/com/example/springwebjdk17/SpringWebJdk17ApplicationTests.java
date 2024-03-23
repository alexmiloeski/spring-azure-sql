package com.example.springwebjdk17;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringWebJdk17ApplicationTests {

	/*@BeforeAll
	public static void foo() {
		var dotenv = Dotenv.configure().load();
		dotenv.entries().forEach((entry) -> System.setProperty(entry.getKey(), entry.getValue()));
	}*/

	@Test
	public void contextLoads() {
	}

}
