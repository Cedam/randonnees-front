package org.cedam.application.randonnees.front.controler;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AccueilControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testAccueil() throws Exception {
		this.mockMvc.perform(get("/accueil")).andExpect(status().isOk()).andExpect(model().attributeExists("treks"));
		this.mockMvc.perform(get("/accueilFalse")).andExpect(status().is4xxClientError());
	}

}
