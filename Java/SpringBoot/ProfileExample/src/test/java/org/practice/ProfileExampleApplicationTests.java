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
public class ProfileExampleApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();
	
	@Test
	public void contextLoadsDefault() {
		ProfileExampleApplication.main(new String[0]);
		String output = outputCapture.toString();
		assertNotNull(output);
		assertThat(output).contains("192.168.0.1:8080");
	}
	
	@Test
	public void contextLoadsDev() {
		ProfileExampleApplication.main(new String[]{"--spring.profiles.active=dev"});
		String output = outputCapture.toString();
		assertNotNull(output);
		assertThat(output).contains("192.168.0.1:8080");
	}

	@Test
	public void contextLoadsStage() {
		ProfileExampleApplication.main(new String[]{"--spring.profiles.active=stage"});
		String output = outputCapture.toString();
		assertNotNull(output);
		assertThat(output).contains("192.168.0.2:8090");
	}
	
	@Test
	public void contextLoadsProd() {
		ProfileExampleApplication.main(new String[]{"--spring.profiles.active=prod"});
		String output = outputCapture.toString();
		assertNotNull(output);
		assertThat(output).contains("192.168.0.3:9090");
	}
}
