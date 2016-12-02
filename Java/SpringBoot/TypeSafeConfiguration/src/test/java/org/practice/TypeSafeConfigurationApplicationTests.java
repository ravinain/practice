package org.practice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TypeSafeConfigurationApplication.class})
public class TypeSafeConfigurationApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void contextLoads() {
		TypeSafeConfigurationApplication.main(new String[0]);
		String output = outputCapture.toString();
		assertNotNull(output);
		assertThat(output).contains("Name : Amit Age : 20");
	}
	
	@Test
	public void contextLoadsWithArgs() {
		TypeSafeConfigurationApplication.main(new String[]{"--person.name=Rajiv", "--person.age=32"});
		String output = outputCapture.toString();
		assertNotNull(output);
		assertThat(output).contains("Name : Rajiv Age : 32");
	}
}
