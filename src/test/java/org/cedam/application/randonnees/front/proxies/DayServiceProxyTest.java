package org.cedam.application.randonnees.front.proxies;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.cedam.application.randonnees.front.bean.DayBean;
import org.cedam.application.randonnees.front.test.mock.Constante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DayServiceProxyTest {

	@Autowired
	private DayServiceProxy object;
	
	@Test
	public void testGetById() {
		long idDay = Constante.DAY_TEST_ID_1;
		DayBean day = object.getById(idDay);
		assertThat(idDay).isEqualTo(day.getId());
		
		assertThrows(Exception.class, () -> { object.getById(-1);});
	}
	
}
