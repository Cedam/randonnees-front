package org.cedam.application.randonnees.front.controler;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.cedam.application.randonnees.front.bean.DayBean;
import org.cedam.application.randonnees.front.test.mock.Constante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DayControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testDayByIdGet() throws Exception {
		this.mockMvc.perform(get("/treks/" + Constante.TREK_TEST_ID_1 + "/days/" + Constante.DAY_TEST_ID_1)).andExpect(status().isOk()).andExpect(model().attributeExists("day"));
		// this.mockMvc.perform(get("/daysFalse")).andExpect(status().is4xxClientError());
	}

	@Test
	public void testNewDayGet() throws Exception {
		this.mockMvc.perform(get("/treks/" + Constante.TREK_TEST_ID_1 + "/days/new")).andExpect(status().isOk()).andExpect(model().attributeExists("dayForm"));
	}

	@Test
	public void testSaveDayGet() throws Exception {
		this.mockMvc.perform(get("/treks/" + Constante.TREK_TEST_ID_1 + "/days/save/" + Constante.DAY_TEST_ID_1)).andExpect(status().isOk())
				.andExpect(model().attributeExists("dayForm"));
	}

	@Test
	public void testSaveDayPost() throws Exception {
		this.mockMvc.perform(post("/treks/" + Constante.TREK_TEST_ID_1 + "/days/save").flashAttr("day", Constante.getDay())).andExpect(status().isOk())
				.andExpect(model().attributeDoesNotExist("errorMessage"));

		this.mockMvc.perform(post("/treks/" + Constante.TREK_TEST_ID_1 + "/days/save").flashAttr("day", new DayBean())).andExpect(status().isOk())
				.andExpect(model().attributeExists("errorMessage"));

	}

}
