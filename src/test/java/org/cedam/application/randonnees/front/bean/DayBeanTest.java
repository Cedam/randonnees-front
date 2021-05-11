package org.cedam.application.randonnees.front.bean;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DayBeanTest {


	@Test
	public void test() {
		var id = 1;
		var number = "number";
		var trek = new TrekBean();

		var day = new DayBean();
		day.setId(id);
		day.setNumber(number);
		day.setTrek(trek);

		assertThat(id).isEqualTo(day.getId());
		assertThat(number).isEqualTo(day.getNumber());
		assertThat(trek).isEqualTo(day.getTrek());
	}

}
