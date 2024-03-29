package com.example.springwebjdk17;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringWebJdk17ApplicationTests {

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    @Value("${mycustom.value1}")
    private String myCustomValue1;

    @Test
    public void getPersonByIdReturnsPersonsName() {
        String rez = template.getForObject("http://localhost:" + port + "/1", String.class);
        assertEquals("person's name=[Person1]", rez);
    }

    @Test
    public void customValueIsReadFromConfig() {
        assertEquals(myCustomValue1, "test-custom-value");
    }
}
