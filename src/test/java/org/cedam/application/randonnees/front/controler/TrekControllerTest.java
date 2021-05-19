package org.cedam.application.randonnees.front.controler;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.cedam.application.randonnees.front.test.mock.Constante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TrekControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testTrekById() throws Exception {
		this.mockMvc.perform(get("/treks/" + Constante.TREK_TEST_ID_1)).andExpect(status().isOk())
				.andExpect(model().attributeExists("trek"));
		this.mockMvc.perform(get("/treksFalse")).andExpect(status().is4xxClientError());
	}

	@Test
	public void testUpdateTrek() throws Exception {
		this.mockMvc.perform(get("/treks/save/" + Constante.TREK_TEST_ID_1)).andExpect(status().isOk())
				.andExpect(model().attributeExists("trekForm"));
		this.mockMvc.perform(get("/treks/save/")).andExpect(status().isOk())
		.andExpect(model().attributeExists("trekForm"));
		this.mockMvc.perform(get("/treksFalse")).andExpect(status().is4xxClientError());
	}

//	@Test
//	public void testSaveTrek() throws Exception {
//		this.mockMvc.perform(post("/treks/save" + Constante.TREK_TEST_ID_1)).andExpect(status().isOk())
//				.andExpect(model().attributeExists("trek"));
//		this.mockMvc.perform(post("/treksFalse")).andExpect(status().is4xxClientError());
//	}

}
