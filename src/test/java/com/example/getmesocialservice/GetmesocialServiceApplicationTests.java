package com.example.getmesocialservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.main.lazy-initialization=true",
		classes = {SpringRunner.class})
//@ContextConfiguration(locations = "classpath:WEB-INF/application-context.xml")
class GetmesocialServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
