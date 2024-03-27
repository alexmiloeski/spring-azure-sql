//package com.example.springwebjdk17;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class SpringWebJdk17ApplicationTests {
//
//	@Autowired
//	private TestRestTemplate template;
//
//	@LocalServerPort
//	private int port;
//
//	@Value("${CUSTOM_VALUE_1}")
//	private String myCustomValue1;
//
//	/*@BeforeAll
//	public static void foo() {
//		var dotenv = Dotenv.configure().load();
//		dotenv.entries().forEach((entry) -> System.setProperty(entry.getKey(), entry.getValue()));
//	}*/
//
//	@Test
//	public void contextLoads() {
//		System.out.println("myCustomValue1 = " + myCustomValue1);
//		String rez = template.getForObject("http://localhost:" + port, String.class);
//		System.out.println("rez = " + rez);
//		assertEquals("myCustomValue1=[" + myCustomValue1 + "]", rez);
//	}
//
//}
