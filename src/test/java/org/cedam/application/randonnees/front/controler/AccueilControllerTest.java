package org.cedam.application.randonnees.front.controler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

@SpringBootTest
public class AccueilControllerTest {

	@Autowired
	private AccueilController accueilController;
	
	@Autowired
	Model model;
	
	@Test
	public void testAccueil() {
		accueilController.accueil(model);
	}

}
