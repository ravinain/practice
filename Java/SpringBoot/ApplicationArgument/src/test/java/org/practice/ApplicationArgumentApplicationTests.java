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
public class ApplicationArgumentApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();
	
	@Test
	public void contextLoads() {
		ApplicationArgumentApplication.main(new String[]{"--debug", "logfile.txt"});
		String output = outputCapture.toString();
		
		assertNotNull(output);
		assertThat(output).contains("MyBean debug enabled: true");
		assertThat(output).contains("Files : [logfile.txt]");
	}
	
	@Test
	public void contextLoadsWithoutArgs() {
		ApplicationArgumentApplication.main(new String[0]);
		String output = outputCapture.toString();
		
		assertNotNull(output);
		assertThat(output).contains("MyBean debug enabled: false");
		assertThat(output).contains("Files : []");
	}

}
