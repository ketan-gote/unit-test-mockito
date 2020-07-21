package com.unittest.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
public class HelloWorldServiceTest {

	@Test
	public void helloWorld_Test(){
		HelloWorldService helloWorldService  = mock(HelloWorldService.class);
		when(helloWorldService.helloWorld()).thenReturn("Hello Ketan");
					
		String greetings = new HelloWorldService().helloWorld();
		assertEquals("Hello World", greetings);
	}
}
