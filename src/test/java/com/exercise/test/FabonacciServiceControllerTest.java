package com.exercise.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.exercise.controllers.FabonacciServiceController;

/**
 * Test class for controller.
 */
public class FabonacciServiceControllerTest {

	private final MockMvc mockMvc = standaloneSetup(new FabonacciServiceController())
			.build();

	@Test
	public void checkResponse1() throws Exception {

		mockMvc.perform(get("/fabonacci/20"))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.note").value("Numbers obtained."))
				.andExpect(jsonPath("$.fibNumbers[19]").value(4181))
				.andExpect(jsonPath("$.fibNumbers[10]").value(55))
				;
	}
	
}
