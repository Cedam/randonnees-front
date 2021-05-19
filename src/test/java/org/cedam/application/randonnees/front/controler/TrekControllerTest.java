package org.cedam.application.randonnees.front.controler;
import java.util.Optional;

import org.cedam.application.randonnees.front.bean.TrekBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

@SpringBootTest
public class TrekControllerTest {

	@Autowired
	private TrekController trekController;
	
	@Autowired
	Model model;
	
	@Test
	public void testTrekById() {
		trekController.trekById(model, 0);
	}
	
	@Test
	public void testUpdateTrek() {
		trekController.updateTrek(model, Optional.of(0));
	}
	
	@Test
	public void testSaveTrek() {
		trekController.saveTrek(model, new TrekBean());
	}

}
