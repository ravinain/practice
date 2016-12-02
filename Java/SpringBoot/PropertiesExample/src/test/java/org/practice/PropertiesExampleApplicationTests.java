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
@SpringBootTest
public class PropertiesExampleApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();
	
	@Test
	public void contextLoads() {
		PropertiesExampleApplication.main(new String[0]);
		String output = outputCapture.toString();
		assertNotNull(output);
		assertThat(output).contains("Name : Rajveer");
	}

	@Test
	public void contextLoadsWithArgs() {
		PropertiesExampleApplication.main(new String[]{"--name=Ajay"});
		String output = outputCapture.toString();
		assertNotNull(output);
		assertThat(output).contains("Name : Ajay");
	}
}
